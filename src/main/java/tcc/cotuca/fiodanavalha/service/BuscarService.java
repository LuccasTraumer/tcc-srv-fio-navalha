package tcc.cotuca.fiodanavalha.service;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.gateway.impl.ClienteGatewayImpl;
import tcc.cotuca.fiodanavalha.gateway.search.impl.SearchGatewayImpl;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.search.SearchResponse;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Component
@Service
public class BuscarService {
    Logger logger = LoggerFactory.getLogger(BuscarService.class);
    @Autowired
    private SearchGatewayImpl searchGateway;

    @Autowired
    private ClienteGatewayImpl clienteGateway;

    public List<Barbearia> buscarBarbearia(final Map<String, String> headers, @NonNull final String nomeBarbearia) {
        logger.info("Efetuando busca pela barbearia com nome: {} com os headers: {}", nomeBarbearia, headers);

        var response = searchGateway.buscarBarbeariaEspecifica(nomeBarbearia);
        logger.info("Response da busca pela barbearia {} é {}", nomeBarbearia, response);

        return response;
    }

    public SearchResponse exibirDados(final Map<String, String> headers, final String email) {
        logger.info("Efetuando busca de dados para o cliente com id: {}. Headers: {}",  email, headers);

        var response = new SearchResponse();

        AtomicReference<Cliente> client = new AtomicReference<>();
        clienteGateway.buscarTodosCliente().forEach(cliente -> {
            if (cliente.getEmail().equals(email))
                client.set(cliente);
        });

        if (client.get() != null) {
            response.setListaBarbeariaFavorita(searchGateway.buscarListaBarbeariasFavoritasCliente((Long) client.get().getId()));
            response.setListaBarbeariaFiltro(searchGateway.buscarBarbeariasVisitadasCliente((Long) client.get().getId()));
        }

        logger.info("Response da do endpoint para o cliente: {}", response);
        return response;
    }

}
