package tcc.cotuca.fiodanavalha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.repository.ClienteRepository;
import tcc.cotuca.fiodanavalha.service.ClienteService;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;


    @Override
    public List<Cliente> buscarTodosCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(String id) {
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
    public void deletarCliente(String id) {
        clienteRepository.deleteById(id);
    }
}
