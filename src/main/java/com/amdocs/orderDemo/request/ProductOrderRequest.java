package com.amdocs.orderDemo.request;

public class ProductOrderRequest {



    private Integer productId;

    private Integer quantity;

    private Integer orderId;


    public ProductOrderRequest(){

    }
    public ProductOrderRequest(Integer productId, Integer quantity, Integer orderId) {
        this.productId= productId;
        this.quantity = quantity;
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductID(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
