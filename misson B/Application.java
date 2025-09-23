package com.ohgiraffers.mission.b_middle;

//for문을 사용하지 않고, 노가다로 구현

public class Application {


    public static void main(String[] args) {


       // 1.쉼표로 구분된 과목과 점수 문자열을 사용자에게 입력 받아야한다.

        String input = "국어:80, 영어:75, 수학:90, 과학:65"; //사용자 입력
        // 1. 입력 문자열의 공백 제거.
        String test = input.replace(" ","");
        //2. `split()` 메서드를 사용하여 쉼표로 분할한 배열을 생성.
        String[] subject = test.split(","); //{0 국어:80  영어:75  수학:90  과학:65}


        String korea = subject[0].split(":")[0]; // (0:국어 1:80)
        String english = subject[1].split(":")[0]; //(0:영어 1:75)
        String math = subject[2].split(":")[0];     //(0:수학 1:90)
        String science = subject[3].split(":")[0];  //(0:과학 1:65)


        //2. `split()` 메서드를 사용하여 쉼표로 분할한 배열을 생성.
        String koreasc =  subject[0].split(":")[1];
        String englishsc = subject[1].split(":")[1];
        String mathsc = subject[2].split(":")[1];
        String sciencesc = subject[3].split(":")[1];

        int koreasc1 = Integer.parseInt(koreasc); // 정수형으로 바꿈 "80" -> 80
        int english1 = Integer.parseInt(englishsc);
        int math1 = Integer.parseInt(mathsc);
        int sciencesc1 = Integer.parseInt(sciencesc);
        int total = koreasc1 +english1 +math1 +sciencesc1;
        double avg = (double) total / subject.length;

        System.out.println(koreasc1);
        System.out.println("[성적 분석 결과]");
        System.out.println("총점 :" + total );
        System.out.println("평균 :" + avg);


        System.out.println("[과목별 등급]");
        if(koreasc1 >= 90){
            System.out.println(korea +":A");
        }else if(koreasc1 >= 80){
            System.out.println(korea +":B");
        }else if(koreasc1 >= 70){
            System.out.println(korea +":C");
        }else{
            System.out.println(korea +":D");
        }

        if(english1 >= 90){
            System.out.println(english +":A");
        }else if(english1 >= 80){
            System.out.println(english +":B");
        }else if(english1 >= 70){
            System.out.println(english +":C");
        }else{
            System.out.println(english +":D");


        }if(math1 >= 90){
            System.out.println(math +":A");
        }else if(math1 >= 80){
            System.out.println(math +":B");
        }else if(math1 >= 70){
            System.out.println(math +":C");
        }else{
            System.out.println(math +":D");


        }if(sciencesc1 >= 90){
            System.out.println(science +":A");
        }else if(sciencesc1 >= 80){
            System.out.println(science +":B");
        }else if(sciencesc1 >= 70){
            System.out.println(science +":C");
        }else{
            System.out.println(science +":D");
        }


        //점수가 90점 이상이면 A 80점 이상이면 B 70점이상이면 C 그외에는 D 과목별 등급 출력
         /// 8


        //배열 인덱스 0, 1, 2의 요소를 각각 변수에 할당 후 정수형으로 변환.
        //String[][] subsco

        //String langsco = lang.split(":")[0];
        //String englishsco = english.split(":")[1];
        //String mathsco = math.split(":")[2];
        //String sciencesco = science.split(":")[3];


        //System.out.println(langsco);
        //System.out.println(englishsco);
        //System.out.println(mathsco);
        //System.out.println(sciencesco);






        //2. `split()` 메서드를 사용하여 쉼표로 분할한 배열을 생성.



        // 배열 인덱스 0, 1, 2의 요소를 각각 변수에 할당 후 정수형으로 변환.

        // 변수들을 이용해 합계와 평균을 계산.
        //{국어:80, 영어:75, 수학:90, 과학:60}
        // - 2.split 메서드를 사용, 문자열을 과목별로 분리,
        // 각 과목의 이름과 점수를 추출














       // - 3.모든 과목의 총점과 평균점수 계산
               // - 4.점수가 90점 이상이면 A 80점 이상이면 B 70점이상이면 C 그외에는 D 과목별 등급 출력
               // - 최종적으로 계산된 총점, 평균, 그리고 각 과목의 등급을 출력

    }
}
