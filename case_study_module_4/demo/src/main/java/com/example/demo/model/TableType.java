package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "table_type")
public class TableType {
    @Id
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "tableType")
    private Set<TableBar> tableBarSet;

    public TableType() {
    }

    public TableType(int id, String name, Set<TableBar> tableBarSet) {
        this.id = id;
        this.name = name;
        this.tableBarSet = tableBarSet;
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

    public Set<TableBar> getTableBarSet() {
        return tableBarSet;
    }

    public void setTableBarSet(Set<TableBar> tableBarSet) {
        this.tableBarSet = tableBarSet;
    }
}
