package br.com.wsilva.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "flight_airlines")
public class FlightAirlinesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flil_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "flig_id")
    private FlightEntity flight;

    @ManyToOne
    @JoinColumn(name = "airl_id")
    private AirlineEntity airline;

    public FlightAirlinesEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    public void setFlight(FlightEntity flight) {
        this.flight = flight;
    }

    public AirlineEntity getAirline() {
        return airline;
    }

    public void setAirline(AirlineEntity airline) {
        this.airline = airline;
    }
}
