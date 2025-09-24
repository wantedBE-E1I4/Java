package com.ohgiraffers.chap02.section01;

public class Application01 {
    public static void main(String[] args) {
        ObjectBox stringBox = new ObjectBox();
        stringBox.setItem("hello"); // String -> Object로 형변환됨

        String box = (String) stringBox.getItem(); // String은 Object가 아니다. //그래서 String으로 캐스팅해줌

        System.out.println(box);
        stringBox.setItem(1234);
        String box2 = (String) stringBox.getItem();
        System.out.println(box2);
    }
}
