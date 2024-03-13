package com.brandon.assignment2.database;

import com.brandon.assignment2.dao.AddressDAO;
import com.brandon.assignment2.model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.brandon.assignment2.database.MySQLConnection.getConnection;

public class AddressDAOImp implements AddressDAO {

    private static final String SQL_SELECT = "SELECT * FROM address WHERE user_id = ?";
    private static final String SQL_ADD = "INSERT INTO address (user_id, street, city, province_state, postal_code) VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Address> select(int userId) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        List<Address> addresses = new ArrayList<>();

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_SELECT);
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                Address address = new Address();
                address.setId(rs.getInt("id"));
                address.setUserId(userId);
                address.setStreet(rs.getString("street"));
                address.setCity(rs.getString("city"));
                address.setProvinceState(rs.getString("province_state"));
                address.setPostalCode(rs.getString("postal_code"));
                addresses.add(address);
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
        return addresses;
    }

    @Override
    public void add(Address address) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_ADD);
            preparedStatement.setInt(1, address.getUserId());
            preparedStatement.setString(2, address.getStreet());
            preparedStatement.setString(3, address.getCity());
            preparedStatement.setString(4, address.getProvinceState());
            preparedStatement.setString(5, address.getPostalCode());
            preparedStatement.executeUpdate();
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }
    }
}
