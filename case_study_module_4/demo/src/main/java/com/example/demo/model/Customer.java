package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name",nullable = false, columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(name = "date_of_birth",nullable = false, columnDefinition = "DATE")
    private String date;

    @Column(name = "gender",nullable = false, columnDefinition = "BIT(1) DEFAULT 0")
    private boolean gender;

    @Column(name = "id_card",nullable = false, columnDefinition = "VARCHAR(50)")
    private String idCard;

    @Column(name = "phone_number",nullable = false, columnDefinition = "VARCHAR(50)")
    private String phone;

    @Column(name = "address",nullable = false, columnDefinition = "VARCHAR(50)")
    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;

    @Column(name = "is_delete", columnDefinition = "BIT(1) DEFAULT 0")
    private boolean isDelete;

    public Customer() {
    }

    public Customer(int id, String name, String date, boolean gender, String idCard, String phone, String address, CustomerType customerType, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.address = address;
        this.customerType = customerType;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
