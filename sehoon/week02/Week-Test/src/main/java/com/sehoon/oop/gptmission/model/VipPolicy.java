package com.sehoon.oop.gptmission.model;

public class VipPolicy implements DiscountPolicy {
    @Override
    public int calculateDiscount(Order order) {
        return order.price() - 1000;
    }
}
