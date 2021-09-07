package tcc.cotuca.fiodanavalha.service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.exception.CadastroInvalidoException;
import tcc.cotuca.fiodanavalha.to.Usuario;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Component
@Service
public class CadastroService {
    @Autowired
    private ClienteVarejoService clienteVarejoService;

    @Autowired
    private ClienteBarbeariaService clienteBarbeariaService;

    Logger logger = LoggerFactory.getLogger(CadastroService.class);

    public ResponseEntity<HttpStatus> cadastrarCliente(Map<String, String> headers, ObjectNode body) {
        logger.info("Cadastrando Cliente {0}", body);
        Usuario usuario = null;
        try {
            String tipoCliente = body.get("tipoCliente").asText().toLowerCase();
            if (tipoCliente.equals("varejo") || tipoCliente.equals("barbearia")) {
                usuario = preencherCliente(body);
                if(usuario.getClass() == Cliente.class)
                    clienteVarejoService.inserirCliente((Cliente) usuario);
                else
                    clienteBarbeariaService.inserirBarbearia((Barbearia) usuario);
            } else {
                throw new CadastroInvalidoException("Tipo de Cliente é invalido para cadastro!");
            }
        } catch (Exception e) {
            headers.put("error", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        headers.put("jsessionId", "teste");
        logger.info("Cliente cadastrado com Sucesso! {0}", usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Usuario preencherCliente(ObjectNode body) {
        Usuario usuario = null;

        usuario = body.get("tipoCliente").asText().equals("varejo") ? new Cliente() : new Barbearia();
        camposComum(usuario, body);

        return usuario;
    }

    private void camposComum(Usuario usuario, ObjectNode body) {
        usuario.setDataCadastro(LocalDate.now());
        usuario.setCpfCnpj(body.get("cpfCnpj").asText());
        usuario.setEmail(body.get("email").asText());
        usuario.setTelefone(body.get("telefone").asText());
        usuario.setNome(body.get("nome").asText());
        usuario.setFotoPerfil(body.get("fotoPerfil").asText());
        usuario.setSenha(body.get("senha").asText());
        List<String> data = asList(body.get("dataNascimento").asText().split("-"));
        usuario.setDataNascimento(LocalDate.of(Integer.parseInt(data.get(0)), Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2))));
        if(usuario.getClass() == Cliente.class)
            usuario.setTipoCliente("clienteVarejo");
        else
            usuario.setTipoCliente("clienteBarbearia");
    }
}
