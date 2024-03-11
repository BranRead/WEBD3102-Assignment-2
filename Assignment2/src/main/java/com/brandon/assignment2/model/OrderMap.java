package com.brandon.assignment2.model;

public class OrderMap {
    private int id;
    private int userId;

    public OrderMap(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public OrderMap() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
