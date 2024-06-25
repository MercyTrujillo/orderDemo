package com.amdocs.orderDemo.request;

import com.amdocs.orderDemo.response.ProductOrderResponse;

import java.util.List;

public class OrderRequest {
    private List<ProductOrderRequest> products;

    private double pricing;


    private Integer quantityProducts;

    private double totalDiscount;

    private Integer customerID;
    private Integer orderId;

    public OrderRequest(List<ProductOrderRequest> products, double pricing, Integer quantityProducts, double totalDiscount, Integer customerID, Integer orderId) {
        this.products = products;
        this.pricing = pricing;
        this.quantityProducts = quantityProducts;
        this.totalDiscount = totalDiscount;
        this.customerID = customerID;
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<ProductOrderRequest> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOrderRequest> products) {
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
        return totalDiscount;
    }

    public void setDiscount(double discount) {
        this.totalDiscount = totalDiscount;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }



}
