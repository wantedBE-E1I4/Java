package com.ohgiraffers.f_activity.mission.c_deep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application01 {
    /*
    *
    * 1. 3x3배열의 주어진 2차원 배열 값을 선언하고 초기화한다.
    * 2.
    * */
    public static void main(String[] args) {

        // 1.
        int[][] magicSquare = {
            {8,1,6},
            {3,5,7},
            {4,9,2}
        };

        // 정사각형이라 가정
        int n = magicSquare.length;
        int m = magicSquare[0].length;

        Set<Integer> set = new HashSet<>();

        // O(N^2)
        int oneDialog = 0;
        int reverseDialog = 0;
        for (int i = 0; i < n; i++) {
            int rowSum = Arrays.stream(magicSquare[i]).sum();
            int colSum = 0;

            for (int j = 0; j < n; j++) {
                colSum += magicSquare[j][i];
            }

            set.add(rowSum);
            set.add(colSum);

            // reverse Dialog
            oneDialog += magicSquare[i][i];
            reverseDialog += magicSquare[i][(n-1)-i];
        }
        set.add(oneDialog);
        set.add(reverseDialog);

        System.out.println("[마방진 판별 결과]");
        if (set.size() == 1) {
            System.out.println("마방진입니다.");
        } else {
            System.out.println("마방진이 아닙니다.");
        }



    }
}
