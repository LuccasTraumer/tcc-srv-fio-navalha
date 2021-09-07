package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tcc.cotuca.fiodanavalha.to.Barbearia;

public interface ClienteBarbeariaRepository extends MongoRepository<Barbearia, String> {
}
