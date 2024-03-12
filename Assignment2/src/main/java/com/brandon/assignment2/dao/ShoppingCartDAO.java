package com.brandon.assignment2.dao;

import com.brandon.assignment2.model.Product;
import com.brandon.assignment2.model.ShoppingCartItem;

import java.sql.SQLException;
import java.util.List;

public interface ShoppingCartDAO {
    public void add(int id, int productId, int quantity) throws SQLException;
    public void remove(int id) throws SQLException;
    public void removeAll(int id) throws SQLException;
    public void modify(int quantity, int id) throws SQLException;
    public List<ShoppingCartItem> selectAll(int id) throws SQLException;
}
