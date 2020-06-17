package br.com.wsilva.repository;

import br.com.wsilva.model.entity.AirportCodeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "airport")
public interface AirportCodeRepository extends CrudRepository<AirportCodeEntity, Integer> {
}
