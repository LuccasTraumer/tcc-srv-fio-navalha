package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tcc.cotuca.fiodanavalha.to.servico.Servico;

public interface ServicoRepository extends MongoRepository<Servico, String> {
}
