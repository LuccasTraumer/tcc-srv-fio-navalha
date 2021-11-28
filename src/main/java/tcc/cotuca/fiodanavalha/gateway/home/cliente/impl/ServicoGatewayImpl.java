package tcc.cotuca.fiodanavalha.gateway.home.cliente.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.gateway.home.cliente.ServicoGateway;
import tcc.cotuca.fiodanavalha.repository.ServicoRepository;
import tcc.cotuca.fiodanavalha.to.servico.Servico;

@Service
public class ServicoGatewayImpl implements ServicoGateway {
    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public Servico buscarServicoPorId(String idServico) {
        return servicoRepository.findById(idServico).isPresent() ? servicoRepository.findById(idServico).get() : null;
    }
}
