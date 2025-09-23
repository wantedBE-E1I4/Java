package com.ohgiraffers.oop.z_activity.mission.c_deep;

import com.ohgiraffers.oop.z_activity.mission.c_deep.model.CreditCard;
import com.ohgiraffers.oop.z_activity.mission.c_deep.model.KakaoPay;
import com.ohgiraffers.oop.z_activity.mission.c_deep.model.NaverPay;
import com.ohgiraffers.oop.z_activity.mission.c_deep.model.PaymentMethod;
import com.ohgiraffers.oop.z_activity.mission.c_deep.service.PaymentService;

public class Application {
    public static void main(String[] args) {

        // 여러 결재 방식 정의
        PaymentMethod[] paymentMethod = {new CreditCard(), new KakaoPay(), new NaverPay()};

        // 결재 서비스 정의
        PaymentService service = new PaymentService();
        for (PaymentMethod method : paymentMethod) {
            service.processPayment(method, 10000);
        }
    }
}
