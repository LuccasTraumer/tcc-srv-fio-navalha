package tcc.cotuca.fiodanavalha.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.exception.LoginException;
import tcc.cotuca.fiodanavalha.gateway.impl.BarbeariaGatewayImpl;
import tcc.cotuca.fiodanavalha.gateway.impl.ClienteGatewayImpl;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.Usuario;
import tcc.cotuca.fiodanavalha.to.login.UserRequest;
import tcc.cotuca.fiodanavalha.to.login.UserResponse;

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

    public ResponseEntity<String> efetuarLogin(UserRequest usuario) {
        logger.info("Usuario à efetuar Login: {}", usuario);
        var mapper = new ObjectMapper();
        var usuarioBancoDados = buscarUsuario(usuario);
        if(usuarioBancoDados != null) {
            var headers = new HttpHeaders();
            var resp = "";
            try {
                resp = mapper.writeValueAsString(montarResponse(usuarioBancoDados));
                headers.set("jwtUser", resp);
            } catch (JsonProcessingException e) {
                logger.error("Erro ao tentar transformar em JSON!");
            }

            return new ResponseEntity<>(resp, headers, HttpStatus.OK);
        } else {
            throw new LoginException("Usuario ou senha invalidos!");
        }
    }

    private Usuario buscarUsuario(UserRequest usuario) {
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

    private UserResponse montarResponse(Usuario usuario) {
        var userResponse = new UserResponse();

        userResponse.setId(usuario.getId());
        userResponse.setEndereco(((Cliente) usuario).getEndereco());
        userResponse.setNome(usuario.getNome());
        userResponse.setFotoPerfil(usuario.getFotoPerfil());
        userResponse.setSaldoCliente(((Cliente) usuario).getSaldoCliente());
        userResponse.setTipoCliente(usuario.getClass());

        if (usuario.getEmail().isEmpty()) {
            userResponse.setTelefone(((Cliente) usuario).getTelefone());
        } else {
            userResponse.setEmail(((Cliente) usuario).getEmail());
        }

        return userResponse;
    }
}
