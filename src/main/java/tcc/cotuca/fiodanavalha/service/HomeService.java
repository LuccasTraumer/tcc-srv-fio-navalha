package tcc.cotuca.fiodanavalha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.gateway.home.cliente.impl.ServicoSolicitadoGatewayImpl;
import tcc.cotuca.fiodanavalha.gateway.impl.BarbeariaGatewayImpl;
import tcc.cotuca.fiodanavalha.gateway.impl.ClienteGatewayImpl;
import tcc.cotuca.fiodanavalha.gateway.search.impl.SearchGatewayImpl;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.home.HomeBarbeariaResponse;
import tcc.cotuca.fiodanavalha.to.home.HomeClienteResponse;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Component
@Service
public class HomeService {
    Logger logger = LoggerFactory.getLogger(HomeService.class);

    @Autowired
    private ClienteGatewayImpl clienteGateway;

    @Autowired
    private BarbeariaGatewayImpl barbeariaGateway;

    @Autowired
    private SearchGatewayImpl searchGateway;

    @Autowired
    private ServicoSolicitadoGatewayImpl servicoSolicitadoGateway;

    //TODO: Buscar Lista de Pedido a serem confirmados e a lista de Horarios
    public HomeBarbeariaResponse buscarListaDePedidoSolicitados(final Map<String, String> headers,
                                                                      final Barbearia barbearia) {
        logger.info("Efetuando busca de dados para a Barbearia: {}. Headers: {}",  barbearia, headers);

        return null;
    }

    public HomeClienteResponse buscarHomeCliente(final Map<String, String> headers, final Cliente cliente) {
        logger.info("Efetuando busca de dados para o cliente: {}. Headers: {}",  cliente, headers);

        var response = new HomeClienteResponse();

        AtomicReference<Cliente> client = new AtomicReference<>();
        clienteGateway.buscarTodosCliente().forEach(clienteResponse -> {
            if (!cliente.getEmail().isEmpty() && clienteResponse.getEmail().equals(cliente.getEmail()))
                client.set(clienteResponse);
        });

        if (client.get() != null) {
            response.setListaBarbeariasFavotitas(searchGateway.buscarListaBarbeariasFavoritasCliente((Long) client.get().getId()));
            response.setListaBarbeariasVisitadas(searchGateway.buscarBarbeariasVisitadasCliente((Long) client.get().getId()));
            response.setListaDeServicos(servicoSolicitadoGateway.buscarAgendamento(cliente));
        }

        logger.info("Response da do endpoint para o cliente: {}", response);
        return response;
    }
}
