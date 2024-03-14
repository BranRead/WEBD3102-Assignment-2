package com.brandon.assignment2.database;

import com.brandon.assignment2.dao.ShoppingCartDAO;
import com.brandon.assignment2.model.Product;
import com.brandon.assignment2.model.ShoppingCartItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.brandon.assignment2.database.MySQLConnection.getConnection;

public class ShoppingCartDAOImp implements ShoppingCartDAO {
    private static final String SQL_ADD = "INSERT INTO shopping_cart (user_id, product_id, quantity) VALUES(?, ?, ?)";

    private static final String SQL_REMOVE = "DELETE FROM shopping_cart WHERE id = ?";
    private static final String SQL_REMOVE_All = "DELETE FROM shopping_cart WHERE user_id = ?";

    private static final String SQL_UPDATE = "UPDATE shopping_cart SET quantity = ? WHERE product_id = ? AND user_id = ?";

    private static final String SQL_SELECT =
            "SELECT shopping_cart.id, " +
                    "shopping_cart.product_id, " +
                    "shopping_cart.quantity, " +
                    "products.name, " +
                    "products.description, " +
                    "stock.cost, " +
                    "stock.stock " +
                    "FROM shopping_cart " +
                    "INNER JOIN products ON shopping_cart.product_id = products.id " +
                    "INNER JOIN stock ON shopping_cart.product_id = stock.product_id " +
                    "WHERE shopping_cart.user_id = ?";

    private static final String SQL_SELECT_QUANTITY = "SELECT quantity from shopping_cart WHERE product_id = ? AND user_id = ?";

    public void add(int id, int productId, int quantity) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_ADD);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, productId);
            preparedStatement.setInt(3, quantity);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    public void remove(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_ADD);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    public void removeAll(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_REMOVE_All);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    public void modify(int quantity, int product_id, int user_id) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_UPDATE);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, product_id);
            preparedStatement.setInt(3, user_id);
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }

    public List<ShoppingCartItem> selectAll(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        List<ShoppingCartItem> shoppingCart = new ArrayList<>();

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_SELECT);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();

            while (rs.next()){
                 ShoppingCartItem shoppingCartItem = new ShoppingCartItem(
                         rs.getInt("shopping_cart.product_id"),
                         rs.getString("products.name"),
                         rs.getString("products.description"),
                         rs.getInt("stock.stock"),
                         rs.getFloat("stock.cost"),
                         rs.getInt("shopping_cart.id"),
                         rs.getInt("shopping_cart.quantity"),
                         id
                );
                shoppingCart.add(shoppingCartItem);
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return shoppingCart;
    }

    @Override
    public int selectQuantity(int productId, int userId) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        int quantity = 0;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_SELECT_QUANTITY);
            preparedStatement.setInt(1, productId);
            preparedStatement.setInt(2, userId);
            rs = preparedStatement.executeQuery();

            rs.next();
            quantity = rs.getInt("quantity");
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return quantity;
    }
}