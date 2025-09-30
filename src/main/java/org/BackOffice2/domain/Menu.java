package org.BackOffice2.domain;

/**
 * enum 이란
 * 만약 문자열(String)로 "아메리카노"를 사용하면, 누군가 "아메리카노." 나 "Americano"로 잘못 입력할 수 있습니다.
 * enum을 쓰면 Menu.AMERICANO, Menu.LATTE 처럼 정해진 값만 사용하도록 강제할 수 있어 실수가 줄어듭니다.
 */
public enum Menu{
    AMERICANO(2000),
    LATTE(3000),
    MOCHA(3500);

    public final int price;
    Menu(int price) { this.price = price; }
}
