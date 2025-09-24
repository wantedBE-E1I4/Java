package com.sehoon.oop.gptmission.model;

public class Order {
    private String userType;
    private int value;

    public Order(String userType, int price) {
        this.userType = userType;
        this.value = price;
    }

    public String type() {
        return this.userType;
    }

    public int price() {
        return this.value;
    }

}
