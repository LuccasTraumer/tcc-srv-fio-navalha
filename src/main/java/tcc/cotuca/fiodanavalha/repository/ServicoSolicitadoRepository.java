package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tcc.cotuca.fiodanavalha.to.servico.ServicoSolicitado;

public interface ServicoSolicitadoRepository extends MongoRepository<ServicoSolicitado, Long> {
}
