package com.brandon.assignment2.model;

public class order_map {
    private int id;
    private int userId;

    public order_map(int id, int userId) {
        this.id = id;
        this.userId = userId;
    }

    public order_map() {}

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
