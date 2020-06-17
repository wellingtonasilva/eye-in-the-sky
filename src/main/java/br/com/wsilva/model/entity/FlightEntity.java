package br.com.wsilva.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flight")
public class FlightEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flig_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sear_id")
    private SearchParameterEntity searchParameter;

    @Column(name = "flig_code")
    private String code;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "flig_dtime")
    private Date dTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "flig_dtime_utc")
    private Date dTimeUtc;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "flig_atime")
    private Date aTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "flig_atime_utc")
    private Date aTimeUtc;

    @Embedded
    private FlightDurationEntity duration;

    @Column(name = "flig_fly_from")
    private String flyFrom;

    @Column(name = "flig_city_from")
    private String cityFrom;

    @Column(name = "flig_city_code_from")
    private String cityCodeFrom;

    @Embedded
    private FlightCountryFromEntity countryFrom;

    @Column(name = "flig_map_id_from")
    private String mapIdFrom;

    @Column(name = "flig_fly_to")
    private String flyTo;

    @Column(name = "flig_city_to")
    private String cityTo;

    @Column(name = "flig_city_code_to")
    private String cityCodeTo;

    @Embedded
    private FlightCountryToEntity countryTo;

    @Column(name = "flig_map_id_to")
    private String mapIdTo;

    @Column(name = "flig_distance")
    private Float distance;

    @Column(name = "flig_price")
    private Float price;

    public FlightEntity() {
    }

    public SearchParameterEntity getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(SearchParameterEntity searchParameter) {
        this.searchParameter = searchParameter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getdTime() {
        return dTime;
    }

    public void setdTime(Date dTime) {
        this.dTime = dTime;
    }

    public Date getdTimeUtc() {
        return dTimeUtc;
    }

    public void setdTimeUtc(Date dTimeUtc) {
        this.dTimeUtc = dTimeUtc;
    }

    public Date getaTime() {
        return aTime;
    }

    public void setaTime(Date aTime) {
        this.aTime = aTime;
    }

    public Date getaTimeUtc() {
        return aTimeUtc;
    }

    public void setaTimeUtc(Date aTimeUtc) {
        this.aTimeUtc = aTimeUtc;
    }

    public FlightDurationEntity getDuration() {
        return duration;
    }

    public void setDuration(FlightDurationEntity duration) {
        this.duration = duration;
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

    public FlightCountryFromEntity getCountryFrom() {
        return countryFrom;
    }

    public void setCountryFrom(FlightCountryFromEntity countryFrom) {
        this.countryFrom = countryFrom;
    }

    public String getMapIdFrom() {
        return mapIdFrom;
    }

    public void setMapIdFrom(String mapIdFrom) {
        this.mapIdFrom = mapIdFrom;
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

    public FlightCountryToEntity getCountryTo() {
        return countryTo;
    }

    public void setCountryTo(FlightCountryToEntity countryTo) {
        this.countryTo = countryTo;
    }

    public String getMapIdTo() {
        return mapIdTo;
    }

    public void setMapIdTo(String mapIdTo) {
        this.mapIdTo = mapIdTo;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
