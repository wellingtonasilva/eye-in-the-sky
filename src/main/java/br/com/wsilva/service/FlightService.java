package br.com.wsilva.service;

import br.com.wsilva.model.dto.FlightsAverageDTO;
import br.com.wsilva.model.dto.FlightsDTO;
import br.com.wsilva.model.dto.FlightsResponseDTO;
import br.com.wsilva.model.entity.FlightBagsPriceEntity;
import br.com.wsilva.model.entity.FlightConversionEntity;
import br.com.wsilva.model.entity.FlightEntity;
import br.com.wsilva.model.entity.SearchParameterEntity;
import br.com.wsilva.model.projection.FlightsAverageProjection;
import br.com.wsilva.model.projection.FlightsBagsPriceAverageProjection;
import br.com.wsilva.repository.FlightBagsPriceRepository;
import br.com.wsilva.repository.FlightConversionRepository;
import br.com.wsilva.repository.FlightRepository;
import br.com.wsilva.repository.SearchParameterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class FlightService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightService.class.getName());
    private final String BASE_URL = "https://api.skypicker.com/flights?";

    private RestTemplate restTemplate;
    private SearchParameterRepository searchParameterRepository;
    private FlightRepository flightRepository;
    private FlightBagsPriceRepository flightBagsPriceRepository;
    private FlightConversionRepository flightConversionRepository;

    @Autowired
    public FlightService(
            RestTemplate restTemplate,
            SearchParameterRepository searchParameterRepository,
            FlightRepository flightRepository,
            FlightBagsPriceRepository flightBagsPriceRepository,
            FlightConversionRepository flightConversionRepository
    ) {
        this.restTemplate = restTemplate;
        this.searchParameterRepository = searchParameterRepository;
        this.flightRepository = flightRepository;
        this.flightBagsPriceRepository = flightBagsPriceRepository;
        this.flightConversionRepository = flightConversionRepository;
    }

    public Map<String, FlightsAverageDTO> getFlightsAverage(Integer searchParameterId) {
        Map<String, FlightsAverageDTO> flightsAverage = new HashMap<>();
        // Get summary for Destiny and price average
        List<FlightsAverageProjection> list = flightRepository.findFlightsAverage(searchParameterId);
        if (list != null) {
            list.stream().forEach(item -> flightsAverage.put(item.getFlyTo(),
                    new FlightsAverageDTO(item.getCityTo(), "EUR", item.getPrice())));
        }

        // Get bag prices
        for (Map.Entry<String, FlightsAverageDTO> flight : flightsAverage.entrySet()) {
            List<FlightsBagsPriceAverageProjection> bags =
                    flightBagsPriceRepository.findFlightsBagsPriceAverage(searchParameterId, flight.getKey());
            bags.forEach(bag -> {
                flightsAverage.get(flight.getKey()).getBagsPrice().put(bag.getHand(), bag.getPrice());
            });
        }
        return flightsAverage;
    }

    public SearchParameterEntity getFlightRemote(String[] dest, String dateFrom, String dateTo, String curr) {
        LOGGER.info("Getting Flights from external server.");

        String flyto = "";
        StringBuilder builder = new StringBuilder();
        builder.append("partner=picky");

        // Destiny
        if (dest != null && dest.length > 0) {

            for (String destination : dest) {
                flyto += destination + ",";
            }
            builder.append("&fly_to=").append(flyto.substring(0, flyto.length()-1));
        }
        // DateFrom
        if (!StringUtils.isEmpty(dateFrom)) {
            builder.append("&date_from=").append(dateFrom);
        }
        // DateTo
        if (!StringUtils.isEmpty(dateTo)) {
            builder.append("&date_to=").append(dateTo);
        }
        // curr
        if (!StringUtils.isEmpty(curr)) {
            builder.append("&curr=").append(curr);
        }

        FlightsResponseDTO response = restTemplate.getForObject(BASE_URL + builder.toString(),
                FlightsResponseDTO.class);
        if (response != null) {
            return saveFlightToDatabase(flyto, dateFrom, dateTo, curr, response);
        }
        return null;
    }

    @Transactional(value = Transactional.TxType.REQUIRED)
    private SearchParameterEntity saveFlightToDatabase(String dest, String dateFrom, String dateTo, String curr,
                                        FlightsResponseDTO flightsResponse) {
        if (flightsResponse != null) {
            if (flightsResponse.getData() != null) {
                // Save information about the actual search
                final SearchParameterEntity searchParameter = saveSearchParameter(dest, dateFrom, dateTo, curr, flightsResponse);
                if (searchParameter != null) {
                    Arrays.stream(flightsResponse.getData()).forEach(flight -> {
                        // 1. Save flight
                        FlightEntity entity = saveFlight(searchParameter, flight);
                        if (entity != null) {
                            // 2. Save bag prices
                            saveBagPrices(entity, flight.getBagsPrice());
                            // 3. Price for currency
                            saveConversion(entity, flight.getConversion());
                        }
                    });
                    return searchParameter;
                }
            }
        }

        return null;
    }

    private SearchParameterEntity saveSearchParameter(String dest, String dateFrom, String dateTo, String curr,
                                                      FlightsResponseDTO searchParameter) {
        if (searchParameter != null) {
            if (searchParameterRepository.findByCode(searchParameter.getSearch_id()) == null) {
                SearchParameterEntity entity = searchParameter.from();
                entity.setDateFrom(dateFrom);
                entity.setDateTo(dateTo);
                entity.setDestination(dest);
                return searchParameterRepository.save(entity);
            }
        }
        return null;
    }

    private FlightEntity saveFlight(SearchParameterEntity searchParameter, FlightsDTO flight) {
        // Check if this flight exist in the database
        if (flightRepository.findByCodeAndSearchParameterCode(flight.getId(),
                searchParameter.getCode()) == null) {
            FlightEntity entity = flight.from();
            entity.setSearchParameter(searchParameter);
            return flightRepository.save(entity);
        }
        return null;
    }

    private void saveBagPrices(FlightEntity flight, HashMap<Integer, Float> bagsPrice) {
        if (bagsPrice != null) {
            for (Map.Entry<Integer, Float> price : bagsPrice.entrySet()) {
                FlightBagsPriceEntity entity = new FlightBagsPriceEntity();
                entity.setFlight(flight);
                entity.setHand(price.getKey());
                entity.setPrice(price.getValue());

                flightBagsPriceRepository.save(entity);
            }
        }
    }

    private void saveConversion(FlightEntity flight, HashMap<String, Float> conversion) {
        if (conversion != null) {
            for (Map.Entry<String, Float> price : conversion.entrySet()) {
                FlightConversionEntity entity = new FlightConversionEntity();
                entity.setFlight(flight);
                entity.setCurrency(price.getKey());
                entity.setPrice(price.getValue());

                flightConversionRepository.save(entity);
            }
        }
    }
}
