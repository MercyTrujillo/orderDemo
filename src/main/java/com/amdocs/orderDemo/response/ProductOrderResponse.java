package com.amdocs.orderDemo.response;

public class ProductOrderResponse {




    private Integer productOrderId;

    private Integer productID;

    private Integer quantity;



    private Integer orderID;


    public ProductOrderResponse(Integer productOrderId, Integer productID, Integer quantity, Integer orderID) {
        this.productOrderId = productOrderId;
        this.productID = productID;
        this.quantity = quantity;
        this.orderID = orderID;
    }

    public Integer getProductOrderId() {
        return productOrderId;
    }

    public void setId(Integer productOrderId) {
        this.productOrderId = productOrderId;
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
