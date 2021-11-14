package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tcc.cotuca.fiodanavalha.to.Cliente;
import tcc.cotuca.fiodanavalha.to.Usuario;

import java.util.Optional;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, Long> {
    public Optional<Cliente> findByEmail(String email);
    public Optional<Cliente> findByTelefone(String telefone);

}
