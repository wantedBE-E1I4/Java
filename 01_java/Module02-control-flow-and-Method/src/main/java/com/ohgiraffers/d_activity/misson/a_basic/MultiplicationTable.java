package com.ohgiraffers.d_activity.misson.a_basic;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("2부터 9까지 정수 입력: ");
        int inputNum = sc.nextInt();

        if (!(inputNum < 2 || inputNum > 9)) {
            MultiplicationTable mul = new MultiplicationTable();
            mul.printGugudan(inputNum);
        }
        System.out.println("2와 9사이의 정수를 입력해주세요");
    }
    private void printGugudan(int num) {
        int result = 0;
        for (int i = 1; i <= 9; i++) {
            result = num * i;
            System.out.println(num + "*" + i + "=" + result);
        }
    }
}
