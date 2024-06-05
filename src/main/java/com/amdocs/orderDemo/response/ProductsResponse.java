package com.amdocs.orderDemo.response;



import java.time.LocalDate;

public class ProductsResponse {


    private PricingResponse pricingResponse;

    private String productName;
    private String description;


    private LocalDate date;

    public ProductsResponse(String productName, String description, PricingResponse pricingResponse, LocalDate date) {
        this.productName = productName;
        this.description = description;
        this.pricingResponse = pricingResponse;
        this.date = date;
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
        return pricingResponse;
    }


    public void setPricing(PricingResponse pricing) {
        this.pricingResponse = pricingResponse;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
