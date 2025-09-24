package com.orgiraffers.oop.chap04.section01;

import com.orgiraffers.oop.chap04.section01.Animal;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    @Override
    public void makeSound() {
        System.out.println(this.name + "가 웁니다. 야옹");
    }

}
