package com.brandon.assignment2.model;

public class Stock {
    private int id;
    private int productId;
    private int stock;
    private float cost;

    public Stock(int id, int productId, int stock, float cost) {
        this.id = id;
        this.productId = productId;
        this.stock = stock;
        this.cost = cost;
    }

    public Stock() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
