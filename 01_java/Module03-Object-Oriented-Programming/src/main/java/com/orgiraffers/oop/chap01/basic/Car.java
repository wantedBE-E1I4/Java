package com.orgiraffers.oop.chap01.basic;

/**
 * 클래스 및 객체의 개념
 * 클래스란?
 * - 객체를 생성하기 위한 설계도
 * - 속성(변수(필드))와 메서드(기능)을 포함한다.
 *
 * 객체란
 * - 단순한 데이터 덩어리(VO)가 아닌 스스로 상태(state)를 책임지는 행위(behavior)의 주체이다.
 * - 객체는 현실 세계의 사물을 모방하는 것이 아니라, 특정 "책임"을 수행하는 역할(Role)을 부여받은 존재이다.
 *
 * 좋은 객체 설계의 시작
 * - 이 객체가 어떤 데이터를 가지는가?가 아닌, 이 객체가 어떤 책임을 수행해야 하는가?를 먼저 질문해야한다.
 * - Car 객체의 책임은 이동하는 것이다. 따라서 외부에서 속도를 직접 제어하는 것이 아니라
 * - 가속해라, 감속해라 라는 메세지를 보내 책임을 수행할 수 있도록 요청해야 한다.
 *
 * 문법 구조
 * class 클래스 이름 {
 *     // 필드(속성)
 *     // 메서드(기능)
 * }
 */
public class Car {
    // 접근제어자 자료형 변수명; //접근제어자 없으면 default
    public String brand;
    public String model;
    public int speed;
    private boolean status;


    // 접근 제어자 / 클래스명() //만드는 방법 안내(생성자)
    public Car() {
        //기본 생성자
    }

    //Car 생성 단계부터 규칙: 항상 모델명을 넘겨준다.
    public Car(String model) {
        this.model = model;
    }

    public void accelerate() {
        if (speed > 0) {
            this.status = true;
        }
        speed+= 10;
        System.out.println("brand: " + brand + ", Model: " + model + ", Speed: " + speed);
    }

    public void brake() {
        speed -= 10;
        if (speed <= 0) this.status = false;
        System.out.println("brand: " + brand + ", Model: " + model + ", Speed: " + speed);
    }
}
