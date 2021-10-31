package tcc.cotuca.fiodanavalha.controller;

import lombok.SneakyThrows;
import org.apache.catalina.security.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import tcc.cotuca.fiodanavalha.FioDaNavalhaApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = { HealthController.class })
class HealthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    void quandoChamarHealth_deveRetornarSucesso() {
        mockMvc.perform(get("/health")).andExpect(status().isOk());
    }
}