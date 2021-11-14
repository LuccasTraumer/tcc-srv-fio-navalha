package tcc.cotuca.fiodanavalha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import tcc.cotuca.fiodanavalha.exception.CadastroInvalidoException;
import tcc.cotuca.fiodanavalha.gateway.BarbeariaGateway;
import tcc.cotuca.fiodanavalha.gateway.ClienteGateway;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.Usuario;
import static tcc.cotuca.fiodanavalha.utils.ValidarUsuario.*;

import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;


@Component
@Service
public class CadastroService {
    Logger logger = LoggerFactory.getLogger(CadastroService.class);

    @Autowired
    private ClienteGateway clienteGateway;

    @Autowired
    private BarbeariaGateway barbeariaGateway;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public HttpStatus cadastrarCliente(Map<String, String> headers, Cliente cliente) {
        cliente.setSenha(passwordEncoder.encode(cliente.getPassword()));
        logger.info("Cadastrando Cliente {0}", cliente);

        if(!USUARIO_VALIDO(cliente))
            throw new CadastroInvalidoException("Dados para cadastro do Cliente " + cliente + " Invalidos");

        Cliente clone = (Cliente) GERAR_USUARIO(cliente);

//        clienteGateway.inserirCliente(clone);
        return CREATED;
    }

    public HttpStatus cadastrarBarbearia(Map<String, String> headers, Barbearia barbearia) {
        barbearia.setSenha(passwordEncoder.encode(barbearia.getPassword()));
        logger.info("Cadastrando Barbearia {0}", barbearia);

        if(!USUARIO_VALIDO(barbearia))
            throw new CadastroInvalidoException("Dados para cadastro da Barbearia " + barbearia + " Invalidos");

        Barbearia clone = (Barbearia) GERAR_USUARIO(barbearia);

        barbeariaGateway.inserirBarbearia(clone);
        return CREATED;
    }

    public HttpStatus cadastrarBarbeiro(Map<String, String> headers, Barbearia barbeiro) {
        barbeiro.setSenha(passwordEncoder.encode(barbeiro.getPassword()));
        logger.info("Cadastrando Barbearia {0}", barbeiro);

        if(!USUARIO_VALIDO(barbeiro))
            throw new CadastroInvalidoException("Dados para cadastro do(a) Barbeiro(a) " + barbeiro + " Invalidos");

        return CREATED;
    }

    public ResponseEntity<Boolean> validarSenha(@RequestParam String login,
                                                @RequestParam String password) {

        Usuario optUsuario =  barbeariaGateway.buscarPorEmail(login).isPresent() ? barbeariaGateway.buscarPorEmail(login).get() : null;
        if (optUsuario == null) {
            optUsuario = clienteGateway.buscarPorEmail(login).isPresent() ? clienteGateway.buscarPorEmail(login).get() : null;

            if (optUsuario == null)
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);

        }

        Usuario usuario = optUsuario;
        boolean valid = passwordEncoder.matches(password, usuario.getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }

 }
