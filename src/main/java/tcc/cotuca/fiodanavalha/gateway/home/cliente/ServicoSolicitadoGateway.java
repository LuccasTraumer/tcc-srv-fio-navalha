package tcc.cotuca.fiodanavalha.gateway.home.cliente;

import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.servico.Servico;

import java.util.List;

public interface ServicoSolicitadoGateway {
    List<Servico> buscarAgendamento(Cliente cliente);
    Servico agendarServico(Cliente cliente, Barbearia barbearia, Servico servico);
}
