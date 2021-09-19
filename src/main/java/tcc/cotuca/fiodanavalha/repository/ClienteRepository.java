package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcc.cotuca.fiodanavalha.to.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
