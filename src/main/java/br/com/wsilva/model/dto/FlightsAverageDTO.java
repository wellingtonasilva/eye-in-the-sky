package br.com.wsilva.model.dto;

import java.util.HashMap;
import java.util.Map;

public class FlightsAverageDTO {

    private String name;
    private String currency;
    private Float priceAverage;
    private Map<Integer, Float> bagsPrice = new HashMap<>();

    public FlightsAverageDTO() {
    }

    public FlightsAverageDTO(String name, String currency, Float priceAverage) {
        this.name = name;
        this.currency = currency;
        this.priceAverage = priceAverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getPriceAverage() {
        return priceAverage;
    }

    public void setPriceAverage(Float priceAverage) {
        this.priceAverage = priceAverage;
    }

    public Map<Integer, Float> getBagsPrice() {
        return bagsPrice;
    }

    public void setBagsPrice(Map<Integer, Float> bagsPrice) {
        this.bagsPrice = bagsPrice;
    }
}
