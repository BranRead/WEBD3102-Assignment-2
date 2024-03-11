package com.brandon.assignment2.model;

public class Address {
    private int id;
    private int userId;
    private String street;
    private String city;
    private String provinceState;
    private String postalCode;

    public Address(int id, int userId, String street, String city, String province_state, String postalCode) {
        this.id = id;
        this.userId = userId;
        this.street = street;
        this.city = city;
        this.provinceState = province_state;
        this.postalCode = postalCode;
    }

    public Address(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceState() {
        return provinceState;
    }

    public void setProvinceState(String provinceState) {
        this.provinceState = provinceState;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
