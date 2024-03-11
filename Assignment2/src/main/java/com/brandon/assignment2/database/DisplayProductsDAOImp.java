package com.brandon.assignment2.database;

import com.brandon.assignment2.dao.DisplayProductsDAO;
import com.brandon.assignment2.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import static com.brandon.assignment2.database.MySQLConnection.getConnection;

public class DisplayProductsDAOImp implements DisplayProductsDAO {
    private static final String SQL_SELECT_ALL = "SELECT * FROM products";

    private Connection jdbcConnection;

    @Override
    public List<Product> selectAll(){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        List<Product> products = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_SELECT_ALL);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")
                );
                products.add(product);
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        return products;
    }
}
