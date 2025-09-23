package com.ohgiraffers.oop.chap05.section02;

public class Dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("멍멍");
    }

    public void guard() {
        System.out.println("집을 지킨다.");
    }

    @Override
    public String toString() {
        return "강아지";
    }
}
