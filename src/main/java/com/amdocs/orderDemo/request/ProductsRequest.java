package com.amdocs.orderDemo.request;



public class ProductsRequest {

    private String productName;
    private String description;


    private PricingRequest pricingRequest;

    public ProductsRequest(String productName, String description, PricingRequest pricingRequest) {
        this.productName = productName;
        this.description = description;

        this.pricingRequest = pricingRequest;
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

    public PricingRequest pricingRequest() {
        return pricingRequest;
    }

    public void setPricingRequest(PricingRequest pricingRequest) {
        this.pricingRequest = pricingRequest;
    }



}
