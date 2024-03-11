package com.brandon.assignment2.dao;

import com.brandon.assignment2.model.User;

import java.sql.SQLException;

public interface LoginDAO {
    public User select(String username, String password) throws SQLException;
}
