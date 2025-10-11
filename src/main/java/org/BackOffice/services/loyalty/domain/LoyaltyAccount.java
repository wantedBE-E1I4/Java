package org.BackOffice.services.loyalty.domain;

public class LoyaltyAccount {
    private int guestId;
    private int balance;

    public LoyaltyAccount(int guestId, int pay) {
        this.guestId = guestId;
        balance += cal(pay);
    }

    public int getGuestId() {
        return guestId;
    }

    private int cal (int pay) {
        return (int) (pay * 0.10);
    }
}


