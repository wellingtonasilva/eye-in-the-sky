package br.com.wsilva.model.dto;

import br.com.wsilva.model.entity.SearchParameterEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightsResponseDTO {

    @JsonProperty("search_id")
    private String search_id;

    @JsonProperty("data")
    private FlightsDTO[] data;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("currency_rate")
    private Float currencyRate;

    @JsonProperty("fx_rate")
    private Float fxRate;

    public FlightsResponseDTO() {
    }

    public SearchParameterEntity from() {
        SearchParameterEntity entity = new SearchParameterEntity();
        entity.setCode(getSearch_id());
        entity.setCurrency(getCurrency());
        entity.setRate(getCurrencyRate());

        return entity;
    }

    public String getSearch_id() {
        return search_id;
    }

    public void setSearch_id(String search_id) {
        this.search_id = search_id;
    }

    public FlightsDTO[] getData() {
        return data;
    }

    public void setData(FlightsDTO[] data) {
        this.data = data;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Float getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(Float currencyRate) {
        this.currencyRate = currencyRate;
    }

    public Float getFxRate() {
        return fxRate;
    }

    public void setFxRate(Float fxRate) {
        this.fxRate = fxRate;
    }
}
