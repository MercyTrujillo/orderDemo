package com.amdocs.orderDemo.request;

public class OrderRequest {
    private String products;

    private double pricing;


    private Integer quantityProducts;

    private double discount;

    private Integer customerID;

    public OrderRequest(String products, double pricing, Integer quantityProducts, double discount,Integer customerID) {
        this.products = products;
        this.pricing = pricing;
        this.quantityProducts = quantityProducts;
        this.discount = discount;
        this.customerID = customerID;
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

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }
}
