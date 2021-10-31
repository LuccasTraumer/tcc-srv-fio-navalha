package tcc.cotuca.fiodanavalha.controller.home;

import lombok.SneakyThrows;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(HomeController.class)
class HomeControllerTest {
    private JSONObject parametros;
    private final HttpHeaders headers = new HttpHeaders();

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    @SneakyThrows
    void configure() {
        parametros = new JSONObject().put("", "");
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

}