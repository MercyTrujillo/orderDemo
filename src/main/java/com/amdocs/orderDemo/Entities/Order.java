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

    private double extraDiscount;

    @Column(name = "customer_Id")
    private Integer customer;

    @CreatedDate
    @Column(name = "creationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    public Order() {
    }


    public Order(Integer orderId, double extraDiscount, Integer customer, LocalDate creationDate) {
        this.orderId = orderId;
        this.extraDiscount = extraDiscount;
        this.customer = customer;
        this.creationDate = creationDate;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    public double getExtraDiscount() {
        return extraDiscount;
    }

    public void setExtraDiscount(double extraDiscount) {
        this.extraDiscount = extraDiscount;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
