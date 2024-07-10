package com.amdocs.orderDemo.response;

public class ProductOrderResponse {




    private Integer productOrderId;

    private Integer productId;

    private Integer quantity;


    private Integer orderId;


    public ProductOrderResponse(Integer productOrderId, Integer productId, Integer quantity, Integer orderId) {
        this.productOrderId = productOrderId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderId = orderId;
    }

    public Integer getProductOrderId() {
        return productOrderId;
    }

    public void setId(Integer productOrderId) {
        this.productOrderId = productOrderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
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
