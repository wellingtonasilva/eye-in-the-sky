package br.com.wsilva.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FlightDurationEntity {

    @Column(name = "flig_duration_departure")
    private Integer departure;

    @Column(name = "flig_duration_return")
    private Integer durationReturn;

    @Column(name = "flig_duration_total")
    private Integer total;

    public FlightDurationEntity() {
    }

    public Integer getDeparture() {
        return departure;
    }

    public void setDeparture(Integer departure) {
        this.departure = departure;
    }

    public Integer getDurationReturn() {
        return durationReturn;
    }

    public void setDurationReturn(Integer durationReturn) {
        this.durationReturn = durationReturn;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}