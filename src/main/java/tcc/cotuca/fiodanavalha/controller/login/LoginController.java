package tcc.cotuca.fiodanavalha.controller.login;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import tcc.cotuca.fiodanavalha.service.LoginService;
import tcc.cotuca.fiodanavalha.to.Usuario;

import java.util.Map;

@CrossOrigin
@Controller
public class LoginController {
    @Autowired
    private LoginService service;

    public ResponseEntity<Usuario> fazerLogin(final Map<String, String> headers,
                                     @NonNull @RequestBody final Usuario usuario) {

        return new ResponseEntity<>(service.efetuarLogin(usuario), HttpStatus.OK);
    }
}
