package com.orgiraffers.oop.chap04.section01;

/**
 * 추상화
 * - 복잡한 세부사항을 숨기고, 중요한 기능만 드러내는 방법이다.
 * - "abstract" 클래스나 인터페이스로 구현
 * - 비유: 차 운전 시 엔진 구조를 몰라도 "가속" 버튼만 누르면 전진한다.
 *
 * 장점
 * - 코드 단순화: 불필요한 디테일 검증
 * - 유연성: 다른 차종 쉽게 추가 가능.
 *
 * 추상화를 하지 않을 경우
 * - 문제점:
 *  1) 코드 중복: 비슷한 기능 반복 작성
 *  2) 복잡성 증가: 모든 세부사항 직접 관리
 *  3) 유지보수 어려움: 차종마다 코드 수정 필요
 *  -예 : car마다 Accelerate()를 다르게 쓰면 통일성이 없어짐.
 */
public class Application {
    public static void main(String[] args) {
        /**
         * animal을 상속받는 모든 동물이 makeSound()라는 행위를 가져야 한다고 가정하면
         * 이를 구현할 수 있도록 강제화해야 하는데 이를 추상 메서드를 통해 구현할 수 있다.
         *
         * 추상화는 animal 클래스를 abstract(추상)클래스로 만들고 "makeSound()"를 "abstract" 메서드로 선언한다.
         * 추상 메서드: 몸통 (구현)은 없지만, 너희 자식들은 반드시 이 메서드를 구현해야 해! 라는 강력한 규칙 이자 책임을 부여한다.
         * 이제 animal을 상속받는 클래스는 makeSound()를 구현하지 않으면 컴파일 에러가 발생하여 실수를 원천 봉쇄할 수 있다.
         */
        Cat cat = new Cat("호떡이");
        Dog dog = new Dog("모카");

        dog.makeSound();
        cat.makeSound();
    }



}
