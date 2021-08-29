package tcc.cotuca.fiodanavalha.controller.cadastro;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tcc.cotuca.fiodanavalha.service.CadastroService;

import java.util.Map;

@CrossOrigin
@Controller
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @PostMapping(value = "cadastro-inicial")
    public ResponseEntity<HttpStatus> cadastroCliente(Map<String, String> headers, @NonNull @RequestBody ObjectNode body) {
        return this.cadastroService.cadastrarCliente(headers, body);
    }
}
