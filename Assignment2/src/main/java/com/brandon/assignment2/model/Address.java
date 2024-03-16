package com.brandon.assignment2.model;

public class Address {
    private int addressId;
    private int userId;
    private String street;
    private String city;
    private String provinceState;
    private String postalCode;

    public Address(int addressId, int userId, String street, String city, String province_state, String postalCode) {
        this.addressId = addressId;
        this.userId = userId;
        this.street = street;
        this.city = city;
        this.provinceState = province_state;
        this.postalCode = postalCode;
    }

    public Address(){};

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
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
