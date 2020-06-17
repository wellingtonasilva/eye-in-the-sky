package br.com.wsilva.repository;

import br.com.wsilva.model.entity.AirportCodeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportCodeRepository extends CrudRepository<AirportCodeEntity, Integer> {
}
