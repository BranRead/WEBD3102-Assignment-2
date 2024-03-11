package com.brandon.assignment2.database;

import com.brandon.assignment2.dao.DisplayProductsDAO;
import com.brandon.assignment2.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.brandon.assignment2.database.MySQLConnection.getConnection;

public class DisplayProductsDAOImp implements DisplayProductsDAO {
    private static final String SQL_SELECT_ALL =
            "SELECT products.id, " +
                    "products.name, " +
                    "products.description, " +
                    "stock.quantity, " +
                    "stock.cost " +
                    "FROM products INNER JOIN stock ON products.id = stock.product_id";

    private Connection jdbcConnection;

    @Override
    public List<Product> selectAll(){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        List<Product> products = new ArrayList<>();

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_SELECT_ALL);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getInt("stock"),
                        rs.getFloat("cost")
                );
                products.add(product);
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        return products;
    }
}
