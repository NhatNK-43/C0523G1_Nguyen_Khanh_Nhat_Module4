package com.example.case_study_4.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer_type")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", columnDefinition = "VARCHAR(50)")
    private String name;

    @OneToMany(mappedBy = "customerType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Customer> customerList;

    public CustomerType() {
    }

    public CustomerType(int id, String name, List<Customer> customerList) {
        this.id = id;
        this.name = name;
        this.customerList = customerList;
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

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
