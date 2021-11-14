package tcc.cotuca.fiodanavalha.gateway.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.repository.BarbeariaRepository;
import tcc.cotuca.fiodanavalha.gateway.BarbeariaGateway;
import tcc.cotuca.fiodanavalha.to.Barbearia;

import java.util.List;
import java.util.Optional;

@Service
public class BarbeariaGatewayImpl implements BarbeariaGateway {
    @Autowired
    private BarbeariaRepository barbeariaRepository;

    @Override
    public List<Barbearia> buscarTodasBarbearias() {
        return barbeariaRepository.findAll();
    }

    @Override
    public Optional<Barbearia> encontrarPorId(Long id) {
        return barbeariaRepository.findById(id);
    }

    @Override
    public Barbearia inserirBarbearia(Barbearia clienteVarejo) {
        return barbeariaRepository.save(clienteVarejo);
    }

    @Override
    public Barbearia editarBarbearia(Barbearia clienteBarbearia) {
        return barbeariaRepository.save(clienteBarbearia);
    }

    @Override
    public void deletarBarbearia(Long id) {
        barbeariaRepository.deleteById(id);
    }

    @Override
    public Optional<Barbearia> buscarPorEmail(String email) {
        return barbeariaRepository.findByEmail(email);
    }

    @Override
    public Optional<Barbearia> buscarPorTelefone(String telefone) {
        return barbeariaRepository.findByTelefone(telefone);
    }
}
