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

    private static final String SQL_UPDATE = "UPDATE shopping_cart SET quantity = ? WHERE id = ?";

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

    public void modify(int quantity, int id) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_ADD);
            preparedStatement.setInt(1, quantity);
            preparedStatement.setInt(2, id);
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
            ShoppingCartItem shoppingCartItem = new ShoppingCartItem(
                    0,
                    exception.getMessage(),
                    exception.getMessage(),
                    0,
                    2.0f,
                    0,
                    0,
                    0
            );
            shoppingCart.add(shoppingCartItem);
            System.out.println("Error: " + exception.getMessage());
        }
        return shoppingCart;
    }
}
