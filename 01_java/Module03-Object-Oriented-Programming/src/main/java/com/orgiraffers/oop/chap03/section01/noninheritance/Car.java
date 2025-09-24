package com.orgiraffers.oop.chap03.section01.noninheritance;

public class Car {
    public String brand;
    public int speed;
    public String model;

    public void accelerate() {
        speed += 50;
        System.out.println("brand: " + brand + ", speed: " + speed);
    }

}
