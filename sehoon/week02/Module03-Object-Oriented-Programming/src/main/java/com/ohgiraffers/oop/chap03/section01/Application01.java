package com.ohgiraffers.oop.chap03.section01;

import com.ohgiraffers.oop.chap03.section01.inheritance.Car;
import com.ohgiraffers.oop.chap03.section01.inheritance.ElectricCar;

/*
 * 상속
 * - 상속은 객체 지향 프로그램의 핵심 개념 중 하나로, 기존 클래스(부모 클래스 또는 슈퍼 클래스)의 속성(필드)와 기능(메서드)를
 *   새로운 클래스(자식 클래스 또는 서브 클래스)가 물려받는 것을 의미한다.
 * - 자식 클래스는 부모 클래스의 모든 공개(public) 및 보호(protected) 필드와 메서드에 접근할 수 있다.
 * - 상속을 통해 코드의 재사용성을 높이고, 공통된 기능을 가진 여러 클래스를 쉽게 관리할 수 있다.
 * - "ElectricCar"클래스는 "Car" 클래스를 상속받아."car"클래스의 속성과 메서드를 공유하며,
 *   "BatteryLevel"이라는 새로운 속성과 "cargeBattery()"라는 새로운 메서드를 추가한다.
 * - 자식 클래스는 부모 클래스의 메서드를 오버라이드(override)할 수 있어, 기능을 변화시킬 수 있다.
 * */
public class Application01 {
    public static void main(String[] args) {


        /*
        * 문제점
        * 1. 동일한 코드 (필드 및 메서드)가 여러 클래스에 중복된다.
        * 2. 변경 사항이 생기면 모든 클래스에서 일일이 수정해야한다.
        * 3. 유지보수성이 낮아진다.
        * */

        Car car1 = new Car();
        car1.brand = "Honda";
        car1.speed = 10000;
        car1.model = "asdggg";
        car1.accelerate();

        ElectricCar electricCar1 = new ElectricCar();
        electricCar1.brand = "Tesla";
        electricCar1.speed = 10000;
        electricCar1.batteryLevel=0;
        electricCar1.model = "model s";


        electricCar1.accelerate();
        electricCar1.chargeBattery();

        /*
        * 상속을 적용.
        * 1. car 클래스는 부모 클래스로 만들오 "ElectricCar"에서 상속을 받는다.
        * - 이를 통해 Car가 가진 기능을 ElectricCat에서 사용할 수 있게 된다.
        * - 단 무보의 필드 혹은 메서드에 private로 추가된 속성은 자식이 사용할 수 없다.
        * 2. 상속을 통해 중복된 속성과 기능은 재정의가 필요 없저기제 되며, chargeBattery 기능만 추가하면 된다.
        * */
    }
}
