package br.com.wsilva.service;

import br.com.wsilva.model.dto.AirlineDTO;
import br.com.wsilva.repository.AirlineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class AirlineService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AirlineService.class.getName());
    private AirlineRepository repository;
    private RestTemplate restTemplate;

    @Autowired
    public AirlineService(AirlineRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public void loadAirline() {
        // Check if the table is empty
        LOGGER.info("Check if the Airline table is empty");
        if (repository.count() == 0) {
            saveAirline(getAirlineRemote());
        }
    }

    private AirlineDTO[] getAirlineRemote() {
        LOGGER.info("Get information about Airline from remote server");
        return restTemplate.getForObject("https://api.skypicker.com/airlines", AirlineDTO[].class);
    }

    public void saveAirline(AirlineDTO[] airlines) {
        LOGGER.info("Save information about Airline into database");
        if (airlines != null && airlines.length != 0) {
            Arrays.stream(airlines).forEach(airline -> repository.save(airline.from()));
        }
    }
}
