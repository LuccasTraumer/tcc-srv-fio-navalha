package tcc.cotuca.fiodanavalha.gateway;

import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteGateway {
    List<Cliente> buscarTodosCliente();
    Optional<Cliente> buscarPorId(Long id);
    Cliente inserirCliente(Cliente clienteVarejo);
    Cliente editarCliente(Cliente clienteVarejo);
    void deletarCliente(Long id);
    Optional<Cliente> buscarPorEmail(String email);
    Optional<Cliente> buscarPorTelefone(String telefone);
}
