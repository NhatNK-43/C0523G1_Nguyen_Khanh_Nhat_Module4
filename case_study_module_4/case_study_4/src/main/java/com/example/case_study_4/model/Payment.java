package com.example.case_study_4.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "total_payment", nullable = false)
    private double totalPayment;

    @Column(name = "payment_date", nullable = false)
    private LocalDateTime paymentDate;

    @OneToOne
    @JoinColumn(name = "table_bar_id", referencedColumnName = "id")
    private TableBar tableBar;

    public Payment() {
    }

    public Payment(double totalPayment, LocalDateTime paymentDate, TableBar tableBar) {
        this.totalPayment = totalPayment;
        this.paymentDate = paymentDate;
        this.tableBar = tableBar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public TableBar getTableBar() {
        return tableBar;
    }

    public void setTableBar(TableBar tableBar) {
        this.tableBar = tableBar;
    }
}
