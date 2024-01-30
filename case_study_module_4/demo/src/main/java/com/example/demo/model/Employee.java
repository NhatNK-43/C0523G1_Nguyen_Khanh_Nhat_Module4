package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", columnDefinition = "varchar(50) not null")
    private String name;
    @Column(name = "date_of_birth", columnDefinition = "date not null")
    private String dateOfBirth;
    @Column(name = "gender", columnDefinition = "bit not null")
    private boolean gender;
    @Column(name = "id_card", columnDefinition = "varchar(50) not null unique")
    private String idCard;
    @Column(name = "phone_number", columnDefinition = "varchar(50) not null unique")
    private String phoneNumber;
    @Column(name = "address", columnDefinition = "varchar(200) not null")
    private String address;
    @Column(name = "salary", columnDefinition = "double not null")
    private double salary;
    @Column(name = "user_name", columnDefinition = "varchar(50) not null unique")
    private String userName;
    @Column(name = "password", columnDefinition = "varchar(50) not null")
    private String password;
    @Column(name = "id_delete", columnDefinition = "bit(1) default 0")
    private boolean idDelete;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    public Employee() {
    }

    public Employee(int id, String name, String dateOfBirth, boolean gender, String idCard, String phoneNumber, String address, double salary, String userName, String password, boolean idDelete, Position position) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
        this.userName = userName;
        this.password = password;
        this.idDelete = idDelete;
        this.position = position;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIdDelete() {
        return idDelete;
    }

    public void setIdDelete(boolean idDelete) {
        this.idDelete = idDelete;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
