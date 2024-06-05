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

    private double discount;

    private Integer customer;

    @CreatedDate
    @Column(name = "creationDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    public Order() {
    }


    public Order(Integer orderId, double discount, Integer customer, LocalDate creationDate) {
        this.orderId = orderId;
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


    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
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
