package tcc.cotuca.fiodanavalha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.exception.CadastroInvalidoException;
import tcc.cotuca.fiodanavalha.gateway.BarbeariaGateway;
import tcc.cotuca.fiodanavalha.gateway.ClienteGateway;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.Usuario;

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

    public ResponseEntity<HttpStatus> cadastrarCliente(Map<String, String> headers, Cliente cliente) {
        logger.info("Cadastrando Cliente {0}", cliente);

        if(!usuarioValido(cliente))
            throw new CadastroInvalidoException("Dados para cadastro do Cliente " + cliente + " Invalidos");

        clienteGateway.inserirCliente(cliente);
        return new ResponseEntity<>(CREATED);
    }

    public HttpStatus cadastrarBarbearia(Map<String, String> headers, Barbearia barbearia) {
        logger.info("Cadastrando Barbearia {0}", barbearia);

        if(!usuarioValido(barbearia))
            throw new CadastroInvalidoException("Dados para cadastro da Barbearia " + barbearia + " Invalidos");

        barbeariaGateway.inserirBarbearia(barbearia);
        return CREATED;
    }

    public ResponseEntity<HttpStatus> cadastrarBarbeiro(Map<String, String> headers, Barbearia barbearia) {
        logger.info("Cadastrando Barbearia {0}", barbearia);

        if(!usuarioValido(barbearia))
            throw new CadastroInvalidoException("Dados para cadastro do(a) Barbeiro(a) " + barbearia + " Invalidos");

        return new ResponseEntity<>(CREATED);
    }

    private boolean usuarioValido(Usuario usuario) {

        return true;
    }
}
