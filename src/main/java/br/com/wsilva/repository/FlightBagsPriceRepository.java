package br.com.wsilva.repository;

import br.com.wsilva.model.entity.FlightBagsPriceEntity;
import br.com.wsilva.model.projection.FlightsBagsPriceAverageProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "flightBagsPrices")
public interface FlightBagsPriceRepository extends CrudRepository<FlightBagsPriceEntity, Integer> {

    @Query(value =
              "select f.flig_fly_to as fly_to, fbp.flbp_hand as hand, avg(fbp.flbp_price * sp.sear_currency_rate) as price "
            + " from flight as f, search_param as sp, flight_bags_price as fbp "
            + " where f.sear_id = sp.sear_id "
            + " and f.flig_id = fbp.flig_id "
            + " and sp.sear_id = ?1 "
            + " and f.flig_fly_to = ?2 "
            + " group by f.flig_fly_to, fbp.flbp_hand ", nativeQuery = true)
    @RestResource(exported = false)
    List<FlightsBagsPriceAverageProjection> findFlightsBagsPriceAverage(Integer searchParameterId,
                                                                        String flyTo);
}
