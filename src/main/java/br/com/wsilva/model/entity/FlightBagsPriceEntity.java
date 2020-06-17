package br.com.wsilva.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "flight_bags_price")
public class FlightBagsPriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flbp_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "flig_id")
    private FlightEntity flight;

    @Column(name = "flbp_hand")
    private Integer hand;

    @Column(name = "flbp_price")
    private Float price;

    public FlightBagsPriceEntity() {
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

    public Integer getHand() {
        return hand;
    }

    public void setHand(Integer hand) {
        this.hand = hand;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
