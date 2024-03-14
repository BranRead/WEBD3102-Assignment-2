package com.brandon.assignment2.database;

import com.brandon.assignment2.dao.DisplayProductsDAO;
import com.brandon.assignment2.model.Product;
import com.brandon.assignment2.model.Review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.brandon.assignment2.database.MySQLConnection.getConnection;

public class DisplayProductsDAOImp implements DisplayProductsDAO {
    private static final String SQL_SELECT_ALL =
            "SELECT products.id, " +
                    "products.name, " +
                    "products.description, " +
                    "stock.stock, " +
                    "stock.cost " +
                    "FROM products INNER JOIN stock ON products.id = stock.product_id";
    private static final String SQL_SELECT_ALL_REVIEWS =
            "SELECT product_id, comment, score FROM reviews where product_id = ?";

    private static final String SQL_SELECT_STOCK =
            "SELECT stock FROM stock WHERE product_id = ?";

    private static final String SQL_UPDATE_STOCK = "UPDATE stock SET stock = ? WHERE product_id = ?";

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
            Product product = new Product(0, "Error", exception.getMessage(), 2, 4.0f);
            products.add(product);
            System.out.println("Error: " + exception.getMessage());
        }

        return products;
    }

    @Override
    public List<Review> selectAllReviews(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        List<Review> reviews = new ArrayList<>();

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_SELECT_ALL_REVIEWS);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();

            while (rs.next()){
                Review review = new Review(
                        rs.getInt("product_id"),
                        rs.getString("comment"),
                        rs.getInt("score")
                );
                reviews.add(review);
            }
        } catch (Exception exception) {
            Review review = new Review(0, "Error: " + exception.getMessage(), 5);
            reviews.add(review);
            System.out.println("Error: " + exception.getMessage());
        }

        return reviews;
    }

    @Override
    public int selectStock(int productId){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        int stock = 0;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_SELECT_STOCK);
            preparedStatement.setInt(1, productId);
            rs = preparedStatement.executeQuery();
            rs.next();
            stock = rs.getInt("stock");
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return stock;
    }

    @Override
    public void updateStock(int productId, int stock) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_UPDATE_STOCK);
            preparedStatement.setInt(1, stock);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}