package com.ohgiraffers.mission.c_deep;

public class Application {
    public static void main(String[] args) {

        int[][] MagicSquare = {
                {8, 1, 6},
                {3, 5, 7},
                {4, 9, 2}
        };
        //  int rowSum = (MagicSquare[0] + MagicSquare[1] + MagicSqare[2]) [
        //     int colSum =  MagicSquare[0][0] + MagicSquare[1][0] + MagicSqare[2][0]
        //    int diaSum =  MagicSquare[0][0] + MagicSquare[1][1] + MagicSqare[2][2]
        int rowSum1 = 0;
        for(int i = 0; i < MagicSquare.length; i++){
            rowSum1 += MagicSquare[0][i];                // 각 행의 합 첫번째 기준의 합
        }
        //각 열의 합
        int colSum = 0;
        int rowSum2 = 0;
        for(int i = 0; i < MagicSquare.length; i++) {
            int rowSum = 0;


            for (int j = 0; j < MagicSquare.length; j++) {
                rowSum2 += MagicSquare[i][j];
                colSum += MagicSquare[j][i];
            }


            int diasum = 0;
            int revSum = 0;
            for (i = 0; i < MagicSquare.length; i++) {
                diasum += MagicSquare[i][i];
                     //각 대각선의 합          0,0 1,1 2,2
                revSum += MagicSquare[i][2 - i];        //  0,2 1,1 2,0                                                     0,2 1,1 2,0
            }
            if (rowSum1 == rowSum2 && rowSum1 == colSum && rowSum1 == diasum && revSum == rowSum1) {
                System.out.println("[마방진 판별 결과]");
                System.out.println("마방진 입니다.");
            } else {
                System.out.println("[마방진 판별 결과]");
                System.out.println("마방진이 아닙니다.");
                return;
            }
            //

        }
}
}

