package com.ohgiraffers.f_activity.mission.b_middle;

import java.util.Scanner;

public class Application01 {
    public static void main(String[] args) {

        // 1. Scanner를 이용하여 과목과 점수 문자열을 입력받는다.
        Scanner sc = new Scanner(System.in);
        System.out.println("'과목1:점수1,과목2:점수2' 형태로 과목별 점수를 입력해주세요.");
        String input = sc.nextLine();

        // 2. trim()을 사용하여 불필요한 띄어쓰기를 제거한다.
        String trimmedInput = input.trim();

        // 3. split()을 이용하여 각 과목을 분리한 배열을 만든다
        String[] splitedInput = trimmedInput.split(",");

        // 4. 과목과 점수를 기록할 배열 2개를 정의한다.
        String[] kinds = new String[splitedInput.length];
        int[] grades = new int[splitedInput.length];

        // 5. 총점과 평균을 기록할 변수를 int로 정의한다.
        int sumValue = 0;
        double avgValue;

        // 6. for문을 통해 각 과목과 점수를 위에서 정의한 배열에 넣어준다
        // 추가적으로 점수를 총점에 더해준다.
        for (int i = 0; i < splitedInput.length; i++) {
            String unit = splitedInput[i];
            String[] splitKindAndGrade = unit.split(":");
            String kind = splitKindAndGrade[0];
            int grade = Integer.parseInt(splitKindAndGrade[1]);

            kinds[i] = kind;
            grades[i] = grade;

            sumValue += grade;
        }

        // 평균 계산
        avgValue = (double) sumValue / splitedInput.length;

        // 6. 총점과 과목을 형식에 맞게 출력한다.
        System.out.println("[성적 분석 결과]");
        System.out.println("총점: " + sumValue);
        System.out.println("평균: " + avgValue);
        System.out.println();

        System.out.println("[과목별 등급]");
        for (int i = 0; i < kinds.length; i++) {
            String kind = kinds[i];
            int grade = grades[i];
            char gradeString = '\0';

            if (grade > 89) {
                gradeString = 'A';
            } else if (grade > 79) {
                gradeString = 'B';
            } else if (grade > 69) {
                gradeString = 'C';
            } else {
                gradeString = 'D';
            }

            System.out.println(kind + ": " + gradeString);
        }

    }
}
