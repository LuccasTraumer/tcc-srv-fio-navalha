package tcc.cotuca.fiodanavalha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.exception.AutenticacaoException;
import tcc.cotuca.fiodanavalha.gateway.impl.BarbeariaGatewayImpl;
import tcc.cotuca.fiodanavalha.gateway.impl.ClienteGatewayImpl;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.perfil.PerfilResponse;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Component
@Service
public class PerfilService {
    Logger logger = LoggerFactory.getLogger(PerfilService.class);

    @Autowired
    private ClienteGatewayImpl clienteGateway;

    @Autowired
    private BarbeariaGatewayImpl barbeariaGateway;

    public PerfilResponse buscarDadosCliente(final Map<String, String> headers, final String email) {
        logger.info("Verificando dados do Cliente com email: {} com Headers: {}", email, headers);
        AtomicReference<PerfilResponse> response = new AtomicReference<>();

        clienteGateway.buscarTodosCliente().forEach(cliente -> {
                    if (cliente.getEmail().equals(email)) {
                        if (cliente.getEmail().isEmpty()) {
                            response.set(new PerfilResponse(cliente.getNome(), cliente.getEndereco(), null,
                                    cliente.getTelefone(), cliente.getFotoPerfil()));
                        } else {
                            response.set(new PerfilResponse(cliente.getNome(), cliente.getEndereco(), cliente.getEmail(),
                                    null, cliente.getFotoPerfil()));
                        }
                    }
        });

        if(response == null && response.get() == null) {
            logger.error("Erro ao tentar buscar os dados do cliente com email: {}", email);
            throw new AutenticacaoException("Usuario não encontrado!");
        } else {
            return response.get();
        }
    }

    public Barbearia buscarDadosBarbearia(final Map<String, String> headers, final String email) {
        logger.info("Verificando dados do Cliente com email: {} com Headers: {}", email, headers);
        AtomicReference<Barbearia> barbeariaResponse = new AtomicReference<>();

        barbeariaGateway.buscarTodasBarbearias().forEach(barbearia -> {
            if (barbearia.getEmail().equals(email))
                barbeariaResponse.set(barbearia);
        });

        if(barbeariaResponse.get() == null) {
            logger.error("Erro ao tentar buscar os dados do cliente com email: {}", email);
            throw new AutenticacaoException("Usuario não encontrado!");
        } else {
            return barbeariaResponse.get();
        }
    }

}
