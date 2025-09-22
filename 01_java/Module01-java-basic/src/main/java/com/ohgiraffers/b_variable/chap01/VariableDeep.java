package com.ohgiraffers.b_variable.chap01;

public class VariableDeep {
    //함수는 자신만의 공간을 갖는다. 실행될 때 실행될 수 있는 환경 보장받음 (stack) 함수 시작 stack 생성 후 종료 시 소멸
    //stack내 자료형 저장하는 공간있음
    //main만의 스택

    public void test() {

    }
    public static void main(String[] args) {
        /**
         * Primitive Type(기본형)과 Reference Type(참조형)
         *
         * Primitive Type(기본형)
         * 기본형 데이터는 값 자체가 스택 영역에 저장된다.
         * 변수는 메서드 실행 동안만 메모리에 존재하며, 메서드가 종료되면 자동으로 제거된다.
         * 기본형 데이터는 메모리 사용이 효율적이고 접근 속도가 빠르다.
         * 예를 들어 int number=10; 을 선언하면  number라는 변수 이름과 값이 10이 스택에 바로 기록된다.
         * 이는 메모리 사용이 효율적이고, 변수의 생명 주기가 메서드 실행 범위 내로 제한되기 때문이다.
         * GC(Garbage Collection)의 관리 대상이 되지 않는다.
         */

        int num = 100;
        double dNum = 10.5;
        boolean isOk = true;

        /**
         Reference Type(참조형):
         참조형 데이터(String, 배열, 객체)는 메모리 주소를 스택 영역에 저장하고,
         살제 데이터는 힙 영역에 저장된다.
         참조형 데이터는 메서드가 종료되어도 참조하는 객체가 남아 있을 수 있으며,
         GC(Garbage Collector)가 필요하지 않은 객체를 제거한다.
         예를 들어, String text = "hello";를 선언하면 스택에느 text라는 변수와 힙 내에 "hello" 객체의 주소가 저장되고,
         힙에는 "hello"라는 문자열 객체가 생성된다. 이 방식은 객체를 재사용하거나 공유할 수 있게 해주며,
         힙에 저장된 데이터는 GC에 의해 필요 없어질 때 정리된다.
         */

        //메서드가 실행되면 Call Stack : 가장 먼저들어온게 가장 먼저 나감 LIFO
        //메인이 가장먼저 생김

        //name에 heap의 주소를 입력해준다.

        //String은 import 생략 가능
        //String pool의 역할
        /***
         * String pool의 역할
         * String은 참조형이지만, java는 문자열 리터럴(예: "hello")을 힙 내 String Pool(또는 String constant pool)이라는 특수 영역에 저장한다.
         * 이는 동일한 문자열을 재사용해 메모리를 절약하기 위한 최적화이다.
         * 예를 들어, String text1 = "hello"와 String text2 = "hello"와 같은 String pool 내의 "Hello"객체를 참조한다.
         * (text1 == text2)는 같다.
         *
         * 반면, new String("hello")처럼 명시적으로 객체를 생성하면 String pool 밖에 별도의 힙 객체가 만드어져 메모리가 중복 사용된다.
         * (text1 == text3)은 같지 않다. String pool은 jvm 메모리 효율성을 높이고, 문자열 비교(==로 참조 비교시) 성능을 개선한다.
         * 단 String pool에 저장된 문자열은 불변이므로 값 수정 시 새로운 객체가 생성된다.(바꿀 수 없고 새로 만들게된다.)
         */

        String text1 = "hello"; //x001
        String text2 = "hello"; //x001
        String text3 = new String("hello"); //x002
        System.out.println("text1 == text2 " + text1 == text2); //false //이것도 new String("text1 == text2 )한거맞지?
        System.out.println("text1 == text2 " + (text1 == text2)); //true
        System.out.println("text1 == text3 " + text1 == text3);

        /**
         * GC는 게임 프로그래밍에서 적합하지 않다. 중간중간 멈추기 때문
         *
         */


    }
}
