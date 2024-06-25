package com.amdocs.orderDemo.request;

public class ProductOrderRequest {



    private Integer productID;

    private Integer quantity;

    private Integer orderID;


    public ProductOrderRequest(){

    }
    public ProductOrderRequest(Integer productID, Integer quantity, Integer orderID) {
        this.productID = productID;
        this.quantity = quantity;
        this.orderID = orderID;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }
}
