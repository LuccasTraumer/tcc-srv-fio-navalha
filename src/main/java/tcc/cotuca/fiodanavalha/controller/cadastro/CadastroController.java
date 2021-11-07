package tcc.cotuca.fiodanavalha.controller.cadastro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("cadastro")
@Api("Cadastro")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @ApiOperation("Criação de um Cliente")
    @PostMapping(value = "cliente")
    public ResponseEntity<HttpStatus> cadastroCliente(final Map<String, String> headers,
                                                      @NonNull @RequestBody final Cliente cliente) {
        return new ResponseEntity<>(this.cadastroService.cadastrarCliente(headers, cliente));
    }

    @PostMapping(value = "barbearia")
    public ResponseEntity<HttpStatus> cadastroBarbearia(final Map<String, String> headers,
                                                        @NonNull @RequestBody final Barbearia barbearia) {
        return new ResponseEntity<>(this.cadastroService.cadastrarBarbearia(headers, barbearia));
    }

    @PostMapping(value = "barbeiro")
    public ResponseEntity<HttpStatus> cadastroBarbeiro(final Map<String, String> headers,
                                                        @NonNull @RequestBody final Barbearia barbearia) {
        return new ResponseEntity<>(this.cadastroService.cadastrarBarbeiro(headers, barbearia));
    }
}
