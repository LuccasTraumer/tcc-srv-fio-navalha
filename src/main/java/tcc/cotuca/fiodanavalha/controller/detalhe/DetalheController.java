package tcc.cotuca.fiodanavalha.controller.detalhe;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tcc.cotuca.fiodanavalha.service.DetalheService;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@Controller
@RequestMapping("detalhe")
public class DetalheController {
    @Autowired
    private DetalheService detalheService;

    @PostMapping(value = "cliente")
    public ResponseEntity<Cliente> detalheCliente(final Map<String, String> headers,
                                         @NonNull @RequestBody final Cliente cliente) {
        return new ResponseEntity<>(detalheService.buscarDetalhesCliente(cliente), OK);
    }

    @PostMapping(value = "barbearia")
    public ResponseEntity<Barbearia> detalheBarbearia(final Map<String, String> headers,
                                                      @NonNull @RequestBody final Barbearia barbearia) {
        //TODO: Irá retornar Nome, Endereco, Contato, Descrição e Lista de Fotos.
        return new ResponseEntity<>(detalheService.buscarDetalhesBarbearia(barbearia), OK);
    }
}
