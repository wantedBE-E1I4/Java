package com.ohgiraffers.a_basic;

/*
* java의 기본 구조 및 실행방식
* 컴파일러(javac)를 사용하여 클래스를 기반으로 프로그램을 장성하는 객체 지향 프로그램밍 언어이다.
* 모든 JAVA 프로그램은 클래스 안에서 동작하ㅕㅁ, main 메서드가 실행 시작 시점이 된다.
*
* JAVA의 실행과정 :
* 1. java 소스 코드(.java 파일)을 작성한다.
* 2. 컴파일러(javac)를 사용하여 바이트코드(.class)로 변환한다
* 3. jvm이 .class파일을 생성한다
* 4. jvm은 바이트코드를 해석하여 os에서 실행 가능한 기계어로 변환한다.
* 5. 실행 결과를 출력하거나 다른 연산을 수행한다.
*
* java 실행 방식 이해하기
* java의 실행 방식은 "컴파일 + 인터프리터" 방식을 사용한다.
* 이는 java 코드가 먼저 바이트코드로 변환된 후 jvm에 의해 해석 실행되는 것을 의미한다.
*
* 주요 개념:
* - 컴파일(compile): .java -> .class 로 변환하기 위해 (javac 사용) jvm이 고급 언어를 이해하기 위함.
* - 바이트코드(Bytecode): jvm에서 실행 가능한 중간 코드
* - jvm(java virtual Machine) 바이트코드를 os에 맞는 기계어로 변환하여 실행.
* - jit(just-in-time) 컴파일러: 실행 중 바이트코드를 네이티브 코드로 변환하여 성능 향상
*
* jit
* add함수를 만들엇다. 더해서 리턴해준다.
* 컴파일러단계에서 별거없네 하고 if문에 넣어버린다. (성능 개선)
* */
public class Main {

    public static void main(String[] args) {
        System.out.println("hello world");
    }
}
