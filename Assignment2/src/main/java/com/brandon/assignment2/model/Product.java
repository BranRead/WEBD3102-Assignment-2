package com.brandon.assignment2.model;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private String description;
    private int stock;
    private float cost;

    public Product(int id, String name, String description, int stock, float cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.cost = cost;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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