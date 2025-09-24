package com.orgiraffers.oop.chap03.section02;

public class Dog extends Animal{
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(super.name + "가 멍멍 울음소리를 냅니다.");
    }


}
