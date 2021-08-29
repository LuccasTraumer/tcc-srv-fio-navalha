package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tcc.cotuca.fiodanavalha.to.ClienteBarbearia;

public interface ClienteBarbeariaRepository extends MongoRepository<ClienteBarbearia, String> {
}
