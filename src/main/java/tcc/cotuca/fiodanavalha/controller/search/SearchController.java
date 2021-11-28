package tcc.cotuca.fiodanavalha.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tcc.cotuca.fiodanavalha.service.BuscarService;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.search.SearchRequest;
import tcc.cotuca.fiodanavalha.to.search.SearchResponse;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@Controller
@RequestMapping
public class SearchController {
    @Autowired
    private BuscarService service;

    @PostMapping("/search")
    public ResponseEntity<SearchResponse> exibirDados(final Map<String, String> headers, @RequestBody SearchRequest request) {
        return new ResponseEntity<>(service.exibirDados(headers, request.getEmail()), OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Barbearia>> buscarBarbearia(final Map<String, String> headers,
                                           @RequestParam(value = "nome", required = false) String nomeBarbearia) {
        return new ResponseEntity<>(service.buscarBarbearia(headers, nomeBarbearia), OK);
    }
}
