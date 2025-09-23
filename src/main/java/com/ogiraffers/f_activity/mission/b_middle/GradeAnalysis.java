package com.ogiraffers.f_activity.mission.b_middle;

public class GradeAnalysis {
    public static void main(String[] args) {
        // 1. 문자열을 입력받는다.
        String input = "국어:80,영어:75,수학:90,과학:65";

        // 2. 문자열을 과목별로 분리한다.
        String[] pairs = input.split(",");

        // 2-1. 필요한 변수 준비
        int total = 0;
        double average = 0.0;
        String[] subjectNames = new String[pairs.length];
        String[] grades = new String[pairs.length];

        // 3. 각 과목의 이름과 점수를 추출하여 총점, 등급 계산

        for (int i = 0; i < pairs.length; i++) {
            // 과목 이름, 점수 추출
            String[] parts = pairs[i].split(":");

            subjectNames[i] = parts[0];
            int score = Integer.parseInt(parts[1]);

            // 총점 누적
            total += score;

            // 등급 부여
            String grade = calculateGrade(score);
            grades[i] = grade;
        }

        // 4. 평균 계산
        average = (double) total / grades.length;

        // 5. 총점, 평균, 등급을 출력한다.
        System.out.println("[성적 분석 결과]");
        System.out.println("총점: " + total);
        System.out.println("평균: " + average);

        System.out.println("\n[과목별 등급]");
        for (int i = 0; i < pairs.length; i++) {
            System.out.println(subjectNames[i] + ": " + grades[i]);
        }
    }

    public static String calculateGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else {
            return "D";
        }
    }
}
