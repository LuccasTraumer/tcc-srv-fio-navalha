package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcc.cotuca.fiodanavalha.to.Barbearia;

import java.util.Optional;

@Repository
public interface BarbeariaRepository extends JpaRepository<Barbearia, Long> {
//    Optional<Barbearia> findByEmail(String email);
//    Optional<Barbearia> findByTelefone(String telefone);
}
