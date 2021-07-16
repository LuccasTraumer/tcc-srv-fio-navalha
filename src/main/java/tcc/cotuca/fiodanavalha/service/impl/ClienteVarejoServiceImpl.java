package tcc.cotuca.fiodanavalha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.exception.FioDaNavalhaException;
import tcc.cotuca.fiodanavalha.repository.ClienteVarejoRepository;
import tcc.cotuca.fiodanavalha.service.ClienteVarejoService;
import tcc.cotuca.fiodanavalha.to.ClienteVarejo;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteVarejoServiceImpl implements ClienteVarejoService {
    @Autowired
    ClienteVarejoRepository clienteVarejoRepository;


    @Override
    public List<ClienteVarejo> buscarTodosCliente() {
        return clienteVarejoRepository.findAll();
    }

    @Override
    public Optional<ClienteVarejo> buscarPorId(String id) {
        return clienteVarejoRepository.findById(id);
    }

    @Override
    public ClienteVarejo inserirCliente(ClienteVarejo clienteVarejo) {
        System.out.println(clienteVarejo);
        return clienteVarejoRepository.insert(clienteVarejo);
    }

    @Override
    public ClienteVarejo editarCliente(ClienteVarejo clienteVarejo) {
        Optional<ClienteVarejo> editado = buscarPorId(clienteVarejo.getId());
        if (editado.isPresent())
            clienteVarejoRepository.save(clienteVarejo);
        else
            throw new FioDaNavalhaException("Cliente não encontrado para edita-lo");

        return editado.get();
    }

    @Override
    public void deletarCliente(String id) {
        clienteVarejoRepository.deleteById(id);
    }
}
