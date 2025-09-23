package com.ohgiraffers.oop.chap05.section01;

/*
* 다형성을 사용하지 않는 코드
*
* 문제점
* 1. 각 객체를 따로 생성해야 하므로 코드 중복 발생.
* 2. 유지보수가 어려움(새로운 동물이 추가될 때마다 코드 수정이 필요함)
*
* 다형성을 사용하지 않으면 생기는 문제
* 1) 코드 중복 : 각 동물마다 별도 변수와 호출 필요.
* 2) 유지보수 어려움: 새 동물 추가 시 코드 반복 수정.
* 3) 통합 관리 불가 : 동물들을 한꺼번에 다룰 방법이 없음.
* - 비유 동물원에서 개, 고양이를 따로 불러야 하면 번거롭다.
* */
public class Application {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.makeSound();
        cat.makeSound();
    }
}
