package tcc.cotuca.fiodanavalha.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tcc.cotuca.fiodanavalha.service.BuscarService;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.search.SearchResponse;

import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping
public class SearchController {
    @Autowired
    private BuscarService service;

    @GetMapping("/search")
    public SearchResponse exibirDados(final Map<String, String> headers) {
        return service.exibirDados(headers);
    }

    @GetMapping("/search/")
    public List<Barbearia> buscarBarbearia(final Map<String, String> headers,
                                           @RequestParam(value = "nome", required = false) String nomeBarbearia) {
        return service.buscarBarbearia(headers, nomeBarbearia);
    }
}
