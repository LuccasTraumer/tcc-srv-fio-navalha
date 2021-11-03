package tcc.cotuca.fiodanavalha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.exception.FioDaNavalhaException;
import tcc.cotuca.fiodanavalha.gateway.impl.BarbeariaGatewayImpl;
import tcc.cotuca.fiodanavalha.gateway.impl.ClienteGatewayImpl;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;


@Component
@Service
public class DetalheService {
    Logger logger = LoggerFactory.getLogger(DetalheService.class);
    @Autowired
    private ClienteGatewayImpl clienteGateway;

    @Autowired
    private BarbeariaGatewayImpl barbeariaGateway;

    public Cliente buscarDetalhesCliente(Cliente cliente) {
        logger.info("Cliente que esta efetuando consulta é: {0}", cliente);
        try {
            System.out.println(cliente);
//            return clienteGateway.buscarPorId(cliente.getId()).get();
            return new Cliente();
        } catch (NullPointerException e) {
            throw new FioDaNavalhaException("Não foi possivel buscar por este Cliente!");
        } catch (Exception e) {
            throw new FioDaNavalhaException("Não foi possivel manter comunicação com Banco de Dados!");
        }
    }

    public Barbearia buscarDetalhesBarbearia(Barbearia barbearia) {
        logger.info("Cliente que esta efetuando consulta é: {0}", barbearia);
        try {
            return null;
//            return barbeariaGateway.encontrarPorId(barbearia.getId()).get();
        } catch (NullPointerException e) {
//            logger.error(ERROR, "Nullpointer ao tentar pegar cliente do Optional, mensagem: {0}", e.getMessage());
            throw new FioDaNavalhaException("Não foi possivel buscar por esta Barbearia!");
        } catch (Exception e) {
//            logger.error(ERROR, "Erro generico ao tentar pegar cliente do Optional, mensagem: {0}", e.getMessage());
            throw new FioDaNavalhaException("Não foi possivel manter comunicação com Banco de Dados!");
        }
    }
}
