package tcc.cotuca.fiodanavalha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import tcc.cotuca.fiodanavalha.repository.ClienteRepository;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableMongoRepositories(basePackageClasses = ClienteRepository.class)
public class FioDaNavalhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FioDaNavalhaApplication.class, args);
	}

}
