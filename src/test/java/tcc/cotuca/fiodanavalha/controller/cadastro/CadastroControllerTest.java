package tcc.cotuca.fiodanavalha.controller.cadastro;

import lombok.SneakyThrows;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import tcc.cotuca.fiodanavalha.service.CadastroService;
import tcc.cotuca.fiodanavalha.to.Barbearia;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CadastroController.class)
class CadastroControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CadastroService cadastroService;

    private JSONObject parametros;
    private final HttpHeaders headers = new HttpHeaders();

    @BeforeEach
    @SneakyThrows
    void configure() {
        parametros = new JSONObject().put("", "");
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    @SneakyThrows
    void quandoCadastrarBarbearia_deveExecutarComSucesso() {
        doReturn(HttpStatus.CREATED).when(cadastroService).cadastrarBarbearia(any(), any());

        mockMvc.perform(
                post("/cadastro/barbearia")
                .headers(headers)
                .content(parametros.toString())
        ).andExpect(status().isCreated());
    }

    @Test
    void quandoCadastrarBarbearia_deveExecutarLancarExcecao() {

    }

    @Test
    void quandoCadastrarBarbeiro_deveExecutarComSucesso() {

    }

    @Test
    void quandoCadastrarBarbeiro_deveExecutarLancarExcecao() {

    }

    @Test
    void quandoCadastrarCliente_deveExecutarComSucesso() {

    }

    @Test
    void quandoCadastrarCliente_deveExecutarLancarExcecao() {

    }
}