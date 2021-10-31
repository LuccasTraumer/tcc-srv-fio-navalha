package tcc.cotuca.fiodanavalha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.home.HomeBarbeariaResponse;
import tcc.cotuca.fiodanavalha.to.home.HomeClienteResponse;

import java.util.List;

@Component
@Service
public class HomeService {
    Logger logger = LoggerFactory.getLogger(HomeService.class);

    public List<HomeBarbeariaResponse> buscarListaDePedidoSolicitados(final Barbearia barbearia) {
        return null;
    }

    public List<HomeClienteResponse> buscarHomeCliente(final Cliente cliente) {
        return null;
    }
}
