package br.com.wsilva.model.dto;

import br.com.wsilva.model.entity.FlightDurationEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightsDurationDTO {

    @JsonProperty("departure")
    private Integer departure;

    @JsonProperty("return")
    private Integer durationReturn;

    @JsonProperty("total")
    private Integer total;

    public FlightsDurationDTO() {
    }

    public FlightDurationEntity from() {
        FlightDurationEntity entity = new FlightDurationEntity();
        entity.setDeparture(getDeparture());
        entity.setDurationReturn(getDurationReturn());
        entity.setTotal(getTotal());

        return entity;
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
