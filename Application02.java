package com.ohgiraffers.mission.b_middle;
//for 문 사용
public class Application02 {
    public static void main(String[] args) {
        String mission = "국어:80,영어:75,수학:90,과학:65";

        String[] subjects = mission.split(","); //  ("국어:80")("영어:75)(수학:90)(과학:65) 로 쪼개기

        int sum = 0; // 합계(총점:310)가 들어갈 집 미리 만들어놓기

        String[] answer = new String[subjects.length]; // (국어:B 영어:C 수학:A 과학:D 가 들어갈 집 만들어놓기)

        for (int i= 0; i < subjects.length; i++) {   // i가 'subjects의 길이보다 작다는 조건을 만족(4보다 작을때까지)'할때까지 1씩 증가
            String[] subScores = subjects[i].split(":"); //  : 을 기준으로 쪼개서 subScore라는 길이2(0,1)짜리 배열에 넣음 (0열에는 과목이, 1열에는 점수가 들어가게 됨)
            String subject = subScores[0]; // 'String subject' 에는 과목이 순서대로 들어감 (국어 영어 수학 과학)
            int score = Integer.parseInt(subScores[1]); // "int score' 에는 마찬가지로 점수가 순서대로 들어감 (80 75 90 65)

            // sum += score;
            sum = sum + score; // 위에서 만들어놓은 점수 총합의 집에 점수 총합을 집어넣음

            if (score >= 90) {
                answer[i] = subject + " : A";
            } else if (score >= 80) {
                answer[i] = subject + " : B";
            } else if (score >= 70) {
                answer[i] = subject + " : C";
            } else {
                answer[i] = subject + " : D";
            }
        }

        double avg = (double) sum / subjects.length; // 실수형 함수(평균은 77.5라 실수로 표현) 'double avg' 에 'sum(합계)'를 과목수만큼으로 나눠서 집어넣음
        System.out.println("총점 : " + sum); // 총점 : 310
        System.out.println("평균값 : " + avg); // 평균 : 77.5

        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]); // "과목 : 등급" 이 순서대로 출력됨
        }




    }
}
