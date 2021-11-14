package tcc.cotuca.fiodanavalha.utils;

import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.Usuario;

import java.time.LocalDate;

public class ValidarUsuario {

    public static boolean USUARIO_VALIDO(Usuario usuario) {
        boolean isValid = true;
        if(usuario.getClass().equals(Cliente.class)) {
            isValid = ((Cliente) usuario).getSaldoCliente() != null &&
                    ((Cliente) usuario).getNotaCliente() != null &&
                    ((Cliente) usuario).getReputacao() != null &&
                    ((Cliente) usuario).getEndereco() != null &&
                    ((Cliente) usuario).getNome() != null &&
                    ((Cliente) usuario).getCpf() != null &&
                    (((Cliente) usuario).getEmail() != null ||
                            ((Cliente) usuario).getTelefone() != null) &&
                    ((Cliente) usuario).getFotoPerfil() != null &&
                    ((Cliente) usuario).getSenha() != null &&
                    ((Cliente) usuario).getDataNascimento() != null;
        } else if(usuario.getClass().equals(Barbearia.class)) {
            isValid = ((Barbearia) usuario).getEndereco() != null &&
                    ((Barbearia) usuario).getNome() != null &&
                    ((Barbearia) usuario).getCnpj() != null &&
                    (((Cliente) usuario).getEmail() != null ||
                            ((Cliente) usuario).getTelefone() != null) &&
                    ((Barbearia) usuario).getFotoPerfil() != null &&
                    ((Barbearia) usuario).getSenha() != null &&
                    ((Barbearia) usuario).getDataNascimento()!= null;
        }
        return isValid;
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
            ((Cliente) clone).setEmail(((Cliente) usuario).getEmail());
            ((Cliente) clone).setTelefone(((Cliente) usuario).getTelefone());
            ((Cliente) clone).setFotoPerfil(((Cliente) usuario).getFotoPerfil());
            ((Cliente) clone).setSenha(((Cliente) usuario).getSenha());
            ((Cliente) clone).setDataNascimento(((Cliente) usuario).getDataNascimento());
            ((Cliente) clone).setDataCadastro(LocalDate.now());
            ((Cliente) clone).generatedId(usuario);
        } else if(usuario.getClass().equals(Barbearia.class)) {
            clone = new Barbearia();
            ((Barbearia) clone).getEnderecos().add(((Barbearia) usuario).getEndereco());
            ((Barbearia) clone).setNome(((Barbearia) usuario).getNome());
            ((Barbearia) clone).setCnpj(((Barbearia) usuario).getCnpj());
            ((Barbearia) clone).setEmail(((Barbearia) usuario).getEmail());
            ((Barbearia) clone).setTelefone(((Barbearia) usuario).getTelefone());
            ((Barbearia) clone).setFotoPerfil(((Barbearia) usuario).getFotoPerfil());
            ((Barbearia) clone).setSenha(((Barbearia) usuario).getSenha());
            ((Barbearia) clone).setDataNascimento(((Barbearia) usuario).getDataNascimento());
            ((Barbearia) clone).setDataCadastro(LocalDate.now());
            ((Barbearia) clone).generatedId(usuario);
        }

        return clone;
    }
}
