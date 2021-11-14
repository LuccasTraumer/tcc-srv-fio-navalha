package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcc.cotuca.fiodanavalha.to.Cliente;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
//    Optional<Cliente> findByEmail(String email);
//    Optional<Cliente> findByTelefone(String telefone);

}
