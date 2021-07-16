package tcc.cotuca.fiodanavalha.service;

import tcc.cotuca.fiodanavalha.to.ClienteVarejo;

import java.util.List;
import java.util.Optional;

public interface ClienteVarejoService {
    List<ClienteVarejo> buscarTodosCliente();
    Optional<ClienteVarejo> buscarPorId(String id);
    ClienteVarejo inserirCliente(ClienteVarejo clienteVarejo);
    ClienteVarejo editarCliente(ClienteVarejo clienteVarejo);
    void deletarCliente(String id);
}
