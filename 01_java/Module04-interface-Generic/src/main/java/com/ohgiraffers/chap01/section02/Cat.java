package com.ohgiraffers.chap01.section02;

public class Cat extends Animal implements SoundMaker{
    @Override
    public void makeSound() {
        System.out.println("야옹!" + SoundMaker.DECIBEL + " 크기");
    }
}
