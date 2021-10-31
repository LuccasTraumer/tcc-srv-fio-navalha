package tcc.cotuca.fiodanavalha.controller.home;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("home")
public class HomeController {

    @GetMapping(value = "barbearia")
    public ResponseEntity<HttpStatus> homeBarbearia(final Map<String, String> headers,
                                                      @NonNull @RequestBody final Barbearia barbearia) {
        //TODO: Buscar Lista de Pedido a serem confirmados e a lista de Horarios
        return null;
    }

    @GetMapping(value = "cliente")
    public ResponseEntity<HttpStatus> homeCliente(final Map<String, String> headers,
                                                       @NonNull @RequestBody final Cliente cliente) {

        //TODO: Buscar as Listas de Horarios agendados, Barbearias Visitadas e barbearias favoritas

        return null;
    }
}
