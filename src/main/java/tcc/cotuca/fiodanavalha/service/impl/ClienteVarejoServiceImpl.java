package tcc.cotuca.fiodanavalha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.repository.ClienteVarejoRepository;
import tcc.cotuca.fiodanavalha.service.ClienteVarejoService;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteVarejoServiceImpl implements ClienteVarejoService {
    @Autowired
    ClienteVarejoRepository clienteVarejoRepository;


    @Override
    public List<Cliente> buscarTodosCliente() {
        return clienteVarejoRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(String id) {
        return clienteVarejoRepository.findById(id);
    }

    @Override
    public Cliente inserirCliente(Cliente clienteVarejo) {
        System.out.println(clienteVarejo);
        return clienteVarejoRepository.insert(clienteVarejo);
    }

    @Override
    public Cliente editarCliente(Cliente clienteVarejo) {
        return clienteVarejoRepository.save(clienteVarejo);
    }

    @Override
    public void deletarCliente(String id) {
        clienteVarejoRepository.deleteById(id);
    }
}
