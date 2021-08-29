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
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.ClienteBarbearia;
import tcc.cotuca.fiodanavalha.to.ClienteVarejo;

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
        Cliente cliente = null;
        try {
            String tipoCliente = body.get("tipoCliente").asText().toLowerCase();
            if (tipoCliente.equals("varejo") || tipoCliente.equals("barbearia")) {
                cliente = preencherCliente(body);
                if(cliente.getClass() == ClienteVarejo.class)
                    clienteVarejoService.inserirCliente((ClienteVarejo) cliente);
                else
                    clienteBarbeariaService.inserirBarbearia((ClienteBarbearia) cliente);
            } else {
                throw new CadastroInvalidoException("Tipo de Cliente é invalido para cadastro!");
            }
        } catch (Exception e) {
            headers.put("error", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        headers.put("jsessionId", "teste");
        logger.info("Cliente cadastrado com Sucesso! {0}", cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Cliente preencherCliente(ObjectNode body) {
        Cliente cliente = null;

        cliente = body.get("tipoCliente").asText().equals("varejo") ? new ClienteVarejo() : new ClienteBarbearia();
        camposComum(cliente, body);

        return cliente;
    }

    private void camposComum(Cliente cliente, ObjectNode body) {
        cliente.setDataCadastro(LocalDate.now());
        cliente.setCpfCnpj(body.get("cpfCnpj").asText());
        cliente.setEmail(body.get("email").asText());
        cliente.setTelefone(body.get("telefone").asText());
        cliente.setNome(body.get("nome").asText());
        cliente.setFotoPerfil(body.get("fotoPerfil").asText());
        cliente.setSenha(body.get("senha").asText());
        List<String> data = asList(body.get("dataNascimento").asText().split("-"));
        cliente.setDataNascimento(LocalDate.of(Integer.parseInt(data.get(0)), Integer.parseInt(data.get(1)), Integer.parseInt(data.get(2))));
        if(cliente.getClass() == ClienteVarejo.class)
            cliente.setTipoCliente("clienteVarejo");
        else
            cliente.setTipoCliente("clienteBarbearia");
    }
}
