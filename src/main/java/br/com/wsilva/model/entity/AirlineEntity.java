package br.com.wsilva.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "airlines")
public class AirlineEntity implements Serializable {

    @Id
    @Column(name = "airl_id")
    private String id;

    @Column(name = "airl_lcc")
    private Integer lcc;

    @Column(name = "airl_name")
    private String name;

    @Column(name = "airl_type")
    private String type;

    public AirlineEntity() {
    }

    public AirlineEntity(String id, Integer lcc, String name, String type) {
        this.id = id;
        this.lcc = lcc;
        this.name = name;
        this.type = type;
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
}