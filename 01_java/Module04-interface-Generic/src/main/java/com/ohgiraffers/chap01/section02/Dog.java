package com.ohgiraffers.chap01.section02;

public class Dog extends Animal implements SoundMaker{
    @Override
    public void makeSound() {
        System.out.println("멍멍" + SoundMaker.DECIBEL + " 크기");
    }
    //인터페이스는 무조건 구현해야한다. (abstract 내포)
}
