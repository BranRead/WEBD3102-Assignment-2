package com.brandon.assignment2.model;

public class Reviews {
    private int id;
    private int productId;
    private String comment;
    private int score;

    public Reviews(int id, int productId, String comment, int score) {
        this.id = id;
        this.productId = productId;
        this.comment = comment;
        this.score = score;
    }

    public Reviews() {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
