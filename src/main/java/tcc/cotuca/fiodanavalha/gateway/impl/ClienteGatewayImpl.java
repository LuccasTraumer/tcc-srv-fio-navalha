package tcc.cotuca.fiodanavalha.gateway.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.repository.ClienteRepository;
import tcc.cotuca.fiodanavalha.gateway.ClienteGateway;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteGatewayImpl implements ClienteGateway {
    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public List<Cliente> buscarTodosCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente inserirCliente(Cliente clienteVarejo) {
        System.out.println(clienteVarejo);
        return clienteRepository.save(clienteVarejo);
    }

    @Override
    public Cliente editarCliente(Cliente clienteVarejo) {
        return clienteRepository.save(clienteVarejo);
    }

    @Override
    public void deletarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<Cliente> buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    @Override
    public Optional<Cliente> buscarPorTelefone(String telefone) {
        return clienteRepository.findByTelefone(telefone);
    }
}
