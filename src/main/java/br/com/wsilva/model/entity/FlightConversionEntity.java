package br.com.wsilva.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "flight_conversion")
public class FlightConversionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flcv_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "flig_id")
    private FlightEntity flight;

    @Column(name = "flcv_currency")
    private String currency;

    @Column(name = "flcv_price")
    private Float price;

    public FlightConversionEntity() {
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
