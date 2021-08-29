package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tcc.cotuca.fiodanavalha.to.ClienteVarejo;

public interface ClienteVarejoRepository extends MongoRepository<ClienteVarejo, String> {

}
