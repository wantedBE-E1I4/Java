package com.orgiraffers.oop.chap02.deep;

public class CapsuleDeep {
    private double payment;

    private CapsuleDeep(double payment) {
        this.payment = payment;
    }

    /**
     * 팩토리 패턴(Factory pattern)
     * 객체 생성 로직을 클라이언트 코드와 분리하여 객체 생성 과정을 캡슐화하는 디자인 패턴이다.
     * 클라이언트는 직접 객체를 생성하는 대신 팩토리 메서드를 호출하여 객체를 얻는다.
     * 팩토리 메서드는 입력 값에 따라 객체 생성 여부를 결정할 수 있으며, 조건에 맞지 않는 경우 null을 반환할 수 있다.
     * 이를 통해 코드의 유연성과 재사용성을 높이고 객체 생성 방식을 쉽게 변경할 수 있다.
     */
    public static CapsuleDeep createCapsule(double payment) {
        if (payment == 0) {
            System.out.println("손님 제품 가져다 놓으세요");
            return null;
        } else {
            System.out.println("그렇게 할까요?");
            return new CapsuleDeep(payment);
        }
    }
    //heap에 올라가지 않음. jvm의 스택에 존재함
    //이 클래스와 생명주기가 다르다.

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public String selling() {
        return payment + "원 입니다.";
    }


}
