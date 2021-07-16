package tcc.cotuca.fiodanavalha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.exception.FioDaNavalhaException;
import tcc.cotuca.fiodanavalha.repository.ClienteBarbeariaRepository;
import tcc.cotuca.fiodanavalha.service.ClienteBarbeariaService;
import tcc.cotuca.fiodanavalha.to.ClienteBarbearia;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteBarbeariaServiceImpl implements ClienteBarbeariaService {
    @Autowired
    private ClienteBarbeariaRepository clienteBarbeariaRepository;

    @Override
    public List<ClienteBarbearia> buscarTodasBarbearias() {
        return clienteBarbeariaRepository.findAll();
    }

    @Override
    public Optional<ClienteBarbearia> encontrarPorId(String id) {
        return clienteBarbeariaRepository.findById(id);
    }

    @Override
    public ClienteBarbearia inserirBarbearia(ClienteBarbearia clienteVarejo) {
        return clienteBarbeariaRepository.insert(clienteVarejo);
    }

    @Override
    public ClienteBarbearia editarBarbearia(ClienteBarbearia clienteBarbearia) {
        Optional<ClienteBarbearia> barbearia = this.encontrarPorId(clienteBarbearia.getId());
        if (barbearia.isPresent())
            clienteBarbeariaRepository.save(barbearia.get());
        else
            throw new FioDaNavalhaException("Barbearia não encontrada!");
        return barbearia.get();
    }

    @Override
    public void deletarBarbearia(String id) {
        clienteBarbeariaRepository.deleteById(id);
    }
}
