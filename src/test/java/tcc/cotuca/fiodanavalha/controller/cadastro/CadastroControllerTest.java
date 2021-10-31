package tcc.cotuca.fiodanavalha.controller.cadastro;

import lombok.SneakyThrows;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tcc.cotuca.fiodanavalha.exception.CadastroInvalidoException;
import tcc.cotuca.fiodanavalha.service.CadastroService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CadastroController.class)
class CadastroControllerTest {
    private static final String PATH_CADASTRO = "/cadastro";
    private static final String PATH_BARBEARIA = "/barbearia";
    private static final String PATH_CLIENTE = "/cliente";
    private static final String PATH_BARBEIRO = "/barbeiro";

    private JSONObject parametros;
    private final HttpHeaders headers = new HttpHeaders();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CadastroService cadastroService;

    @BeforeEach
    @SneakyThrows
    void configure() {
        parametros = new JSONObject().put("", "");
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    //TODO: Deixar mais genericos os testes utilizando o Parametrid Test, pois os teste são iguais o que muda
    // é o metodo que sera chamado

    @Test
    @SneakyThrows
    void quandoCadastrarBarbearia_deveExecutarComSucesso() {
        doReturn(CREATED).when(cadastroService).cadastrarBarbearia(any(), any());

        mockMvc.perform(
                post(PATH_CADASTRO + PATH_BARBEARIA)
                .headers(headers)
                .content(parametros.toString())
        ).andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    void quandoCadastrarBarbearia_deveExecutarLancarExcecao() {
        doThrow(CadastroInvalidoException.class).when(cadastroService).cadastrarBarbearia(any(), any());

        mockMvc.perform(
                post(PATH_CADASTRO + PATH_BARBEARIA)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isNotAcceptable());
    }

    @Test
    @SneakyThrows
    void quandoCadastrarBarbeiro_deveExecutarComSucesso() {
        doReturn(CREATED).when(cadastroService).cadastrarBarbeiro(any(), any());

        mockMvc.perform(
                post(PATH_CADASTRO + PATH_BARBEIRO)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    void quandoCadastrarBarbeiro_deveExecutarLancarExcecao() {
        doThrow(CadastroInvalidoException.class).when(cadastroService).cadastrarBarbeiro(any(), any());

        mockMvc.perform(
                post(PATH_CADASTRO + PATH_BARBEIRO)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isNotAcceptable());
    }

    @Test
    @SneakyThrows
    void quandoCadastrarCliente_deveExecutarComSucesso() {
        doReturn(CREATED).when(cadastroService).cadastrarCliente(any(), any());

        mockMvc.perform(
                post(PATH_CADASTRO + PATH_CLIENTE)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    void quandoCadastrarCliente_deveExecutarLancarExcecao() {
        doThrow(CadastroInvalidoException.class).when(cadastroService).cadastrarCliente(any(), any());

        mockMvc.perform(
                post(PATH_CADASTRO + PATH_CLIENTE)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isNotAcceptable());
    }
}