package com.orgiraffers.oop.z_activity.mission.a_basic;

public class BankAccount {
    private String accountNumber;
    private Long balance;

    public BankAccount(String accountNumber, Long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // 잔액조회
    public Long getBalance() {
        return balance;
    }

    // 입금
    public void deposit(long amount) {
        balance += amount;
    }

    //출금
    public void withdraw(long amount) {
        if (balance < amount) {
            System.out.println("잔액이 부족합니다.");
        } else {
            balance -= amount;
        }
    }
}
