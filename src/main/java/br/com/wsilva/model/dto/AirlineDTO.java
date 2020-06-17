package br.com.wsilva.model.dto;

import br.com.wsilva.model.entity.AirlineEntity;

import java.io.Serializable;

public class AirlineDTO implements Serializable {

    private String id;
    private Integer lcc;
    private String name;
    private String type;

    public AirlineDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLcc() {
        return lcc;
    }

    public void setLcc(Integer lcc) {
        this.lcc = lcc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AirlineEntity from() {
        return new AirlineEntity(getId(), getLcc(), getName(), getType());
    }
}