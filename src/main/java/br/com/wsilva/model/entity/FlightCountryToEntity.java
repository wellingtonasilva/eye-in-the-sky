package br.com.wsilva.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FlightCountryToEntity {

    @Column(name = "flig_country_to_code")
    private String code;

    @Column(name = "flig_country_to_name")
    private String name;

    public FlightCountryToEntity() {
    }

    public FlightCountryToEntity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}