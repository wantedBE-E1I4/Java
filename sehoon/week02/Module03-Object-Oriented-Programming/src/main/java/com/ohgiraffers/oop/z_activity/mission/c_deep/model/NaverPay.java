package com.ohgiraffers.oop.z_activity.mission.c_deep.model;

public class NaverPay extends PaymentMethod{
    @Override
    public void pay(int amount) {
        System.out.println("네이버 페이로 " + amount + "원 결제 완료.");
    }
}
