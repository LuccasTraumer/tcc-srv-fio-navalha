package tcc.cotuca.fiodanavalha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.to.servico.ServicoSolicitado;

import java.util.List;

@Component
@Service
public class HomeService {
    Logger logger = LoggerFactory.getLogger(HomeService.class);

    public List<ServicoSolicitado> buscarListaDePedidoSolicitados() {
        return null;
    }
}
