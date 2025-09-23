package com.ohgiraffers.oop.z_activity.mission.a_basic;

import com.ohgiraffers.oop.z_activity.mission.a_basic.model.BankAccount;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("새로 생성할 계좌번호를 입력해주세요.");
        String account = sc.nextLine();

        // 계좌 생성
        BankAccount newAccount = BankAccount.createBankAccount(account,0);
        System.out.println("계좌가 생성되었습니다.");

        boolean flag = true;
        while (flag) {
            System.out.println("1. 돈 입금하기 | 2. 돈 출금하기 | 3. 종료하기");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("입금하실 금액을 입력해주세요.");
                long balance = sc.nextLong();
                newAccount.deposit(balance);
                System.out.println("이전 단계로 이동합니다.");
                System.out.println();
            } else if (choice == 2) {
                System.out.println("출금하실 금액을 입력해주세요.");
                long balance = sc.nextLong();
                newAccount.withdraw(balance);
                System.out.println("이전 단계로 이동합니다.");
                System.out.println();
            } else if (choice == 3) {
                flag = false;
                System.out.println("시스템을 종료합니다.");
                System.out.println();
            } else {
                System.out.println("선택에 없는 번호 입니다. 다른 번호를 선택해주세요.");
                System.out.println();
            }
        }

    }
}
