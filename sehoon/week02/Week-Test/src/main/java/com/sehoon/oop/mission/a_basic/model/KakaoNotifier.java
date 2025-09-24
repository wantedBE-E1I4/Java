package com.sehoon.oop.mission.a_basic.model;

public class KakaoNotifier implements Notifier {

    @Override
    public void send(String message) {
        System.out.println("[카카오톡 알림]: " + message);
    }
}
