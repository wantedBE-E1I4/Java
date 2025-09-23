package com.ohgiraffers.oop.chap02.selftest;

public class CapsuleTest {

    private int posValue;
    private boolean status;

    // 생성자 만들기
    private CapsuleTest(int value) {
        this.posValue = value;
    }

    // 팩토리 패턴 사용
    public static CapsuleTest createCapsule (int posValue) {
        if (posValue < 0 ) {
            return null;
        } else {
            return new CapsuleTest(posValue);
        }
    }

    // get posValue
    public int getValue() {
        return posValue;
    }

}
