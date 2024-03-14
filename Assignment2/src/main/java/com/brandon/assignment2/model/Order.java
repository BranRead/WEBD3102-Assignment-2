package com.brandon.assignment2.model;

public class Order extends Address{
    private int id;
    private int userId;
    private boolean isShipped;
    private String trackingNumber;

    public Order(int id, int userId, boolean isShipped, String trackingNumber) {
        this.id = id;
        this.userId = userId;
        this.isShipped = isShipped;
        this.trackingNumber = trackingNumber;
    }

    public Order() {
    }

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

    public boolean isShipped() {
        return isShipped;
    }

    public void setShipped(boolean shipped) {
        isShipped = shipped;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
