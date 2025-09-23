package org.week1;

import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //

        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i+1) + "번째 학생의 점수 입력");
            scores[i] = sc.nextInt();
        }
        System.out.println("\n--- 학생 등급 결과 ---");
        int score=0;
        char grade =0;
        for(int i=0;i<n;i++){
            //using [switch] instead of [if]
            switch(score/10){
                case 10:
                case 9 : {
                    System.out.println("A");
                    break;
                }
                case 8: {
                    System.out.println("B");
                    break;
                }
                case 7 : {
                    System.out.println("C");
                    break;

                }
                default : {
                    System.out.println("D");
                }
            }
            System.out.println((i + 1) + "번째 학생의 등급: " + grade);
        }

        System.out.println("종료");
        sc.close();

    }
}
