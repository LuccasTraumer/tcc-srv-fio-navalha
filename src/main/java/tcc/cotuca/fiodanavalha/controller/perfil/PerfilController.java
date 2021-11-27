package tcc.cotuca.fiodanavalha.controller.perfil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tcc.cotuca.fiodanavalha.service.PerfilService;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.perfil.PerfilRequest;
import tcc.cotuca.fiodanavalha.to.perfil.PerfilResponse;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@Controller
@RequestMapping("perfil")
public class PerfilController {
    @Autowired
    private PerfilService service;

    @PostMapping(value = "cliente")
    public ResponseEntity<PerfilResponse> buscarDadosCliente(final Map<String, String> headers,
                                             @RequestBody final PerfilRequest request) {
        return new ResponseEntity<>(service.buscarDadosCliente(headers, request.getEmail()), OK);
    }

    @PostMapping(value = "barbearia")
    public ResponseEntity<Barbearia> buscarDadosBarbearia(final Map<String, String> headers,
                                                          @RequestBody final PerfilRequest request) {
        return new ResponseEntity<>(service.buscarDadosBarbearia(headers, request.getEmail()), OK);
    }
}
