package com.orgiraffers.oop.chap01.basic;

public class Application {
    public static void main(String[] args) {
        String brand = "Tesla";
        String model1 = "Model s";
        int speed1 = 0;

        String brand2 = "BMW";
        String model2 = "i5";
        int speed2 = 0;

        System.out.println("brand = " + brand + "Model: " + model1 + "Speed: " + speed1);
        System.out.println("brand2 = " + brand2 + "Model2: " + model2 + "Speed2: " + speed2);

        /**
         * 문제점:
         * 1. 데이터가 흩어져 있다. : brand1, model1, speed1은 논리적으로 하나의 묶음이지만, 코드상으로 뿔뿔이 흩어져 있다.
         * 2. 관리의 어려움: 자동차가 100대가 되면, 100개의 브랜드, 100개의 모델, 100개의 속도 변수를 모두 따로 관리해야한다.
         * 3. 실수유발: car1, brand와 car2, speed를 사용하는 실수를 해도 문법적으로 오류가 없다.
         *
         */

        /**
         * 이름: 이상우
         * 나이: 20
         * 번호: 010-2122-2233
         */
        /**
         * 이름: 지민수
         * 나이: 28
         * 번호: 010-2122-2233
         */

        /**속성이 뒤섞일 수 있다.
         * 뭉쳐서 정의할 수 없을까?
         * 레퍼런스 자료형 (참조 자료형) 사용자 정의 자료형 (사용자가 필요할 때 정의하니까)
         */

        /**
         * new 연산자란
         * - new는 클래스라는 설계도를 바탕으로 실제 객체(인스턴스)를 메모리(힙 영역)에 만들어내는 명령어이다.
         * - new Car()는 car 설계도를 보고 실제 자동차를 한 대 생산해 라는 의미이다.
         *
         * myCar 변수(참조 변수)
         * - myCar는 방금 만들어진 car 객체가 메모리 어디에 있는지 주소(참조)를 저장하는 변수이다.
         * - 마치 자동차 열쇠 처럼 이 변수를 통해 실제 객체에 접근하고 조작할 수 있다.
         */

        // 타입 변수명 = 값;
        Car myCar; //변수 선언 - 데이터 타입 Car //메인 스택프레임에 myCar 생성됨
        // System.out.println(myCar); // 초기화 할당 받지 않앗으니 오류 //주소값이 없는 상태
        myCar = new Car(); // 초기화 //heap 메모리 공간에 올려준다. //주소값 있는 상태
        //heap -x001에 브랜드/모델/속도 달리다(), 감속() 올린다. myCar.브랜드 (=x001.브랜드)

        /**
         * 인스턴스 참조
         * - myCar는 Car 객체의 주소를 가지고 있으며 '.'(참조 연산자)는 이것을 참조한다라고 한다.
         * - myCar를 통해 객체의 속성(Brand, model, speed)나 기능(accelerate, brake)를 사용할 수 있다.
         */

        myCar.brand = "Tesla"; //x001로 가서 brand를 넣어줄게
        myCar.model = "Model s";
        myCar.speed = 0;
        myCar.accelerate();
        myCar.accelerate();
        myCar.brake();

        System.out.println("myCar의 현재 속도: " + myCar.speed);

    }
}
