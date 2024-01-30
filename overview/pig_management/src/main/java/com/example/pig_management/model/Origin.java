package com.example.pig_management.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "origins")
public class Origin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false, unique = true, columnDefinition = "varchar(50)")
    private String name;

    @OneToMany(mappedBy = "origin")
    private List<Pig> pigList;

    public Origin() {
    }

    public Origin(String name, List<Pig> pigList) {
        this.name = name;
        this.pigList = pigList;
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

    public List<Pig> getPigList() {
        return pigList;
    }

    public void setPigList(List<Pig> pigList) {
        this.pigList = pigList;
    }
}
