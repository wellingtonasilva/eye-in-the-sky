package br.com.wsilva.repository;

import br.com.wsilva.model.entity.FlightConversionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightConversionRepository extends CrudRepository<FlightConversionEntity, Integer> {
}
