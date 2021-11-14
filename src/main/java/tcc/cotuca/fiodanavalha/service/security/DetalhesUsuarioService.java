//package tcc.cotuca.fiodanavalha.service.security;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import tcc.cotuca.fiodanavalha.gateway.impl.BarbeariaGatewayImpl;
//import tcc.cotuca.fiodanavalha.gateway.impl.ClienteGatewayImpl;
//import tcc.cotuca.fiodanavalha.to.Barbearia;
//import tcc.cotuca.fiodanavalha.to.Cliente;
//import tcc.cotuca.fiodanavalha.to.Usuario;
//
//@Component
//public class DetalhesUsuarioService implements UserDetailsService {
//
//    @Autowired
//    private ClienteGatewayImpl clienteGateway;
//
//    @Autowired
//    private BarbeariaGatewayImpl barbeariaGateway;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        var usuario = buscarUsuario(email);
//
//        if (usuario != null) {
//            return new User(email, usuario.getSenha(),
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("Usuario com Email: " + email + " não foi encontrado");
//        }
//    }
//
//    private Usuario buscarUsuario(String email) {
//        Usuario usuarioDataBase = null;
//
//        List<Barbearia> listaBarbearia = barbeariaGateway.buscarTodasBarbearias();
//
//        for (Barbearia barbearia: listaBarbearia) {
//            if(barbearia.getEmail().equals(email))
//                usuarioDataBase = barbearia;
//        }
//
//        if(usuarioDataBase == null) {
//            List<Cliente> listaCliente = clienteGateway.buscarTodosCliente();
//
//            for (Cliente cliente : listaCliente) {
//                if (cliente.getEmail().equals(email))
//                    usuarioDataBase = cliente;
//            }
//        }
//
//        return usuarioDataBase;
//    }
//}
