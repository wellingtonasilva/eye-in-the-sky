package br.com.wsilva.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FlightCountryFromEntity {

    @Column(name = "flig_country_from_code")
    private String code;

    @Column(name = "flig_country_from_name")
    private String name;

    public FlightCountryFromEntity() {
    }

    public FlightCountryFromEntity(String code, String name) {
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
