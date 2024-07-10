package com.amdocs.orderDemo.response;

import com.amdocs.orderDemo.Entities.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderResponse  {

    private Integer orderId;
    private CustomerResponse customer;
    private List<ProductsResponse> products = new ArrayList<>();

    //private double pricing;


    private Integer totalQuantityProducts;



    private double extraDiscount;

    private double totalPrice;




    //private ProductsResponse productsResponse;

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



    public Integer getTotalQuantityProducts() {
        return totalQuantityProducts;
    }

    public void setTotalQuantityProducts(Integer totalQuantityProducts) {
        this.totalQuantityProducts = totalQuantityProducts;
    }

    public double getExtraDiscount() {
        return extraDiscount;
    }

    public void setExtraDiscount(double extraDiscount) {
        this.extraDiscount = extraDiscount;
    }

    public CustomerResponse getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponse customer) {
        this.customer = customer;
    }




}
