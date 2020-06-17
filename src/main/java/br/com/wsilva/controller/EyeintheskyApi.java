package br.com.wsilva.controller;

import br.com.wsilva.model.dto.FlightsAverageDTO;
import br.com.wsilva.model.entity.SearchParameterEntity;
import br.com.wsilva.service.AirlineService;
import br.com.wsilva.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EyeintheskyApi {

    private AirlineService airlineService;
    private FlightService flightService;

    @Autowired
    public EyeintheskyApi(
            AirlineService airlineService,
            FlightService flightService
    ) {
        this.airlineService = airlineService;
        this.flightService = flightService;
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

    @PostConstruct
    public void loadAirline() {
        airlineService.loadAirline();
    }
}
