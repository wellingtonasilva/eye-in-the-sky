package br.com.wsilva.repository;

import br.com.wsilva.model.entity.FlightEntity;
import br.com.wsilva.model.projection.FlightsAverageProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<FlightEntity, Integer> {

    FlightEntity findByCodeAndSearchParameterCode(String code, String searchParamterCode);

    @Query(value =
            " select f.flig_fly_to as fly_to, f.flig_city_to as city_to, avg(f.flig_price * sp.sear_currency_rate) as price "
            + " from flight as f, search_param as sp "
            + " where f.sear_id = sp.sear_id "
            + "   and sp.sear_id = ?1 "
            + " group by f.flig_fly_to, f.flig_city_to", nativeQuery = true)
    List<FlightsAverageProjection> findFlightsAverage(Integer searchParameterId);
}
