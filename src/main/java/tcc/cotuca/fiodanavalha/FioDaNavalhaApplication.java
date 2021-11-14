package tcc.cotuca.fiodanavalha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableJpaRepositories("tcc.cotuca.fiodanavalha.repository")
@EntityScan("tcc.cotuca.fiodanavalha.to")
public class FioDaNavalhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FioDaNavalhaApplication.class, args);
	}

//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

}
