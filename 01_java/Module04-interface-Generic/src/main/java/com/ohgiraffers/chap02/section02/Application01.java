package com.ohgiraffers.chap02.section02;

/**
 * 제네릭스란
 * - 클래스나 메서드에 사용할 타입을 나중에 지정할 수 있도록 해주는 기능이다.
 * - 타입 파라미터(T)를 사용해서 객체를 만들 때 타입을 정한다.
 * - 비유: 상자(box)를 만들 때, 안에 넣을 물건(타입)을 나중에 정하는 것이다.
 *
 * 제네릭스가 필요한 이유
 * - 제네릭스 없이 상자를 만들면 모든 물건(object)를 넣을 수 있지만
 * - 꺼낼 때 형변환이 필요하다. > 실수하면 런타임 오류
 * - 예: Object box에 String을 넣고 꺼낼 때 integer로 형변환하면 오류
 * - 제네릭스는 타입을 미리 정해서 이런 실수를 컴파일 시점에 잡아준다.
 *
 * 장점
 * - 초급: 잘못된 물건 못넣게 해서 실수를 줄임
 * - 중급: 형변환을 하지 않고 사용할 수 있어서 좋음
 * - 고급: 타입 안정성 확보로 런타임 오류 방지
 */
public class Application01 {
    public static void main(String[] args) {
        System.out.println("=== 제네릭 상자 ===");
        GenericBox<String> stringBox = new GenericBox<>();//String으로 알아서 제네릭<> 채워짐 //제네릭박스에 있는 코드를 메모리에 올림
        stringBox.setItem("hello");
        String result = stringBox.getItem();
        System.out.println(result);

        stringBox.setItem(String.valueOf(12321));

        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.setItem(123);
        int result2 = integerBox.getItem();
        System.out.println(result2);
    }
}
