package org.BackOffice.services.loyalty.domain;

public enum OrderStatus {
    OPEN("진행중"),
    PAID("결제완료");

    private String displayName;

    OrderStatus(String displayName) {
        this.displayName = displayName;
    }
}
