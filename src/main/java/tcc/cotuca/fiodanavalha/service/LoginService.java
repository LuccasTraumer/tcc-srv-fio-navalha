package tcc.cotuca.fiodanavalha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.exception.LoginException;
import tcc.cotuca.fiodanavalha.gateway.impl.BarbeariaGatewayImpl;
import tcc.cotuca.fiodanavalha.gateway.impl.ClienteGatewayImpl;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.Usuario;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
@Service
public class LoginService {
    Logger logger = LoggerFactory.getLogger(LoginService.class);
    @Autowired
    private ClienteGatewayImpl clienteGateway;

    @Autowired
    private BarbeariaGatewayImpl barbeariaGateway;

    public Usuario efetuarLogin(Usuario usuario) {
        logger.info("Usuario à efetuar Login: {}", usuario);

        if(usuarioCadastrado(usuario)) {
            pegarUsuario(usuario);
            return null;
        } else {
            throw new LoginException("Usuario ou senha invalidos!");
        }
    }

    private boolean usuarioCadastrado(Usuario usuario) {
        var usuarioCadastrado = new AtomicBoolean(false);
        if (isBarbearia(usuario)) {
            List<Barbearia> listaBarbearia = barbeariaGateway.buscarTodasBarbearias();

            listaBarbearia.forEach(item -> {
                if (item.getEmail().equals(usuario.getEmail()) && item.getSenha().equals(usuario.getSenha()))
                    usuarioCadastrado.set(true);
            });
        } else {
            List<Cliente> listaCliente = clienteGateway.buscarTodosCliente();

            listaCliente.forEach(item -> {
                if (item.getEmail().equals(usuario.getEmail()) && item.getSenha().equals(usuario.getSenha()))
                    usuarioCadastrado.set(true);
            });
        }
        return usuarioCadastrado.get();
    }

    private Usuario pegarUsuario(Usuario usuario) {
        Usuario usuarioCadastrado = null;
        if (isBarbearia(usuario)) {
            List<Barbearia> listaBarbearia = barbeariaGateway.buscarTodasBarbearias();

            while(listaBarbearia.iterator().hasNext()) {
                if(listaBarbearia.iterator().next().getEmail().equals(usuario.getEmail()) &&
                        listaBarbearia.iterator().next().getSenha().equals(usuario.getSenha()))
                        usuarioCadastrado = listaBarbearia.iterator().next();
            }
        } else {
            List<Cliente> listaCliente = clienteGateway.buscarTodosCliente();

            while(listaCliente.iterator().hasNext()) {
                if(listaCliente.iterator().next().getEmail().equals(usuario.getEmail()) &&
                        listaCliente.iterator().next().getSenha().equals(usuario.getSenha()))
                    usuarioCadastrado = listaCliente.iterator().next();
            }
        }
        return usuarioCadastrado;
    }

    private boolean isBarbearia(Usuario usuario) {
        return usuario.getClass().equals(Barbearia.class);
    }
}
