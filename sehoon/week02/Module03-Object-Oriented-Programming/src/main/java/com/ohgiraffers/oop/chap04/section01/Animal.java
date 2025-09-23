package com.ohgiraffers.oop.chap04.section01;

/*
* 추상화
* - 복잡한 세부사항을 숨기고, 핵심 기능만 정의하는 방법이다.
*   쉽게 설명하면 인터페이스만 정의하고 나를 상속받는 너희들이 구현해라는 말이다.
*   이를 사용하면 세부 내용은 달라지고 동일한 이름으로 실행할 수 있다.
* - 비유 : 동물에게 "짖어"라고 하면 어떻게 낼지는 몰라도 소리가 나와.
* */
public abstract class Animal { // 추상 클래스

    public String name;

    public Animal(String name) {
        this.name = name;
    }

    /*
    *abstract 키워드
    * - 클래스나 메서드를 "추상적"으로 만듦
    * - abstract 클래스 : 객체를 직접 생성할 수 없으며, 자식 클래스에서 상속해야함.
    *   이를 상속받는 클래스에서는 반드시 불완전한 요소를 해결해야 한다.
    *   이러한 것을 "구현 책임의 원칙"이라고 한다.
    * - abstract 메서드는 몸체가 없으며, 자식 클래스에서 반드시 구현해야 한다.
    * */
    public abstract void makeSound(); // 추상 메서드
}
