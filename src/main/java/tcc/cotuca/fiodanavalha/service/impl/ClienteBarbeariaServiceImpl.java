package tcc.cotuca.fiodanavalha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.repository.ClienteBarbeariaRepository;
import tcc.cotuca.fiodanavalha.service.ClienteBarbeariaService;
import tcc.cotuca.fiodanavalha.to.Barbearia;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteBarbeariaServiceImpl implements ClienteBarbeariaService {
    @Autowired
    private ClienteBarbeariaRepository clienteBarbeariaRepository;

    @Override
    public List<Barbearia> buscarTodasBarbearias() {
        return clienteBarbeariaRepository.findAll();
    }

    @Override
    public Optional<Barbearia> encontrarPorId(String id) {
        return clienteBarbeariaRepository.findById(id);
    }

    @Override
    public Barbearia inserirBarbearia(Barbearia clienteVarejo) {
        return clienteBarbeariaRepository.insert(clienteVarejo);
    }

    @Override
    public Barbearia editarBarbearia(Barbearia clienteBarbearia) {
        return clienteBarbeariaRepository.save(clienteBarbearia);
    }

    @Override
    public void deletarBarbearia(String id) {
        clienteBarbeariaRepository.deleteById(id);
    }
}
