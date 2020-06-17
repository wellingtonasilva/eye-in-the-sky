package br.com.wsilva.repository;

import br.com.wsilva.model.entity.FlightAirlinesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightAirlinesRepository extends CrudRepository<FlightAirlinesEntity, Integer> {
}
