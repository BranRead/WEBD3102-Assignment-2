package com.brandon.assignment2.database;

import com.brandon.assignment2.dao.OrderDAO;
import com.brandon.assignment2.model.ShoppingCartItem;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.brandon.assignment2.database.MySQLConnection.getConnection;

public class OrderDAOImp implements OrderDAO {
    private static final String SQL_INSERT_ORDER = "INSERT INTO orders (user_id, is_shipped, address_id) VALUES(?, 0, ?)";
    private static final String SQL_INSERT_ORDER_MAP = "INSERT INTO order_map (order_id, product_id, quantity, cost) VALUES(?, ?, ?, ?)";

    private static final String SQL_SELECT_LAST_ORDER = "SELECT * FROM orders ORDER BY ID DESC LIMIT 1";

    private static final String SQL_SELECT_ALL_ORDERS = "SELECT * FROM orders WHERE user_id = ?";
    @Override
    public int addOrder(int user_id, int address_id) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_INSERT_ORDER);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, address_id);
            preparedStatement.executeUpdate();

            preparedStatement = conn.prepareStatement(SQL_SELECT_LAST_ORDER);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            return rs.getInt("id");
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
            return 0;
        }
    }

    @Override
    public void addOrderMap(int id, List<ShoppingCartItem> shoppingCartItems) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        try {
            conn = getConnection();
            for (ShoppingCartItem item:
                 shoppingCartItems) {
                preparedStatement = conn.prepareStatement(SQL_INSERT_ORDER_MAP);
                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, item.getId());
                preparedStatement.setInt(3, item.getQuantityInCart());
                preparedStatement.setFloat(4, item.getCost());
                preparedStatement.executeUpdate();
            }

        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
