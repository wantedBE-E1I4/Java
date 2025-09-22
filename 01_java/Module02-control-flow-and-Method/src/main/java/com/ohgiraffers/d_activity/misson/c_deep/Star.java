package com.ohgiraffers.d_activity.misson.c_deep;

import java.util.Scanner;

public class Star {
    public static void main(String[] args) {
        Star star = new Star();

        System.out.println("높이 입력: ");
        Scanner sc = new Scanner(System.in);
        star.printPyramid(sc.nextInt());
    }
    public void printPyramid(int height) {
        for(int i = 1; i <= height; i++) {
            //공백
            for (int j = 0; j < height - i; j++) {
                System.out.print(" ");
            }
            //별
            for (int k = 0; k < 2 * i -1; k++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
