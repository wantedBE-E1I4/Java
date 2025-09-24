package com.orgiraffers.oop.chap05.section02;

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("야옹");
    }

    public void catchMouse() {
        System.out.println("쥐를 잡자!!");
    }

    @Override
    public String toString() {
        return "고양이";
    }
}
