package com.example.demo.model;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "commodities")
public class Commodity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name",columnDefinition = "varchar(50) not null")
    private String name;

    @Column(name = "price",columnDefinition = "double not null")
    private double price;

    @Column(name = "quantity",nullable = false)
    private double quantity;
    @Column(name = "is_delete",columnDefinition = "bit(1) default 0")
    private boolean isDelete;

   @ManyToOne
   @JoinColumn(name = "commodity_unit_id", referencedColumnName = "id")
   private CommodityUnit commodityUnit;
    @ManyToOne
    @JoinColumn(name="commodity_type_id", referencedColumnName = "id")
    private CommodityType commodityType;

    @OneToMany(mappedBy = "commodity")
    private List<OrderDetail> orderDetailList;

    public Commodity() {
    }

    public Commodity(int id, String name, double price, double quantity, boolean isDelete, CommodityUnit commodityUnit,
                     CommodityType commodityType, List<OrderDetail> orderDetailList) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isDelete = isDelete;
        this.commodityUnit = commodityUnit;
        this.commodityType = commodityType;
        this.orderDetailList = orderDetailList;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public CommodityUnit getCommodityUnit() {
        return commodityUnit;
    }

    public void setCommodityUnit(CommodityUnit commodityUnit) {
        this.commodityUnit = commodityUnit;
    }

    public CommodityType getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(CommodityType commodityType) {
        this.commodityType = commodityType;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }
}
