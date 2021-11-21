package tcc.cotuca.fiodanavalha.service;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.gateway.search.impl.SearchGatewayImpl;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.search.SearchResponse;

import java.util.List;
import java.util.Map;

@Component
@Service
public class BuscarService {
    Logger logger = LoggerFactory.getLogger(BuscarService.class);
    @Autowired
    private SearchGatewayImpl searchGateway;

    public List<Barbearia> buscarBarbearia(final Map<String, String> headers, @NonNull final String nomeBarbearia) {
        logger.info("Efetuando busca pela barbearia com nome: {} com os headers: {}", nomeBarbearia, headers);

        var response = searchGateway.buscarBarbeariaEspecifica(nomeBarbearia);
        logger.info("Response da busca pela barbearia {} é {}", nomeBarbearia, response);

        return response;
    }

    public SearchResponse exibirDados(final Map<String, String> headers) {
        var idCliente = Long.valueOf(headers.get("idCliente"));
        logger.info("Efetuando busca de dados para o cliente com id: {}. Headers: {}",  idCliente, headers);

        SearchResponse response = new SearchResponse();
        response.setListaBarbeariaFavorita(searchGateway.buscarListaBarbeariasFavoritasCliente(idCliente));
        response.setListaBarbeariaFiltro(searchGateway.buscarBarbeariasVisitadasCliente(idCliente));

        logger.info("Response da do endpoint para o cliente: {}", response);
        return response;
    }

}
