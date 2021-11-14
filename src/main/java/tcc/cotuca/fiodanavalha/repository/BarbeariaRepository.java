package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tcc.cotuca.fiodanavalha.to.Barbearia;

import java.util.Optional;

@Repository
public interface BarbeariaRepository extends MongoRepository<Barbearia, Long> {
    public Optional<Barbearia> findByEmail(String email);
    public Optional<Barbearia> findByTelefone(String telefone);
}
