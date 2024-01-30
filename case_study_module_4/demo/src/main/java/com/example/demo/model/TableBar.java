package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "table_bar")
public class TableBar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "table_type_id",referencedColumnName = "id")
    private TableType tableType;

    @ManyToOne
    @JoinColumn(name = "table_status_id",referencedColumnName = "id")
    private TableStatus tableStatus;

    @Column(name = "is_delete", columnDefinition = "bit(1) default 0")
    private boolean isDelete;

    @OneToMany(mappedBy = "tableBar")
    private Set<Order> orderSet;

    public TableBar() {
    }

    public TableBar(int id, String name, TableType tableType, TableStatus tableStatus, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.tableType = tableType;
        this.tableStatus = tableStatus;
        this.isDelete = isDelete;
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

    public TableType getTableType() {
        return tableType;
    }

    public void setTableType(TableType tableType) {
        this.tableType = tableType;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
