package com.ohgiraffers.chap01.section03.model;

/**
 * 노트북: 휴대용 기기 + 충전
 */
public class Laptop extends PortableDevice implements Rechargeable{
    public Laptop(String model) {
        super(model);
    }//model이 PortableDevice -> Device로 전파됨

    @Override
    public void recharge() {
        System.out.println(super.getModel() + "디바이스 충전 중");
    }
}
