package br.com.wsilva.repository;

import br.com.wsilva.model.entity.AirlineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "airlines")
public interface AirlineRepository extends CrudRepository<AirlineEntity, String> {
}
