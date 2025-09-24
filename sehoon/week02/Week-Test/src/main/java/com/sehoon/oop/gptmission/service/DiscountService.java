package com.sehoon.oop.gptmission.service;

import com.sehoon.oop.gptmission.model.DiscountPolicy;
import com.sehoon.oop.gptmission.model.Order;

import java.util.Map;

public class DiscountService {
    private final Map<UserType, DiscountPolicy> policies;

    public DiscountService(Map<UserType, DiscountPolicy> policies) {
        this.policies = policies;
    }

    public int calc(Order o) {
        DiscountPolicy policy = policies.get(UserType.valueOf(o.type()));
        if (policy == null) {
            throw new IllegalArgumentException("No policy for type " + o.type());
        }
        return policy.calculateDiscount(o);
    }

}
