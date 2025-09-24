package com.orgiraffers.oop.z_activity.mission.c_deep;

public class PaymentServiceV2 {
    public static void main(String[] args) {
        PaymentServiceV2 paymentService = new PaymentServiceV2();

        PaymentMethod[] methods = {new CreditCard(), new KakaoPay(), new NaverPay()};
        for (PaymentMethod method : methods) {
            paymentService.processPayment(method, 1000);
        }
    }

    public void processPayment(PaymentMethod paymentMethod, int amount) {
        paymentMethod.pay(amount);
    }
}
