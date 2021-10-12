package tcc.cotuca.fiodanavalha.controller.detalhe;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("detalhe")
public class DetalheController {

    @PostMapping(value = "cliente")
    public ResponseEntity<HttpStatus> detalheCliente(final Map<String, String> headers,
                                                      @NonNull @RequestBody final Cliente cliente) {
        //TODO: Irá retornar Nome, Endereco, Contato.
        return null;
    }

    @PostMapping(value = "barbearia")
    public ResponseEntity<HttpStatus> detalheBarbearia(final Map<String, String> headers,
                                                      @NonNull @RequestBody final Barbearia barbearia) {
        //TODO: Irá retornar Nome, Endereco, Contato, Descrição e Lista de Fotos.
        return null;
    }
}
