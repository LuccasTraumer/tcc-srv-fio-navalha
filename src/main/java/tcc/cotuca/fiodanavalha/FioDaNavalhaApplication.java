package tcc.cotuca.fiodanavalha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RestController;
import tcc.cotuca.fiodanavalha.repository.ClienteVarejoRepository;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableMongoRepositories(basePackageClasses = ClienteVarejoRepository.class)
@RestController
public class FioDaNavalhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FioDaNavalhaApplication.class, args);
	}

}
