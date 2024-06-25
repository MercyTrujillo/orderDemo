package com.amdocs.orderDemo.response;

import com.amdocs.orderDemo.Entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderResponse {

    private Integer orderId;
    private List<ProductsResponse> products = new ArrayList<>();

    private double pricing;


    private Integer quantityProducts;

    private double discount;

    private double tax;

    private double totalDiscount;

    private double totalPrice;


    private CustomerResponse customer;

    private ProductsResponse productsResponse;

    public OrderResponse(Order order) {
    }

    public OrderResponse() {

    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<ProductsResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsResponse> products) {
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

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public CustomerResponse getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponse customer) {
        this.customer = customer;
    }


    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public ProductsResponse getProductsResponse() {
        return productsResponse;
    }

    public void setProductsResponse(ProductsResponse productsResponse) {
        this.productsResponse = productsResponse;
    }
}
