package com.ohgiraffers.oop.chap03.section01.deep;

public class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        this.engine.start();
        this.engine.increaseSpeed();
        System.out.println("차가 달립니다.");
    }

}
