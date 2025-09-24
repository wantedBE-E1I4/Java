package com.ohgiraffers.mission.a_basic;

public class KakaoNotifier implements Notifier {
    @Override
    public void send() {
        System.out.println("[Kakao 알림]: 카카오톡이 도착했습니다.");
    }
}
