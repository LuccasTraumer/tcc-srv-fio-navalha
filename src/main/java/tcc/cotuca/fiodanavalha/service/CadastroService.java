package tcc.cotuca.fiodanavalha.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.exception.CadastroInvalidoException;
import tcc.cotuca.fiodanavalha.gateway.BarbeariaGateway;
import tcc.cotuca.fiodanavalha.gateway.ClienteGateway;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.Usuario;

import java.time.LocalDate;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;


@Component
@Service
public class CadastroService {
    Logger logger = LoggerFactory.getLogger(CadastroService.class);

    @Autowired
    private ClienteGateway clienteGateway;

    @Autowired
    private BarbeariaGateway barbeariaGateway;

    public HttpStatus cadastrarCliente(Map<String, String> headers, Cliente cliente) {
        logger.info("Cadastrando Cliente {0}", cliente);

        if(!usuarioValido(cliente))
            throw new CadastroInvalidoException("Dados para cadastro do Cliente " + cliente + " Invalidos");

        Cliente clone = (Cliente) gerarUsuario(cliente);

//        clienteGateway.inserirCliente(clone);
        return CREATED;
    }

    public HttpStatus cadastrarBarbearia(Map<String, String> headers, Barbearia barbearia) {
        logger.info("Cadastrando Barbearia {0}", barbearia);

        if(!usuarioValido(barbearia))
            throw new CadastroInvalidoException("Dados para cadastro da Barbearia " + barbearia + " Invalidos");

        Barbearia clone = (Barbearia) gerarUsuario(barbearia);

        barbeariaGateway.inserirBarbearia(clone);
        return CREATED;
    }

    public HttpStatus cadastrarBarbeiro(Map<String, String> headers, Barbearia barbearia) {
        logger.info("Cadastrando Barbearia {0}", barbearia);

        if(!usuarioValido(barbearia))
            throw new CadastroInvalidoException("Dados para cadastro do(a) Barbeiro(a) " + barbearia + " Invalidos");

        return CREATED;
    }

    private boolean usuarioValido(Usuario usuario) {
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

    private Usuario gerarUsuario(Usuario usuario) {
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
