package tcc.cotuca.fiodanavalha.gateway.search.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.gateway.impl.BarbeariaGatewayImpl;
import tcc.cotuca.fiodanavalha.gateway.search.SearchGateway;
import tcc.cotuca.fiodanavalha.repository.FavoritoRepository;
import tcc.cotuca.fiodanavalha.repository.ServicoRealizadoRepository;
import tcc.cotuca.fiodanavalha.to.Barbearia;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class SearchGatewayImpl implements SearchGateway {
    @Autowired
    private FavoritoRepository repository;

    @Autowired
    private ServicoRealizadoRepository servicoRealizadoRepository;

    @Autowired
    private BarbeariaGatewayImpl barbeariaGateway;

    @Override
    public List<Barbearia> buscarListaBarbeariasFavoritasCliente(final Long idCliente) {
        var favoritos = repository.findAll();

        if(favoritos.isEmpty())
            return null;

        var ret = new ArrayList<Barbearia>();
        favoritos.forEach(item -> {
            if(item.getCliente().getId().equals(idCliente))
                ret.add(item.getBarbearia());
        });

        return ret;
    }

    @Override
    public List<Barbearia> buscarBarbeariasVisitadasCliente(final Long idCliente) {
        var listaServicio = servicoRealizadoRepository.findAll();


        List<Barbearia> listaBarbeariaVisitadas = new ArrayList<>();
        listaServicio.forEach(servico -> {
            if(servico.getIdCliente().equals(idCliente)) {
                listaBarbeariaVisitadas.add(efetuarBuscaBarbearia(servico.getIdBarbearia()));
            }
        });

        return listaBarbeariaVisitadas;
    }

    @Override
    public List<Barbearia> buscarBarbeariaEspecifica(String nome) {
        var listaBarbearias = barbeariaGateway.buscarTodasBarbearias();

        var lista = listaBarbearias
                .stream()
                .filter(barbearia -> barbearia.getNome().toLowerCase(Locale.ROOT).contains(nome))
                .sorted();

        return lista.collect(Collectors.toList());
    }

    private Barbearia efetuarBuscaBarbearia(final Long idBarbearia) {
        var listaBarbearias = barbeariaGateway.buscarTodasBarbearias();

        var optionalBarbearia = listaBarbearias
                .stream()
                .filter(barber -> barber.getId().equals(idBarbearia))
                .findFirst();

        return optionalBarbearia.orElse(null);
    }
}
