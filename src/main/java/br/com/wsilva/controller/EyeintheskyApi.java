package br.com.wsilva.controller;

import br.com.wsilva.model.dto.AirlineDTO;
import br.com.wsilva.model.dto.FlightsAverageDTO;
import br.com.wsilva.model.dto.FlightsAverageResponseDTO;
import br.com.wsilva.model.entity.SearchParameterEntity;
import br.com.wsilva.repository.AirlineRepository;
import br.com.wsilva.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EyeintheskyApi {

    private AirlineRepository airlineRepository;
    private FlightService flightService;

    @Autowired
    public EyeintheskyApi(
            AirlineRepository airlineRepository,
            FlightService flightService
    ) {
        this.airlineRepository = airlineRepository;
        this.flightService = flightService;
    }

    @GetMapping("/loadAirlines")
    public ResponseEntity<Void> loadAirlines() {
//        AirlineDTO[] airlines = restTemplate.getForObject("https://api.skypicker.com/airlines", AirlineDTO[].class);
//        if (airlines != null && airlines.length != 0) {
//            Arrays.stream(airlines).forEach(airline -> airlineRepository.save(airline.from()));
//        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/flght/avg")
    public ResponseEntity<Map<String, FlightsAverageDTO>> flghtAverage(
            @RequestParam(name = "dest") String[] dest,
            @RequestParam(name = "dateFrom", defaultValue = "") String dateFrom,
            @RequestParam(name = "dateTo", defaultValue = "") String dateTo,
            @RequestParam(name = "curr", defaultValue = "") String curr
    ) {
        SearchParameterEntity searchParameter = flightService.getFlightRemote(dest, dateFrom, dateTo, curr);
        if (searchParameter != null) {
            return ResponseEntity.ok(flightService.getFlightsAverage(searchParameter.getId()));
        }

        return ResponseEntity.notFound().build();
    }
}
