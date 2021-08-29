package tcc.cotuca.fiodanavalha.service;

import tcc.cotuca.fiodanavalha.to.ClienteBarbearia;

import java.util.List;
import java.util.Optional;

public interface ClienteBarbeariaService {
    List<ClienteBarbearia> buscarTodasBarbearias();
    Optional<ClienteBarbearia> encontrarPorId(String id);
    ClienteBarbearia inserirBarbearia(ClienteBarbearia clienteVarejo);
    ClienteBarbearia editarBarbearia(ClienteBarbearia clienteBarbearia);
    void deletarBarbearia(String id);
}
