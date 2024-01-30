package com.example.case_study_4.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "commodity_unit")
public class CommodityUnit {
    @Id
    private int id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @OneToMany(mappedBy = "commodityUnit")
    private Set<Commodity> commoditySet;

    public CommodityUnit() {
    }

    public CommodityUnit(int id, String name, Set<Commodity> commoditySet) {
        this.id = id;
        this.name = name;
        this.commoditySet = commoditySet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Commodity> getCommoditySet() {
        return commoditySet;
    }

    public void setCommoditySet(Set<Commodity> commoditySet) {
        this.commoditySet = commoditySet;
    }
}
