package com.ohgiraffers.f_activity.lesson;

public class SimpleCalculator {

    public static void main(String[] args) {
        // 사용자 입력
        String input = "10, 20, 30";

//        1. 입력 문자열에서 공백을 제거한다.
        String trimmedInput = input.replace(" ", "");
//        2. 쉼표(,)를 기준으로 문자열 배열을 생성한다.
        String[] parts = trimmedInput.split(",");
//        3. 배열의 인덱스 0, 1, 2의 값을 변수에 직접 할당하고 정수로 변환한다.
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);
        int num3 = Integer.parseInt(parts[2]);
//        4. 세 숫자의 합계를 계산하고, 평균을 구한다 (정수 나눗셈).
        int sum = num1 + num2 + num3;
        double avg = sum / 3;
        System.out.println("합계:" + sum +", 평균:" + avg);





    }
}
