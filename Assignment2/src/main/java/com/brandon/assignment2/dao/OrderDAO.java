package com.brandon.assignment2.dao;

import com.brandon.assignment2.model.ShoppingCartItem;

import java.sql.SQLException;
import java.util.List;

public interface OrderDAO {
    public int addOrder(int user_id, int address_id) throws SQLException;
    public void addOrderMap(int id, List<ShoppingCartItem> shoppingCartItems) throws SQLException;
}
