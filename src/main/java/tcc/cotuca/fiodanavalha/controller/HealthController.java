package tcc.cotuca.fiodanavalha.controller;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HealthController {

    Logger logger = (Logger) LoggerFactory.getLogger(HealthController.class);

    @GetMapping(value = "health")
    public ResponseEntity<HttpStatus> getStatus() {
        logger.info("Cheguei a controller de Health!");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
