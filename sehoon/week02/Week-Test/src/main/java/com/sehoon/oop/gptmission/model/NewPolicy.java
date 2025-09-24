package com.sehoon.oop.gptmission.model;

public class NewPolicy implements DiscountPolicy {
    @Override
    public int calculateDiscount(Order order) {
        return order.price();
    }
}
