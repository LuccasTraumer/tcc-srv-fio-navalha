package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import tcc.cotuca.fiodanavalha.to.Barbearia;

@Repository
public interface BarbeariaRepository extends JpaRepository<Barbearia, String> {
}
