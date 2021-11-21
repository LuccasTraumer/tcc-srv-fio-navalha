package tcc.cotuca.fiodanavalha.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tcc.cotuca.fiodanavalha.to.Favorito;

public interface FavoritoRepository extends MongoRepository<Favorito, Long> {
}
