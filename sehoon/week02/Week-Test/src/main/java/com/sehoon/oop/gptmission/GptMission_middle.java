package com.sehoon.oop.gptmission;

import com.sehoon.oop.gptmission.model.*;
import com.sehoon.oop.gptmission.service.DiscountService;
import com.sehoon.oop.gptmission.service.UserType;

import java.util.Map;

/*
미션

1. DiscountPolicy 인터페이스 설계
2. NewPolicy, VipPolicy, EmployeePolicy 구현
3. Map<UserType, DiscountPolicy>로 룩업 (분기 제거)
4. 새 타입 추가 시 switch 수정 없이 동작할 것
* */

public class GptMission_middle {
    public static void main(String[] args) {
        Map<UserType, DiscountPolicy> map = Map.of(
                UserType.NEW, new NewPolicy(),
                UserType.VIP, new VipPolicy(),
                UserType.EMPLOYEE, new EmployeePolicy()
        );

        DiscountService discountService = new DiscountService(map);
        Order order = new Order("VIP", 5000);
        System.out.println(discountService.calc(order));

    }
}
