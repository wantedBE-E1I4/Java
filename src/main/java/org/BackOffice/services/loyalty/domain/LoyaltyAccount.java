package org.BackOffice.services.loyalty.domain;

public class LoyaltyAccount {
    private Long guestId;
    private int balance = 0;

    public LoyaltyAccount(Long guestId) {
        this.guestId = guestId;
    }

    public Long getGuestId() {
        return guestId;
    }

    public int getBalance() {
        return balance;
    }

    /**
     * 포인트 누적
     * @param totalPay
     */
    public void accruePoints(int totalPay) {
        this.balance += (int) (totalPay * 0.10);
    }

    //TODO 잔액보다 많이 빼지 않도록(언더플로 방지).
    /**
     * 포인트 차감
     * @param points
     */
    public void redeemPoints(int points) {
        this.balance -= points;
    }
}


