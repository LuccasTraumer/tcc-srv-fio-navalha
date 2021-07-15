package tcc.cotuca.fiodanavalha.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.Map;

@Component
@Service
public class CadastroService {
    @Autowired
    ConversionService conversionService;

    Logger logger = LoggerFactory.getLogger(CadastroService.class);

    public ResponseEntity<HttpStatus> cadastrarCliente(Map<String, String> headers, JsonNode body) {
        logger.info(String.format("Cadastrando Cliente %s", body));

        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Cliente converterCliente(JsonNode body) {
        return this.conversionService.convert(body, Cliente.class);
    }
}
