package com.orgiraffers.oop.chap03.section01.inheritance;

public class Car {
    public String brand;
    public int speed;
    public String model;

    public void accelerate() {
        speed += 10; //내가 가진 speed //나를 지칭
        System.out.println("brand: " + brand + "speed: " + speed);
    }
}
