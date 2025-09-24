package com.orgiraffers.oop.chap03.section01.inheritance;

/**
 * 상속
 * - electricCar가 car를 상속 받으면 car의 모든 필드와 메서드를 물려받아 재사용할 수 있다.
 * - 이는 객체지향에서 "electricCar"는 car의 한 종류이다. 라는 (is-a)라고 표현한다.
 * - 이를 통해 코드 중복을 제거하고, 역할을 더욱 전문화할 수 있다.
 */
public class ElectricCar extends Car{
    public int batteryLevel;

    //컴파일러가 자동으로 추가해준다.
    public ElectricCar() {
        super(); //부모를 먼저 생성해서 메모리 공간을 확보한다.
    }
    public void chargeBattery(){
        batteryLevel = 100;
        System.out.println("브랜드 명" + super.brand + "batteryLevel: " + batteryLevel);
    }
}
