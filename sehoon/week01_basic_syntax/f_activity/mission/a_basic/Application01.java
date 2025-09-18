package com.ohgiraffers.f_activity.mission.a_basic;

import java.util.Scanner;

public class Application01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        // 1. Scanner를 이용해서 2번의 정수 입력받기
        System.out.println("첫 번째 정수 입력: ");
        int num1 = sc.nextInt();

        System.out.println("두 번째 정수 입력: ");
        int num2 = sc.nextInt();

        // 2. 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지 연산의 결과 값을 각 변수에 저장하기
        // 나눗셈 연산의 경우 정수, 실수 연산을 구분한다.
        // 모든 연산은 첫 번째 정수에서 두 번째 정수를 연산한다.
        // 예시 : num1 + num2

        int add = num1 + num2;
        int minus = num1 - num2;
        int multiple = num1 * num2;
        int intDivision = num1 / num2;
        double floatDivision = (double) num1 / num2;
        int remain = num1 % num2;

        // 각 연산의 결과를 명확하게 알아볼 수 있도록 형식에 맞춰서 출력한다
        System.out.println("[계산 결괴]");
        System.out.println("덧셈: " + add);
        System.out.println("뺄셈: " + minus);
        System.out.println("곱셈: " + multiple);
        System.out.println("정수 나눗셈: " + intDivision);
        System.out.println("실수 나눗셈: " + floatDivision);
        System.out.println("나머지: " + remain);


    }

}
