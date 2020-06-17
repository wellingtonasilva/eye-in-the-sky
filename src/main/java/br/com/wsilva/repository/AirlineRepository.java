package br.com.wsilva.repository;

import br.com.wsilva.model.entity.AirlineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends CrudRepository<AirlineEntity, String> {
}
