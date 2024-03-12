package com.brandon.assignment2.model;

public class OrderMap {
    private int productId;
    private int orderId;

    public OrderMap(int productId, int orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

    public OrderMap() {}

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
