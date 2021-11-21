package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tcc.cotuca.fiodanavalha.to.servico.ServicoRealizado;

public interface ServicoRealizadoRepository extends MongoRepository<ServicoRealizado, Long> {
}
