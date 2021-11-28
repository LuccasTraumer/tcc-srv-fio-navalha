package tcc.cotuca.fiodanavalha.gateway.home.cliente.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.gateway.home.cliente.ServicoSolicitadoGateway;
import tcc.cotuca.fiodanavalha.repository.ServicoSolicitadoRepository;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.servico.Servico;
import tcc.cotuca.fiodanavalha.to.servico.ServicoSolicitado;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoSolicitadoGatewayImpl implements ServicoSolicitadoGateway {
    @Autowired
    private ServicoSolicitadoRepository servicoSolicitadoRepository;

    @Autowired
    private ServicoGatewayImpl servicoGateway;

    @Override
    public List<Servico> buscarAgendamento(Cliente cliente) {
        var listaServicos  = servicoSolicitadoRepository.findAll();
        List<String> listaIdServicos = new ArrayList<>();
        List<Servico> response = new ArrayList<>();


        listaServicos.forEach(servicoSolicitado -> {
            if (servicoSolicitado.getIdCliente().equals(cliente.getId())) {
                listaIdServicos.add(servicoSolicitado.getIdServico().toString());
            }
        });

        listaIdServicos.forEach(idServico -> {
            var servico = servicoGateway.buscarServicoPorId(idServico);
            if (servico != null) {
                response.add(servico);
            }
        });

        return response;
    }

    @Override
    public Servico agendarServico(Cliente cliente, Barbearia barbearia, Servico servico) {
        var servicoSolicitado = new ServicoSolicitado();

        servicoSolicitado.setIdServico(Integer.valueOf(servico.getId()));
        servicoSolicitado.setIdBarbearia(barbearia.getId());
        servicoSolicitado.setIdCliente(cliente.getId());


        return null;
    }
}
