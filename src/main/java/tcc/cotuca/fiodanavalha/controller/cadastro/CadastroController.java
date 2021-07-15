package tcc.cotuca.fiodanavalha.controller.cadastro;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tcc.cotuca.fiodanavalha.service.CadastroService;

import java.util.Map;

@CrossOrigin
@Controller
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;

    @RequestMapping(value = "cadastro-inicial", method = RequestMethod.POST)
    public ResponseEntity<HttpStatus> cadastro(Map<String, String> headers, @NonNull @RequestBody JsonNode body) {
        return this.cadastroService.cadastrarCliente(headers, body);
    }
}
