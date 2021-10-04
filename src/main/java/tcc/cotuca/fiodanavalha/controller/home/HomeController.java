package tcc.cotuca.fiodanavalha.controller.home;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.Map;

@CrossOrigin
@Controller
public class HomeController {

    @PostMapping(value = "buscar-barbearias")
    public ResponseEntity<HttpStatus> buscarBarbearias(final Map<String, String> headers,
                                                      @NonNull @RequestBody final Cliente cliente) {
        return null;
    }
}
