package com.orgiraffers.oop.chap04.section01;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(this.name + "가 웁니다 멍멍");
    }
}
