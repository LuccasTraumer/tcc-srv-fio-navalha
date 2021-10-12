package tcc.cotuca.fiodanavalha.gateway;

import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {
    List<Cliente> buscarTodosCliente();
    Optional<Cliente> buscarPorId(String id);
    Cliente inserirCliente(Cliente clienteVarejo);
    Cliente editarCliente(Cliente clienteVarejo);
    void deletarCliente(String id);
}
