package tcc.cotuca.fiodanavalha.gateway.search;

import tcc.cotuca.fiodanavalha.to.Barbearia;

import java.util.List;

public interface SearchGateway {
    List<Barbearia> buscarListaBarbeariasFavoritasCliente(Long idCliente);

    List<Barbearia> buscarBarbeariasVisitadasCliente(Long id);

    List<Barbearia> buscarBarbeariaEspecifica(String nome);
}
