package com.ohgiraffers.mission.a_basic;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        //1. scanner를사용자의 입력을 받는다
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 정수 입력 : ");
        int cal1 = sc.nextInt();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("두 번째 정수 입력 :");
        int cal2 = sc.nextInt();

        // 2. 입력받은 덧셈, 뺄셈, 곱셈, 나눗셈, 나머지 연산 결과를 계산
        int sum = cal1 + cal2;
        System.out.println("덧셈:" + sum);
        int minus = cal1 - cal2;
        System.out.println("뺄셈:" + minus);
        int times = cal1 * cal2;
        System.out.println("곱셈:" + times);



        //3. 나눗셈은 실수결과 모두 출력
        //정수 나눗셈
        int divide = cal1 / cal2;
        System.out.println("정수 나눗셈:" + divide);
        // 실수 나눗셈
        float divide1 = (float) cal1 / cal2;
        System.out.println("실수 나눗셈:"+divide1);
        int divide2 = cal1%cal2;
        System.out.println("나머지:"+divide2);



        //4. 결과를 명확하게 형식에 맞춰 출력
    }
}
