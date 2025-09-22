package com.ohgiraffers.f_activity.mission.c_deep;

public class MagicSquare {
    public static void main(String[] args) {
        int[][] twoArr = {
                {8,1,6},
                {3,5,7},
                {4,9,2}
        };
        //모든 합 값 배열
        int[] sumArr = new int[(twoArr.length*2)+2];

        int row_sum = 0;
        //행 덧셈
        for (int i = 0; i < twoArr.length; i++) {
            row_sum = 0;
            for (int j = 0; j < twoArr.length; j++) {
                row_sum += twoArr[i][j]; //8+1+6
            }
            sumArr[i] = row_sum;
        }

        //열 덧셈
        for (int i = 0; i < twoArr.length; i++) {
            int col_sum = 0;
            for (int j = 0; j < twoArr.length; j++) {
                col_sum += twoArr[j][i]; //8+1+6
            }
            sumArr[i+3] = col_sum;
        }

        //대각선 덧셈
        int dan_sum = 0;
        int reverse_dan_sum = 0;

        for (int idx = 0; idx < twoArr.length; idx++) {
            dan_sum += twoArr[idx][idx];
            reverse_dan_sum += twoArr[2-idx][2-idx];
        }
        sumArr[6] = dan_sum;
        sumArr[7] = reverse_dan_sum;

        boolean flag = false;

        for (int a : sumArr) {
            if (a == row_sum) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("마방진 입니다.");
        } else {
            System.out.println("마방진이 아닙니다.");
        }
    }
}
