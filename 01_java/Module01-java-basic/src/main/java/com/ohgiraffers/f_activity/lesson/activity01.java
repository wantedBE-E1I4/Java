package com.ohgiraffers.f_activity.lesson;

public class activity01 {
    public static void main(String[] args) {
        /**
         * * <개발 순서>
         *  * 1. 입력 문자열의 공백 제거.
         *  * 2. `split()` 메서드를 사용하여 쉼표로 분할한 배열을 생성.
         *  * 3. 배열 인덱스 0, 1, 2의 요소를 각각 변수에 할당 후 정수형으로 변환.
         *  * 4. 변수들을 이용해 합계와 평균을 계산.
         *  * 5. 결과 문자열을 생성하여 반환.
         */
        // 0) 사용자 입력
        String input = "10, 20, 30";
        // 1) 문자열 공백 제거
        String trimmedInput = input.replace(" ", "");

        // 2) 나눈다.
        String[] parts = trimmedInput.split(","); //0: "10", 1:"20", 2:"30"

        // 3) 배열 인덱스 0,1,2의 요소를 각각 변수에 할당 후 정수형으로 변환
        int num1 = Integer.parseInt(parts[0]);
        int num2 = Integer.parseInt(parts[1]);
        int num3 = Integer.parseInt(parts[2]);

        // 4) 합계
        int sum = num1+num2+num3;
        // 5) 평균
        //double avg = sum / parts.length; //반복문이 아니니까 적합하진 않다.
        double avg = sum / 3;

        System.out.println("합계: " + sum + "평균:" + avg);
    }
}
