package com.ohgiraffers.oop.chap05.section02;

/*
* 다형성이란 ?
* - 부모 클래스 타입으로 여러 자식 객체를 다룰 수 있을 것을 의미한다.
*   즉, 부모(클래스, 인터페이스)를 상속받는 모든 자식 클래스는 부모의 타입이 할 수 있다는 것이다.
* - 상속과 메서드 오버라이딩을 통해 구현된다.
* - 비유 : 동물원에서 '동물들이 ,소리 내라!'라고 한 번 부르면 개는 '멍멍', 고양이는 '야옹'으로 각자 반응하는 것.
*
* 다형성의 필요성
* - 코드의 중복을 줄이고, 유지보수를 쉽게 하며, 다양한 객체를 우연한게 다룰 수 있도록 해준다.
* */

import java.util.ArrayList;
import java.util.List;

/*
* 다형성을 사용하지 않으면 생기는 문제
* 1. 코드 중복
*   - 각 동물 타입마다 별도 변수와 메서드 호출을 작성한다.
*   - 예 Dog dog = new Dog(); Cat cat = new Cat(); 처럼 각각 선언하고 호출하면 코드가 길어진다.
*   - 결괴 : 비슷한 로직이 반복되며 비효율적이다.
*
* 2. 유지보수의 어려움
*   - 새 동물(bird)가 추가될 때마다 새로운 변수와 호출 코드를 추가해야한다.
*   - 예 Bird bird = new Bird(); bird.makeSound(); 를 또 써야한다.
*   - 결과 코드가 늘어날수록 수정과 관리가 힘들어진다.
*
* 3. 유연성 부족
*   - 동물들을 한꺼번에 묶어서 다룰 방법이 없어진다.
*   - 예 : 모든 동물 소리 내라와 같은 통합 명령이 불가은.
*   - 결과 : 프로그램이 확장되면 점점 더 복잡해지고 제약이 많아진다.
*
* 다형성으로 해결하는 방법
* - 부모 타임(animal)을 사용해 모든 자식 객체를 통합관리
* - 동작 과정 :
*   - Animal 타입 배열에 dog, Cat 등 자식 객체를 넣음
*   - 오버라이딩된 makeSound()가 각 객체에 맞게 실행됨
* - 장점 :
*   - 1) 중복 제거 : 한 번의 반복문으로 모든 동물 호출
*   - 2) 유지보수 쉬움 : 새 동물 추가시 배열에 넣기만 하면 됨.
*   - 3) 유연성 : 부모 타입으로 다양한 동작 처리 가능.
* */
public class Application {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat()};

        for (Animal animal : animals) {
            animal.makeSound();

            if (animal instanceof Dog) {
                ((Dog) animal).guard();
            } else if (animal instanceof Cat) {
                ((Cat) animal).catchMouse();
            }

        }

//        ((Dog) animals[0]).guard(); // 회원관리 할 때 많이 쓴다.
//        ((Cat) animals[0]).catchMouse();

        Dog dog = new Dog();
        Cat cat = new Cat();
        FakeAnimal fakeAnimal = new FakeAnimal();

        List animalList = List.of(dog, cat, fakeAnimal);

        int cnt = animalList.size();
        for (int i =0; i < cnt; i++) {
            if (animalList.get(i) instanceof Animal) {
                System.out.println(animalList.get(i) + "는 동물원 입장이 가능합니다.");
            } else {
                System.out.println(animalList.get(i) + "는 동물이 아니네요.");
            }
        }

    }
}
