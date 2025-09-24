package com.ohgiraffers.mission.a_basic;

public class EmailNotifier implements Notifier {
    @Override
    public void send() {
        System.out.println("[email 알림]: 이메일이 도착했습니다.");
    }
}
