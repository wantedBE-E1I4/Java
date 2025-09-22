package com.ohgiraffers.f_activity.mission.b_middle;

import java.util.Scanner;

public class ScoreManager {
    public static void main(String[] args) {
        /**
         * 요구사항:
         *
         * "국어:80,영어:75,수학:90,과학:65"와 같이 쉼표로 구분된 과목과 점수 문자열을 입력받습니다.
         * split() 메서드를 사용하여 문자열을 과목별로 분리하고, 각 과목의 이름과 점수를 추출합니다.
         * 모든 과목의 총점과 평균 점수를 계산합니다.
         * 점수가 90점 이상이면 "A", 80점 이상이면 "B", 70점 이상이면 "C", 그 외에는 "D" 등급을 부여하고 과목별 등급을 출력합니다.
         * 최종적으로 계산된 총점, 평균, 그리고 각 과목의 등급을 형식에 맞춰 출력합니다.
         */
        System.out.println("과목과 성적:");
        Scanner sc = new Scanner(System.in);
        String sub = sc.nextLine(); //"국어:80,영어:75,수학:90,과학:65"

        // 1) 한줄짜리 ,로 분리
        String[] strArr = sub.split(","); //"국어:80"[0] "영어:75"[1]... //4

        //2) 국어:80을 :로 분리 -> [국어, 80]

        int[] scores = new int[strArr.length];
        String[] names = new String[strArr.length];
        int sum = 0;
        for (int i = 0; i < strArr.length; i++) {
            String[] kv = strArr[i].split(":", 2);
            names[i] = kv[0].trim(); //국어
            scores[i] = Integer.parseInt(kv[1].trim()); //80
            sum = sum + scores[i];
        }


        System.out.println("[성적 분석 결과]");
        double avg = (double) sum / strArr.length;
        System.out.println("총점: " + sum);
        System.out.println("평균: " + avg);

        System.out.println("[과목별 등급]");
        for (int i = 0; i < strArr.length; i++) {
            if (scores[i] >= 90) {
                System.out.println(names[i] + ": " + "A");
            } else if (scores[i] >= 80){
                System.out.println(names[i] + ": " + "B");
            } else if (scores[i] >= 70){
                System.out.println(names[i] + ": " + "C");
            } else {
                System.out.println(names[i] + ": " + "D");
            }
        }
    }
}
