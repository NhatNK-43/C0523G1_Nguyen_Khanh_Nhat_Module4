package com.example.case_study_4.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList;

    @ManyToOne
    @JoinColumn(name = "table_bar_id",referencedColumnName = "id")
    private TableBar tableBar;

    public Order() {
    }

    public Order(LocalDateTime orderDate, Employee employee, Customer customer, List<OrderDetail> orderDetailList, TableBar tableBar) {
        this.orderDate = orderDate;
        this.employee = employee;
        this.customer = customer;
        this.orderDetailList = orderDetailList;
        this.tableBar = tableBar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public TableBar getTableBar() {
        return tableBar;
    }

    public void setTableBar(TableBar tableBar) {
        this.tableBar = tableBar;
    }
}
