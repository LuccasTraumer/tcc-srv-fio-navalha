package tcc.cotuca.fiodanavalha.controller.home;

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
import tcc.cotuca.fiodanavalha.service.HomeService;
import tcc.cotuca.fiodanavalha.to.home.HomeBarbeariaResponse;
import tcc.cotuca.fiodanavalha.to.home.HomeClienteResponse;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(HomeController.class)
class HomeControllerTest {
    private static final String PATH_HOME = "/home";
    private static final String PATH_BARBEARIA = "/barbearia";
    private static final String PATH_CLIENTE = "/cliente";
    private JSONObject parametros;
    private final HttpHeaders headers = new HttpHeaders();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HomeService service;

    @BeforeEach
    @SneakyThrows
    void configure() {
        parametros = new JSONObject().put("", "");
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    @SneakyThrows
    void quandoBuscarDadosCliente_deveRetornarSucesso() {
        doReturn(new ArrayList<HomeClienteResponse>()).when(service).buscarHomeCliente(any(), any());

        mockMvc.perform(
                get(PATH_HOME + PATH_CLIENTE)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void quandoBuscarDadosCliente_deveLancarExcecao() {
        doThrow(FioDaNavalhaException.class).when(service).buscarHomeCliente(any(), any());

        mockMvc.perform(
                get(PATH_HOME + PATH_CLIENTE)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isInternalServerError());
    }

    @Test
    @SneakyThrows
    void quandoBuscarDadosBarbearia_deveRetornarSucesso() {
        doReturn(new ArrayList<HomeBarbeariaResponse>()).when(service).buscarListaDePedidoSolicitados(any(), any());

        mockMvc.perform(
                get(PATH_HOME + PATH_BARBEARIA)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    void quandoBuscarDadosBarbearia_deveLancarExcecao() {
        doThrow(FioDaNavalhaException.class).when(service).buscarListaDePedidoSolicitados(any(), any());

        mockMvc.perform(
                get(PATH_HOME + PATH_BARBEARIA)
                        .headers(headers)
                        .content(parametros.toString())
        ).andExpect(status().isInternalServerError());
    }
}