package com.example.studentapp.entity;

import java.io.Serializable;
public class Item implements Serializable {

    private String productCode;
    private String description;
    private double price;
    private int quantity;

    public Item() {
        this.description = "";
        this.price = 0.0;
        this.quantity = 1;
    }

    public Item(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return this.price * this.quantity;
    }
}
