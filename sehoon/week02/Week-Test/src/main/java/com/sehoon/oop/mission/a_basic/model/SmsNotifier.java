package com.sehoon.oop.mission.a_basic.model;

public class SmsNotifier implements Notifier{
    @Override
    public void send(String message) {
        System.out.println("[SMS 알림]: " + message);
    }
}
