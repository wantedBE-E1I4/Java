package com.orgiraffers.oop.z_activity.mission.c_deep;

public class PaymentServiceV1 {
    public static void main(String[] args) {
        PaymentServiceV1 paymentService = new PaymentServiceV1();

        CreditCard creditCard = new CreditCard();
        KakaoPay kakaoPay = new KakaoPay();
        NaverPay naverPay = new NaverPay();

        paymentService.processPayment(creditCard, 1000);
        paymentService.processPayment(kakaoPay, 1000);
        paymentService.processPayment(naverPay, 1000);
    }

    public void processPayment(PaymentMethod paymentMethod, int amount) {
        paymentMethod.pay(amount);
    }
    /**
     * Animal[] animals = {new Dog(), new Cat()};
     *
     *         //추상클래스를 타입으로 받고 있는데 왜 문제가 안생기지?
     *         //Animal 클래스는 makeSound() 몸체를 가진다.
     *         //heap메모리에 뭘 올리는거지?
     *
     *         for (Animal animal : animals) {
     *             animal.makeSound();
     *             if (animal instanceof Dog) {
     *                 ((Dog) animal).guard();
     *             } else if (animal instanceof Cat) {
     *
     *             }
     *         }
     */
}
