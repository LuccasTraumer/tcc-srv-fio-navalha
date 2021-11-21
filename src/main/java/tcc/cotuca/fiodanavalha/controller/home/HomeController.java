package tcc.cotuca.fiodanavalha.controller.home;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tcc.cotuca.fiodanavalha.service.HomeService;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.home.HomeBarbeariaResponse;
import tcc.cotuca.fiodanavalha.to.home.HomeClienteResponse;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@CrossOrigin
@Controller
@RequestMapping("home")
public class HomeController {
    @Autowired
    private HomeService service;

    @GetMapping(value = "barbearia")
    public ResponseEntity<List<HomeBarbeariaResponse>> homeBarbearia(final Map<String, String> headers,
                                                                     @NonNull @RequestBody final Barbearia barbearia) {


        return new ResponseEntity<>(service.buscarListaDePedidoSolicitados(barbearia), OK);
    }

    @GetMapping(value = "cliente")
    public ResponseEntity<List<HomeClienteResponse>> homeCliente(final Map<String, String> headers,
                                                                 @NonNull @RequestBody final Cliente cliente) {

        return new ResponseEntity<>(service.buscarHomeCliente(cliente), OK);
    }
}
