package com.orgiraffers.oop.z_activity.mission.a_basic;

public class Application01 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("110-222-444", 0L);
        account.deposit(500);
        account.withdraw(300);

        System.out.println("잔액:" + account.getBalance());
    }
}
