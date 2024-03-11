package com.brandon.assignment2.database;

import com.brandon.assignment2.dao.LoginDAO;
import com.brandon.assignment2.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.brandon.assignment2.database.MySQLConnection.getConnection;

public class LoginDAOImp implements LoginDAO {
    private static final String SQL_SELECT = "SELECT id, fName, lName, email, username FROM users WHERE username = ? AND passwordHash = ?";
    private Connection jdbcConnection;

    @Override
    public User select(String username, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        User loggedInUser = null;

        try {
            conn = getConnection();
            preparedStatement = conn.prepareStatement(SQL_SELECT);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            rs.next();
            if(rs != null){
                loggedInUser = new User(
                        rs.getInt("id"),
                        rs.getString("fName"),
                        rs.getString("lName"),
                        rs.getString("email"),
                        rs.getString("username")
                );
            }

        } catch (Exception exception){
            loggedInUser = new User(
                    0,
                    "Error: ",
                    exception.getMessage(),
                    "Error",
                    "Error"
            );
            System.out.println("Error: " + exception.getMessage());
        }
        return loggedInUser;
    }
}
