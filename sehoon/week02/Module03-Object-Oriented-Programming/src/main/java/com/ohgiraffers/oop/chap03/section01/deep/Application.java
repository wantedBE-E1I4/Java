package com.ohgiraffers.oop.chap03.section01.deep;


/*
* 컴포지션 패턴 이해하기
* 상속 대신 객체를 포함해서 기능을 사용하는 방법이다.
* - has-a 관계 : 클래스 안에 다른 객체를 넣음
* - 비유 : 차에 엔진을 '물려받는'대신 '장착'하는 것
*
* 예 :
* - Car가 Engine을 포함하면, Car는 Engine의 기능을 사용할 수 있음.
* - 장점 : 유연성이 높고, 강한 결합 (상속)을 피할 수 있음.
*
* 컴포지션의 장점
* - 느슨한 결합 : 포함된 객체(engine)를 쉽게 교체할 수 있음.
* - 재사용성 : engine을 다른 car에서도 사용 가능
* - 성능 : 불필요한 부모 필드 없이 필요한 것만 포함
* */
public class Application {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Car car = new Car(engine);
        car.drive();
    }
}
