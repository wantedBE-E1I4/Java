package com.ohgiraffers.oop.chap02.capsule;


/*
* 캡슐화를 적용한 코드
*
* 1. 필드를 private로 선언하여 외부 접근 차단.
* 2. getter와 setter 메서드를 통해 안전하게 데이터 조작
* 3. setter에서 데이터 무결성 검증 추가.
* */
public class Product {
    private double payment;
    private boolean status;

    // 생성자
    public Product(double payment) {
        if (payment == 0) {
            System.out.println("손님 0원짜리 제품이 어디에 있어요.");
            return;
        } else if(payment < 0) {
            System.out.println("손님 팔고 돈도 주면 누가 장사해요.");
            return;
        } else {
            System.out.println("손님 남는 것은 없는데 그렇게 할까요 ?");
            this.payment = payment;
        }
    }

    // 특정 필드를 초기화 하기 위한것
    // payment가 외부에서 가격결정권을 가지면 안되기 때문이다.
    // 내가 정의한 조건으로 가격을 초기화 하겠어.
    public void initPrice(double payment) {
        if (payment == 0) {
            System.out.println("손님 0원짜리 제품이 어디에 있어요.");
        } else if(payment < 0) {
            System.out.println("손님 팔고 돈도 주면 누가 장사해요.");
        } else {
            System.out.println("손님 남는 것은 없는데 그렇게 할까요 ?");
            this.status = false;
            this.payment = payment;
        }
    }

    public String selling() {
        if (!status) {
            return "재고가 없습니다. ";
        } else {
            return payment + "원 입니다.";
        }

    }
}
