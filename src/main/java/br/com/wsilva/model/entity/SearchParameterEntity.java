package br.com.wsilva.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "search_param")
public class SearchParameterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sear_id")
    private Integer id;

    @Column(name = "sear_code")
    private String code;

    @Column(name = "sear_currency_rate")
    private Float rate;

    @Column(name = "sear_currency")
    private String currency;

    @Column(name = "sear_destination")
    private String destination;

    @Column(name = "sear_date_from")
    private String dateFrom;

    @Column(name = "sear_date_to")
    private String dateTo;

    public SearchParameterEntity() {
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

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}
