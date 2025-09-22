package com.ohgiraffers.f_activity.mission.a_basic;

import java.math.BigDecimal;
import java.util.Scanner;

public class beginner {
    public static void main(String[] args) {
        // 0) 값 입력받기
        Scanner sc = new Scanner(System.in);
        System.out.print("첫 번째 정수 입력: ");
        int num1 = sc.nextInt();


        System.out.print("두 번째 정수 입력: ");
        int num2 = sc.nextInt();
        System.out.print("[계산결과]");
        System.out.println("덧셈: " + (num1+num2));
        System.out.println("뺄셈: " + (num1-num2));
        System.out.println("곱셈: " + (num1*num2));
        System.out.println("정수 나눗셈: " + (num1/num2));

        double real1 = (double) num1 / num2;
        System.out.printf("실수 나눗셈(소수점 3자리): %.3f%n", real1);
        System.out.println("나머지: " + (num1%num2));




    }
}
