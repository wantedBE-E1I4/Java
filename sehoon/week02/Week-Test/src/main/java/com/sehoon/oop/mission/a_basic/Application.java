package com.sehoon.oop.mission.a_basic;

import com.sehoon.oop.mission.a_basic.model.EmailNotifier;
import com.sehoon.oop.mission.a_basic.model.KakaoNotifier;
import com.sehoon.oop.mission.a_basic.model.Notifier;
import com.sehoon.oop.mission.a_basic.model.SmsNotifier;

public class Application {
    public static void main(String[] args) {
        Notifier[] notifiers = {new SmsNotifier(), new EmailNotifier(), new KakaoNotifier()};

        for (Notifier notifier : notifiers) {
            notifier.send("삐용삐용 알림이 왔어요");
        }
    }
}
