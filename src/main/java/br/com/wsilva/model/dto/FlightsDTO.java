package br.com.wsilva.model.dto;

import br.com.wsilva.model.entity.FlightCountryFromEntity;
import br.com.wsilva.model.entity.FlightCountryToEntity;
import br.com.wsilva.model.entity.FlightEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;

public class FlightsDTO {

    private String id;
    private Long dTime;
    private Long dTimeUTC;
    private Long aTime;
    private Long aTimeUTC;
    private String nightsInDest;
    private FlightsDurationDTO duration;

    @JsonProperty("fly_duration")
    private String flyDuration;

    private String flyFrom;
    private String cityFrom;
    private String cityCodeFrom;
    private FlightsCountryDTO countryFrom;
    private String mapIdfrom;
    private String flyTo;
    private String cityTo;
    private String cityCodeTo;
    private FlightsCountryDTO countryTo;
    private String mapIdto;
    private Float distance;
    private String[][] routes;
    private String[] airlines;

    @JsonProperty("pnr_count")
    private Integer pnrCount;

    @JsonProperty("has_airport_change")
    private boolean hasAirportChange;

    @JsonProperty("technical_stops")
    private Integer technicalStops;

    private Float price;

    @JsonProperty("bags_price")
    private HashMap<Integer, Float> bagsPrice;

    private FlightsBagLimitDTO baglimit;
    private HashMap<String, Float> conversion;
    private Double quality;

    public FlightsDTO() {
    }

    public FlightEntity from() {
        FlightEntity entity = new FlightEntity();
        entity.setCode(getId());
        entity.setdTime(Date.from(Instant.ofEpochSecond(getdTime())));
        entity.setdTimeUtc(Date.from(Instant.ofEpochSecond(getdTimeUTC())));
        entity.setaTime((Date.from(Instant.ofEpochSecond(getaTime()))));
        entity.setaTimeUtc(Date.from(Instant.ofEpochSecond(getaTimeUTC())));
        if (getDuration() != null) {
            entity.setDuration(getDuration().from());
        }
        entity.setFlyFrom(getFlyFrom());
        entity.setCityFrom(getCityFrom());
        entity.setCityCodeFrom(getCityCodeFrom());
        if (getCountryFrom() != null) {
            entity.setCountryFrom(new FlightCountryFromEntity(getCountryFrom().getCode(),
                    getCountryFrom().getName()));
        }
        entity.setMapIdFrom(getMapIdfrom());
        entity.setFlyTo(getFlyTo());
        entity.setCityTo(getCityTo());
        entity.setCityCodeTo(getCityCodeTo());
        if (getCountryTo() != null) {
            entity.setCountryTo(new FlightCountryToEntity(getCountryTo().getCode(),
                    getCountryTo().getName()));
        }
        entity.setMapIdTo(getMapIdto());
        entity.setDistance(getDistance());
        entity.setPrice(getPrice());

        return entity;
    }

    public Long getdTime() {
        return dTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setdTime(Long dTime) {
        this.dTime = dTime;
    }

    public Long getdTimeUTC() {
        return dTimeUTC;
    }

    public void setdTimeUTC(Long dTimeUTC) {
        this.dTimeUTC = dTimeUTC;
    }

    public Long getaTime() {
        return aTime;
    }

    public void setaTime(Long aTime) {
        this.aTime = aTime;
    }

    public Long getaTimeUTC() {
        return aTimeUTC;
    }

    public void setaTimeUTC(Long aTimeUTC) {
        this.aTimeUTC = aTimeUTC;
    }

    public String getNightsInDest() {
        return nightsInDest;
    }

    public void setNightsInDest(String nightsInDest) {
        this.nightsInDest = nightsInDest;
    }

    public FlightsDurationDTO getDuration() {
        return duration;
    }

    public void setDuration(FlightsDurationDTO duration) {
        this.duration = duration;
    }

    public String getFlyDuration() {
        return flyDuration;
    }

    public void setFlyDuration(String flyDuration) {
        this.flyDuration = flyDuration;
    }

    public String getFlyFrom() {
        return flyFrom;
    }

    public void setFlyFrom(String flyFrom) {
        this.flyFrom = flyFrom;
    }

    public String getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(String cityFrom) {
        this.cityFrom = cityFrom;
    }

    public String getCityCodeFrom() {
        return cityCodeFrom;
    }

    public void setCityCodeFrom(String cityCodeFrom) {
        this.cityCodeFrom = cityCodeFrom;
    }

    public FlightsCountryDTO getCountryFrom() {
        return countryFrom;
    }

    public void setCountryFrom(FlightsCountryDTO countryFrom) {
        this.countryFrom = countryFrom;
    }

    public String getMapIdfrom() {
        return mapIdfrom;
    }

    public void setMapIdfrom(String mapIdfrom) {
        this.mapIdfrom = mapIdfrom;
    }

    public String getFlyTo() {
        return flyTo;
    }

    public void setFlyTo(String flyTo) {
        this.flyTo = flyTo;
    }

    public String getCityTo() {
        return cityTo;
    }

    public void setCityTo(String cityTo) {
        this.cityTo = cityTo;
    }

    public String getCityCodeTo() {
        return cityCodeTo;
    }

    public void setCityCodeTo(String cityCodeTo) {
        this.cityCodeTo = cityCodeTo;
    }

    public FlightsCountryDTO getCountryTo() {
        return countryTo;
    }

    public void setCountryTo(FlightsCountryDTO countryTo) {
        this.countryTo = countryTo;
    }

    public String getMapIdto() {
        return mapIdto;
    }

    public void setMapIdto(String mapIdto) {
        this.mapIdto = mapIdto;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public String[][] getRoutes() {
        return routes;
    }

    public void setRoutes(String[][] routes) {
        this.routes = routes;
    }

    public String[] getAirlines() {
        return airlines;
    }

    public void setAirlines(String[] airlines) {
        this.airlines = airlines;
    }

    public Integer getPnrCount() {
        return pnrCount;
    }

    public void setPnrCount(Integer pnrCount) {
        this.pnrCount = pnrCount;
    }

    public boolean isHasAirportChange() {
        return hasAirportChange;
    }

    public void setHasAirportChange(boolean hasAirportChange) {
        this.hasAirportChange = hasAirportChange;
    }

    public Integer getTechnicalStops() {
        return technicalStops;
    }

    public void setTechnicalStops(Integer technicalStops) {
        this.technicalStops = technicalStops;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public HashMap<Integer, Float> getBagsPrice() {
        return bagsPrice;
    }

    public void setBagsPrice(HashMap<Integer, Float> bagsPrice) {
        this.bagsPrice = bagsPrice;
    }

    public FlightsBagLimitDTO getBaglimit() {
        return baglimit;
    }

    public void setBaglimit(FlightsBagLimitDTO baglimit) {
        this.baglimit = baglimit;
    }

    public HashMap<String, Float> getConversion() {
        return conversion;
    }

    public void setConversion(HashMap<String, Float> conversion) {
        this.conversion = conversion;
    }

    public Double getQuality() {
        return quality;
    }

    public void setQuality(Double quality) {
        this.quality = quality;
    }
}
