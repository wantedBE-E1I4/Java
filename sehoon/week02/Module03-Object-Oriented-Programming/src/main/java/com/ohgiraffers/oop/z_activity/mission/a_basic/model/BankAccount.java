package com.ohgiraffers.oop.z_activity.mission.a_basic.model;

public class BankAccount {
    private String accountNumber;
    private long balance;

    // 팩토리 패턴 적용하기
    private BankAccount(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // 계좌를 생성할 때, 금액을 같이 넣을 수 있다고 가정한다.
    public static BankAccount createBankAccount(String account, long cash) {
        if (account == null) {
            System.out.println("계좌번호를 입력해주세요.");
            return null;
        } else if (cash < 0) {
            System.out.println("0원 이하는 입금할 수 없습니다.");
            return null;
        }

        return new BankAccount(account, cash);
    }

    // 입금 메서드
    public void deposit(long cash) {
        if (cash < 1) {
            System.out.println("1원 이상 입금해주세요.");
            return;
        }
        this.balance += cash;
        System.out.println("입금 후 잔액 : " + this.balance);
    }
    // 출금 메서드
    public void withdraw(long cash) {
        if (cash < 1) {
            System.out.println("1원 이상 출금해주세요.");
            return;
        }else if (cash > balance) {
            System.out.println("잔액이 부족합니다.");
            return;
        }

        this.balance -= cash;
        System.out.println("출금 후 잔액 : " + this.balance);
    }
    // 잔액조회 메서드
    public long getBalance() {
        return this.balance;
//        System.out.println("남은 잔액 : " + this.balance);
    }
}
