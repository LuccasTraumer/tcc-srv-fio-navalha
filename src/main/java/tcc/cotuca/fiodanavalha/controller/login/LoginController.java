package tcc.cotuca.fiodanavalha.controller.login;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import tcc.cotuca.fiodanavalha.service.LoginService;
import tcc.cotuca.fiodanavalha.to.Usuario;
import tcc.cotuca.fiodanavalha.to.login.UserRequest;


@CrossOrigin
@Controller
@RequestMapping
public class LoginController {
    @Autowired
    private LoginService service;

    @PostMapping("login")
    public ResponseEntity<HttpStatus> fazerLogin(@NonNull @RequestBody final UserRequest usuario) {

        return service.efetuarLogin(usuario);
    }
}
