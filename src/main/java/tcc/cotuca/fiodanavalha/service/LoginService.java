package tcc.cotuca.fiodanavalha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.config.JwtUtils;
import tcc.cotuca.fiodanavalha.exception.LoginException;
import tcc.cotuca.fiodanavalha.gateway.impl.BarbeariaGatewayImpl;
import tcc.cotuca.fiodanavalha.gateway.impl.ClienteGatewayImpl;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.Usuario;
import tcc.cotuca.fiodanavalha.to.login.UserRequest;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@Component
@Service
public class LoginService {
    Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private ClienteGatewayImpl clienteGateway;

    @Autowired
    private BarbeariaGatewayImpl barbeariaGateway;

    public ResponseEntity<HttpStatus> efetuarLogin(Usuario usuario) {
        logger.info("Usuario à efetuar Login: {}", usuario);

        var usuarioBancoDados = buscarUsuario(usuario);
        if(usuarioBancoDados != null) {
            var jwtUser = JwtUtils.gerarToken((UserDetails) usuarioBancoDados);
            var headers = new HttpHeaders();
            headers.set("jwtUser", jwtUser);
            return new ResponseEntity<>(headers, HttpStatus.ACCEPTED);
        } else {
            throw new LoginException("Usuario ou senha invalidos!");
        }
    }

    private Usuario buscarUsuario(Usuario usuario) {
        AtomicReference<Usuario> user = new AtomicReference<>();

        List<Barbearia> listaBarbearia = barbeariaGateway.buscarTodasBarbearias();

        listaBarbearia.forEach(item -> {
            if (item.getEmail().equals(usuario.getEmail()) && item.getSenha().equals(usuario.getSenha()))
                user.set(item);
        });

        if(user.get() == null) {
            List<Cliente> listaCliente = clienteGateway.buscarTodosCliente();

            listaCliente.forEach(item -> {
                if (item.getEmail().equals(usuario.getEmail()) && item.getSenha().equals(usuario.getSenha()))
                    user.set(item);
            });
        }

        return user.get();
    }
}
