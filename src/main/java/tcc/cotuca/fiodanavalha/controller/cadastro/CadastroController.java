package tcc.cotuca.fiodanavalha.controller.cadastro;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tcc.cotuca.fiodanavalha.service.CadastroService;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.Map;

@CrossOrigin
@Controller
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @PostMapping(value = "cadastro-cliente")
    public ResponseEntity<HttpStatus> cadastroCliente(final Map<String, String> headers,
                                                      @NonNull @RequestBody final Cliente cliente) {
        return this.cadastroService.cadastrarCliente(headers, cliente);
    }

    @PostMapping(value = "cadastro-barbearia")
    public ResponseEntity<HttpStatus> cadastroBarbearia(final Map<String, String> headers,
                                                        @NonNull @RequestBody final Barbearia barbearia) {
        return this.cadastroService.cadastrarBarbearia(headers, barbearia);
    }

    @PostMapping(value = "cadastro-barbeiro")
    public ResponseEntity<HttpStatus> cadastroBarbeiro(final Map<String, String> headers,
                                                        @NonNull @RequestBody final Barbearia barbearia) {
        return this.cadastroService.cadastrarBarbeiro(headers, barbearia);
    }
}
