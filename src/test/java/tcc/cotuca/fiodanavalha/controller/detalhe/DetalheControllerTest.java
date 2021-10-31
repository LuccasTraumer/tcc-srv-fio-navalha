package tcc.cotuca.fiodanavalha.controller.detalhe;

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
import tcc.cotuca.fiodanavalha.exception.FioDaNavalhaException;
import tcc.cotuca.fiodanavalha.service.DetalheService;
import tcc.cotuca.fiodanavalha.to.Barbearia;
import tcc.cotuca.fiodanavalha.to.Cliente;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(DetalheController.class)
class DetalheControllerTest {
    private static final String PATH_DETALHE = "/detalhe";
    private static final String PATH_BARBEARIA = "/barbearia";
    private static final String PATH_CLIENTE = "/cliente";
    private JSONObject parametros;
    private final HttpHeaders headers = new HttpHeaders();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DetalheService detalheService;

    @BeforeEach
    @SneakyThrows
    void configure() {
        parametros = new JSONObject().put("", "");
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    @SneakyThrows
    void quandoBuscarDetalhesCliente_deveRetornarSucesso() {
        doReturn(new Cliente()).when(detalheService).buscarDetalhesCliente(any());

        mockMvc.perform(
                post(PATH_DETALHE + PATH_CLIENTE)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void quandoBuscarDetalhesCliente_deveLancarExcecao() {
        doThrow(FioDaNavalhaException.class).when(detalheService).buscarDetalhesCliente(any());

        mockMvc.perform(
                post(PATH_DETALHE + PATH_CLIENTE)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isInternalServerError());
    }

    @Test
    @SneakyThrows
    void quandoBuscarDetalhesBarbearia_deveRetornarSucesso() {
        doReturn(new Barbearia()).when(detalheService).buscarDetalhesBarbearia(any());

        mockMvc.perform(
                post(PATH_DETALHE + PATH_BARBEARIA)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void quandoBuscarDetalhesBarbearia_deveLancarExcecao() {
        doThrow(FioDaNavalhaException.class).when(detalheService).buscarDetalhesBarbearia(any());

        mockMvc.perform(
                post(PATH_DETALHE + PATH_BARBEARIA)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isInternalServerError());
    }

}