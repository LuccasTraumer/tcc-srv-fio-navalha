package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tcc.cotuca.fiodanavalha.to.Barbearia;

@Repository
public interface BarbeariaRepository extends MongoRepository<Barbearia, String> {
}
