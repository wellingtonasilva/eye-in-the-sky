package br.com.wsilva.repository;

import br.com.wsilva.model.entity.FlightAirlinesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "flightsAirlines")
public interface FlightAirlinesRepository extends CrudRepository<FlightAirlinesEntity, Integer> {
}
