package com.brandon.assignment2.model;

public class ShoppingCartItem extends Product{
    private int shoppingCartId;
    private int quantityInCart;

    public ShoppingCartItem(int id, String name, String description, int stock, float cost, int shoppingCartId, int quantityInCart) {
        super(id, name, description, stock, cost);
        this.shoppingCartId = shoppingCartId;
        this.quantityInCart = quantityInCart;
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
}
