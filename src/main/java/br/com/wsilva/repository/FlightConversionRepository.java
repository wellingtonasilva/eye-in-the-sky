package br.com.wsilva.repository;

import br.com.wsilva.model.entity.FlightConversionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "flightConversion")
public interface FlightConversionRepository extends CrudRepository<FlightConversionEntity, Integer> {
}
