package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tcc.cotuca.fiodanavalha.to.Cliente;

public interface ClienteVarejoRepository extends MongoRepository<Cliente, String> {

}
