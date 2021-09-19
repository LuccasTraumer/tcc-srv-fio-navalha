package tcc.cotuca.fiodanavalha.service;

import tcc.cotuca.fiodanavalha.to.Barbearia;

import java.util.List;
import java.util.Optional;

public interface BarbeariaService {
    List<Barbearia> buscarTodasBarbearias();
    Optional<Barbearia> encontrarPorId(String id);
    Barbearia inserirBarbearia(Barbearia clienteVarejo);
    Barbearia editarBarbearia(Barbearia clienteBarbearia);
    void deletarBarbearia(String id);
}
