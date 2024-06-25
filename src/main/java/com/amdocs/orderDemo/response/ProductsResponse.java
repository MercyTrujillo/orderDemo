package com.amdocs.orderDemo.response;


public class ProductsResponse {


    private PricingResponse pricing;

    private String productName;
    private String description;

    private Integer quantity;




    public ProductsResponse(String productName, String description, PricingResponse pricing,Integer quantity ) {
        this.productName = productName;
        this.description = description;
        this.pricing = pricing;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public PricingResponse getPricing() {
        return pricing;
    }


    public void setPricing(PricingResponse pricing) {
        this.pricing = pricing;
    }


}
