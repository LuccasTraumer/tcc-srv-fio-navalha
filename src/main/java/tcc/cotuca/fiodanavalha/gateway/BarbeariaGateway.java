package tcc.cotuca.fiodanavalha.gateway;

import tcc.cotuca.fiodanavalha.to.Barbearia;

import java.util.List;
import java.util.Optional;

public interface BarbeariaGateway {
    List<Barbearia> buscarTodasBarbearias();
    Optional<Barbearia> encontrarPorId(Long id);
    Barbearia inserirBarbearia(Barbearia clienteVarejo);
    Barbearia editarBarbearia(Barbearia clienteBarbearia);
    void deletarBarbearia(Long id);
}
