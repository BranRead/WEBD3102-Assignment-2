package com.brandon.assignment2.model;

public class ShoppingCartItem extends Product{
    private int userId;
    private int shoppingCartId;
    private int quantityInCart;


    public ShoppingCartItem(int id, String name, String description, int stock, float cost, int shoppingCartId, int quantityInCart, int userId) {
        super(id, name, description, stock, cost);
        this.shoppingCartId = shoppingCartId;
        this.quantityInCart = quantityInCart;
        this.userId = userId;
    }

    public ShoppingCartItem() {
    }

    public int getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(int shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public int getQuantityInCart() {
        return quantityInCart;
    }

    public void setQuantityInCart(int quantityInCart) {
        this.quantityInCart = quantityInCart;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
