package com.ohgiraffers.mission.a_basic;

public class SmsNotifier implements Notifier {
    @Override
    public void send() {
        System.out.println("[sms 알림]: 문자 메시지가 도착했습니다.");
    }
}
