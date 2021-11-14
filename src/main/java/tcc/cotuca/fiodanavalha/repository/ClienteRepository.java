package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tcc.cotuca.fiodanavalha.to.Cliente;


@Repository
public interface ClienteRepository extends MongoRepository<Cliente, Long> {
}
