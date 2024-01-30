package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "table_status")
public class TableStatus {
    @Id
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "tableStatus")
    private Set<TableBar> tableBarSet;

    public TableStatus() {
    }

    public TableStatus(int id, String name, Set<TableBar> tableBarSet) {
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
