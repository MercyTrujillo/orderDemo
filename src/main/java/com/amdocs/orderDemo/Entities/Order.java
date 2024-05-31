package com.amdocs.orderDemo.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ordertable")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement ID]
    @Column(name = "orderId")
    private Integer orderId;

    private String products;

    private double pricing;


    private Integer quantityProducts;

    private double discount;

    private String customer;

    @CreatedDate
    @Column(name = "creationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    public Order() {
    }


    public Order(Integer orderId, String products, double pricing, Integer quantityProducts, double discount, String customer, LocalDate creationDate) {
        this.orderId = orderId;
        this.products = products;
        this.pricing = pricing;
        this.quantityProducts = quantityProducts;
        this.discount = discount;
        this.customer = customer;
        this.creationDate = creationDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public double getPricing() {
        return pricing;
    }

    public void setPricing(double pricing) {
        this.pricing = pricing;
    }

    public Integer getQuantityProducts() {
        return quantityProducts;
    }

    public void setQuantityProducts(Integer quantityProducts) {
        this.quantityProducts = quantityProducts;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
