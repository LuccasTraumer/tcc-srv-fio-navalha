package tcc.cotuca.fiodanavalha.utils;

import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.Usuario;

import java.time.LocalDate;

public class ValidarUsuario {

    private ValidarUsuario() {}

    public static boolean USUARIO_VALIDO(Usuario usuario) {
        var isValid = false;

        if (VALIDAR_CAMPOS_COMUM(usuario)) {
            if(usuario.getClass().equals(Cliente.class)) {
                var cliente = (Cliente) usuario;

                isValid = cliente.getSaldoCliente() != null &&
                        cliente.getNotaCliente() != null &&
                        cliente.getReputacao() != null;
            } else if(usuario.getClass().equals(Barbearia.class)) {
                isValid = ((Barbearia) usuario).getCnpj() != null;
            }
        }

        return isValid;
    }

    private static boolean VALIDAR_CAMPOS_COMUM(Usuario usuario) {
        return usuario.getEndereco() != null && usuario.getNome() != null &&
                (usuario.getEmail() != null || usuario.getTelefone() != null) &&
                usuario.getFotoPerfil() != null && usuario.getSenha() != null &&
                usuario.getDataNascimento() != null;
    }

    public static Usuario GERAR_USUARIO(Usuario usuario) {
        Usuario clone = null;
        if(usuario.getClass().equals(Cliente.class)) {
            clone = new Cliente();
            ((Cliente) clone).setSaldoCliente(((Cliente) usuario).getSaldoCliente());
            ((Cliente) clone).setNotaCliente(((Cliente) usuario).getNotaCliente());
            ((Cliente) clone).setReputacao(((Cliente) usuario).getReputacao());
            ((Cliente) clone).setEndereco(((Cliente) usuario).getEndereco());
            ((Cliente) clone).setNome(((Cliente) usuario).getNome());
            ((Cliente) clone).setCpf(((Cliente) usuario).getCpf());
            ((Cliente) clone).setFotoPerfil(((Cliente) usuario).getFotoPerfil());
            ((Cliente) clone).setSenha(((Cliente) usuario).getSenha());
            ((Cliente) clone).setDataNascimento(((Cliente) usuario).getDataNascimento());
            ((Cliente) clone).setDataCadastro(LocalDate.now());
            ((Cliente) clone).generatedId(usuario);

            if (usuario.getEmail().isEmpty()) {
                ((Cliente) clone).setTelefone(((Cliente) usuario).getTelefone());
            } else {
                ((Cliente) clone).setEmail(((Cliente) usuario).getEmail());
            }
        } else if(usuario.getClass().equals(Barbearia.class)) {
            clone = new Barbearia();
            ((Barbearia) clone).getEnderecos().add(usuario.getEndereco());
            ((Barbearia) clone).setEndereco(usuario.getEndereco());
            ((Barbearia) clone).setNome(usuario.getNome());
            ((Barbearia) clone).setCnpj(((Barbearia) usuario).getCnpj());
            ((Barbearia) clone).setFotoPerfil(usuario.getFotoPerfil());
            ((Barbearia) clone).setSenha(usuario.getSenha());
            ((Barbearia) clone).setDataNascimento(usuario.getDataNascimento());
            ((Barbearia) clone).setDataCadastro(LocalDate.now());
            ((Barbearia) clone).generatedId(usuario);

            if (usuario.getEmail().isEmpty()) {
                ((Barbearia) clone).setTelefone(usuario.getTelefone());
            } else {
                ((Barbearia) clone).setEmail(usuario.getEmail());
            }
        }

        return clone;
    }
}
