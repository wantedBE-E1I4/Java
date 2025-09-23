package com.ohgiraffers.oop.chap01.basic;

public class Application {
    public static void main(String[] args) {
        String brand = "Tesla";
        String model1 = "Model s";
        int speed1 = 0;

        String brand2 = "BMW";
        String model2 = "i5";
        int speed2 = 0;

        System.out.println("Brand : " + brand + ", Model: " + model1 + ", Speed: " + speed1);
        System.out.println("Brand : " + brand2 + ", Model: " + model2 + ", Speed: " + speed2);

        /*
        * 문제점 :
        * 1. 데이터가 흩어져있다. : brand1, model1, speed1은 논리적으로 하나의 묶음이지만, 코드상으로 뿔뿔이 흩어져있다.
        * 2. 관리의 어려움 : 자동차가 100대가 되면, 100대의 브랜드, 100개의 모델, 100개의 속도 변수를 모두 따로 관리해야한다.
        * 3. 실수 유발 : car1, brand와 car2 speed를 사용하는 실수를 해도 문법적으로 오류가 없다.
        * */



        /*
        * new 연산자란
        * - new는 클래스라는 설계도를 바탕으로 실제 객체(인스턴스)를 메모리(힙 영역)에 만들어내는 명령어이다.
        * - new Car()는 'car 설계도를 보고 실체 자동차를 한 대 생산해' 라는 의미이다.
        *
        * myCar변수 (참조변수)
        * - Mycar는 방금 만들어진 car 객체가 메모리 어디에 있는지 주소(참조)를 저장하는 변수이다.
        * - 마치 자동차 열쇠처럼 이 변수를 통해 실제 객체에 접근하고 조작할 수 있다.
        * */
        // 타입 변수명 = 값;
        Car myCar; // 변수 선언
        myCar = new Car(); //초기화



        /*
        * 인스턴스 참조
        * - myCar는 Car 객체의 주소를 가지고 있므며 '.'(참조 연산자)는 이것을 참조한다라고 한다.
        * - myCar를 통해 객체의 속성(Brand, model, speed)나 기능(accelerate, brake)를 사용할 수 있다.
        * */

        myCar.brand = "Tesla";
        myCar.model = "Model s";
        myCar.speed = 0;
        myCar.accelerate();
        myCar.accelerate();
        myCar.brake();

        System.out.println("myCar의 현재 속도 : " + myCar.speed);
    }
}
