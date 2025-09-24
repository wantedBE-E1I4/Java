package com.ohgiraffers.chap01.section03.model;

public class FixedDevice extends Device{

    public FixedDevice(String model) {
        super(model);
    }

    @Override
    public void powerOn() {
        System.out.println("Powering on 고정형" + super.getModel());
    }

    @Override
    public void powerOff() {
        System.out.println("Powering off 고정형" + super.getModel());
    }
}
