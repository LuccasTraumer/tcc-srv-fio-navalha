package tcc.cotuca.fiodanavalha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "tcc.cotuca.fiodanavalha.repository")
@ComponentScan("tcc.cotuca.fiodanavalha")
@EntityScan(basePackages="tcc.cotuca.fiodanavalha.to")
@EnableTransactionManagement
@EnableJpaAuditing
public class FioDaNavalhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FioDaNavalhaApplication.class, args);
	}

}
