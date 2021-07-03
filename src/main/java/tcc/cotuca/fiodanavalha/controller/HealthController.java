package tcc.cotuca.fiodanavalha.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<HttpStatus> getStatus() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
