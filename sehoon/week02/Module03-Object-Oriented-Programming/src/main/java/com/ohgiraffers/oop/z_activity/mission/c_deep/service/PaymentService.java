package com.ohgiraffers.oop.z_activity.mission.c_deep.service;

import com.ohgiraffers.oop.z_activity.mission.c_deep.model.PaymentMethod;

public class PaymentService {
    public void processPayment(PaymentMethod paymentMethod, int amount) {
        paymentMethod.pay(amount);
    }
}
