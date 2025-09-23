package com.ohgiraffers.oop.chap02;

/*
* 캡슐화는 왜 필요할까 ? - 객체의 자율성과 책임
 * 💡 이전 단계의 의문점:
 * - `chap01`의 Car 클래스는 필드(brand, speed)가 `public`으로 열려있어 외부에서 마음대로 값을 바꿀 수 있었다.
 * (예: `myCar.speed = -100;`) 이는 현실 세계의 자동차에서는 불가능한, 위험한 상태이다.
 * - 객체가 자신의 상태를 스스로 제어하지 못하면, 데이터가 오염되고 시스템 전체의 신뢰도가 무너진다.
 *
 * 캡슐화의 진정한 의미 : 내 데이터는 내가 책임진다.
 * - 단순히 데이터를 "Private"로 감추는 행위가 아니다.
 * - 객체가 자시늬 상태를 스스로 관리할 '책임'을 갖고, 외부에 대해서는 약속된 행위(메서드)만큼 공개함으로써
 *   객체의 '자율성'을 보장하는 것이 핵심이다.
 *
 * 💡 좋은 객체 설계의 시작
 * - '이 객체가 어떤 데이터를 가지는가?'가 아닌, '이 객체가 어떤 책임을 수행해야 하는가?'를 먼저 질문해야 한다.
 * - Product 객체의 책임은 '가격을 결정하고 판매하는 것'이다. 외부에서 가격(payment)을 직접 제어하는 것이 아니라,
 *  '가격을 설정해라(setPayment)'라는 메시지를 보내 책임을 수행하도록 요청해야한다.
 * - 이 요청을 받은 Product 객체는 스스로 가격이 유효한지(0보다 큰지) 판단할 '자율권'을 가진다.
* */

import com.ohgiraffers.oop.chap01.basic.Car;
import com.ohgiraffers.oop.chap02.deep.CapsuleDeep;
import com.ohgiraffers.oop.chap02.noncapsule.Product;

/*
* 접근 제어자
* - 클래스, 변수, 메서드의 접근 범위 설정하는 키워드이다.
* - public : 모든 클래스에서 접근이 가능하다
* - protected : 같은 패키지 내의 클래스와 상속받은 클래스에서 접근이 가능하다.
* - private : 캍은 클래스 내에서만 접근이 가능하다
* - default(아무 접근제어자도 명시하지 않음) : 같은 패키지 내에서만 접근이 가능하다.
* */
public class Application {

    public static void main(String[] args) {
        Product nonProduct = new Product();
        nonProduct.payment = -1000;
        String result = nonProduct.selling();
        System.out.println(result);

        // 현재 문제점은 가격 설정이 외부에 있다는 것이다.
        System.out.println("=== 캡슐화 적용 ===");

//        com.ohgiraffers.oop.chap02.capsule.Product product1 = new com.ohgiraffers.oop.chap02.capsule.Product();
//        product1.setPayment(100);
//        String result1 = product1.selling();
//
//        System.out.println(result1);

        com.ohgiraffers.oop.chap02.capsule.Product product2 = new com.ohgiraffers.oop.chap02.capsule.Product(0.0);
        String result2 = product2.selling();
        System.out.println(result2);


        System.out.println("=== 정적 팩토리 메서드 적용 ===");
        CapsuleDeep capsuleDeep = CapsuleDeep.createCapsuleDeep(100);
        capsuleDeep.selling();
        System.out.println(capsuleDeep);

    }

}
