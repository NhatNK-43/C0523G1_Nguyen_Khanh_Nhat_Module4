package com.example.pig_management.dto;

import com.example.pig_management.model.Origin;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import java.sql.Date;

public class PigDto implements Validator {
    private int id;
    private String pigCode;
    private Date dateImport;
    private Double weightImport;
    private Date dateExport;

    private Double weightExport;
    private Origin origin;

    public PigDto() {
    }

    public PigDto(String pigCode, Date dateImport, Double weightImport, Date dateExport, Double weightExport, Origin origin) {
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

    public void setWeightImport(double weightImport) {
        this.weightImport = weightImport;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
