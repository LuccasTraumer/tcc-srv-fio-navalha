package tcc.cotuca.fiodanavalha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.List;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FioDaNavalhaApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(FioDaNavalhaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql = "select * from cliente";

		List<Cliente> lista = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Cliente.class));
	}
}
