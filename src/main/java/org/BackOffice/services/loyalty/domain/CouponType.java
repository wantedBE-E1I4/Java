package org.BackOffice.services.loyalty.domain;

public enum CouponType {
    NEXT_ORDER_FREE_DRINK(1, "재주문시 1잔 무료 쿠폰"),
    PERCENT_10_OFF(2, "10% 할인");

    private final int id;
    private final String displayName;

    CouponType(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }
}
