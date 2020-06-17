package br.com.wsilva.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "airport_code")
public class AirportCodeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airp_id")
    private Integer id;

    @Column(name = "airp_iata_code", length = 3)
    private String iataCode;

    @Column(name = "airp_icao_code", length = 4)
    private String icaoCode;

    @Column(name = "airp_faa_code", length = 4)
    private String faaCode;

    @Column(name = "airp_location")
    private String location;

    @Column(name = "airp_airport")
    private String airport;

    @Column(name = "airp_country")
    private String country;

    public AirportCodeEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public String getIcaoCode() {
        return icaoCode;
    }

    public void setIcaoCode(String icaoCode) {
        this.icaoCode = icaoCode;
    }

    public String getFaaCode() {
        return faaCode;
    }

    public void setFaaCode(String faaCode) {
        this.faaCode = faaCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
