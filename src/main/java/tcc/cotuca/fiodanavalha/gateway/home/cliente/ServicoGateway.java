package tcc.cotuca.fiodanavalha.gateway.home.cliente;

import tcc.cotuca.fiodanavalha.to.servico.Servico;


public interface ServicoGateway {
    Servico buscarServicoPorId(String idServico);
}
