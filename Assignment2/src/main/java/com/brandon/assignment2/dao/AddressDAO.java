package com.brandon.assignment2.dao;

import com.brandon.assignment2.model.Address;

import java.sql.SQLException;
import java.util.List;

public interface AddressDAO {
    public List<Address> select(int userId) throws SQLException;
    public void add(Address address) throws SQLException;
}
