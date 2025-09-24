package com.orgiraffers.oop.z_activity.mission.c_deep;

public class NaverPay extends PaymentMethod {
    @Override
    public void pay(int amount) {
        System.out.println("네이버페이 " + amount + "원 결제 완료");
    }
}
