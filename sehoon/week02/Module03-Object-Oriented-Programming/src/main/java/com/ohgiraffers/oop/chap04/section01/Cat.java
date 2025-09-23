package com.ohgiraffers.oop.chap04.section01;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(this.name + "가 웁니다. 야옹");
    }
}
