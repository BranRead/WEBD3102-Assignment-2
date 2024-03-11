package com.brandon.assignment2.dao;

import com.brandon.assignment2.model.Product;
import com.brandon.assignment2.model.Review;
import com.brandon.assignment2.model.User;

import java.sql.SQLException;
import java.util.List;

public interface DisplayProductsDAO {
    public List<Product> selectAll() throws SQLException;
    public List<Review> selectAllReviews(int id) throws SQLException;
}
