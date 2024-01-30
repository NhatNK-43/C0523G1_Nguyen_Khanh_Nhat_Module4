package com.example.pig_management.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "pigs")
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "pig_code",nullable = false, unique = true, columnDefinition = "varchar(50)")
    private String pigCode;
    @Column(name = "date_import", nullable = false, columnDefinition = "date")
    private Date dateImport;
    @Column(name = "weight_import", nullable = false)
    private Double weightImport;
    @Column(name = "date_export", columnDefinition = "date")
    private Date dateExport;

    @Column(name = "weight_export")
    private Double weightExport;
    @ManyToOne
    @JoinColumn(name = "origin_id", referencedColumnName = "id")
    private Origin origin;

    @Column(name = "is_sold", columnDefinition = "bit(1) default 0")
    private boolean sold;
    @Column(name = "is_deleted", columnDefinition = "bit(1) default 0")
    private boolean deleted;

    public Pig() {
    }

    public Pig(String pigCode, Date dateImport, Double weightImport, Date dateExport, Double weightExport, Origin origin) {
        this.pigCode = pigCode;
        this.dateImport = dateImport;
        this.weightImport = weightImport;
        this.dateExport = dateExport;
        this.weightExport = weightExport;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPigCode() {
        return pigCode;
    }

    public void setPigCode(String pigCode) {
        this.pigCode = pigCode;
    }

    public Date getDateImport() {
        return dateImport;
    }

    public void setDateImport(Date dateImport) {
        this.dateImport = dateImport;
    }

    public Double getWeightImport() {
        return weightImport;
    }

    public void setWeightImport(double weight_import) {
        this.weightImport = weight_import;
    }

    public Date getDateExport() {
        return dateExport;
    }

    public void setDateExport(Date dateExport) {
        this.dateExport = dateExport;
    }

    public Double getWeightExport() {
        return weightExport;
    }

    public void setWeightExport(double weightExport) {
        this.weightExport = weightExport;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
