package com.ohgiraffers.d_activity.misson.b_middle;

public class PrimeNumber {
    public static void main (String args[]) {
        PrimeNumber num = new PrimeNumber();
        int end_num = 100;
        num.isPrime(end_num);
    }
    private void isPrime(int num) {
        System.out.println("1부터 100까지의 소수: ");
        for (int i = 2; i < num-1; i++) {
            int cnt = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    cnt ++;
                }
            }
            if (cnt == 1) {
                System.out.print(i+" ");
            }
        }
    }
}
