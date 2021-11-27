package tcc.cotuca.fiodanavalha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.exception.CadastroInvalidoException;
import tcc.cotuca.fiodanavalha.gateway.BarbeariaGateway;
import tcc.cotuca.fiodanavalha.gateway.ClienteGateway;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
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

    public HttpStatus cadastrarCliente(final Map<String, String> headers, final Cliente cliente) {
        logger.info("Cadastrando Cliente {}", cliente);

        if(!USUARIO_VALIDO(cliente))
            throw new CadastroInvalidoException("Dados para cadastro do Cliente " + cliente + " Invalidos");

        Cliente clone = (Cliente) GERAR_USUARIO(cliente);

        clienteGateway.inserirCliente(clone);
        return CREATED;
    }

    public HttpStatus cadastrarBarbearia(Map<String, String> headers, Barbearia barbearia) {
        logger.info("Cadastrando Barbearia {}. Headers: {}", barbearia, headers);

        if(!USUARIO_VALIDO(barbearia))
            throw new CadastroInvalidoException("Dados para cadastro da Barbearia " + barbearia + " Invalidos");

        Barbearia clone = (Barbearia) GERAR_USUARIO(barbearia);

        barbeariaGateway.inserirBarbearia(clone);
        return CREATED;
    }

    public HttpStatus cadastrarBarbeiro(Map<String, String> headers, Barbearia barbeiro) {
        logger.info("Cadastrando Barbearia {}. Headers: {}", barbeiro, headers);

        if(!USUARIO_VALIDO(barbeiro))
            throw new CadastroInvalidoException("Dados para cadastro do(a) Barbeiro(a) " + barbeiro + " Invalidos");

        return CREATED;
    }

 }
