package org.BackOffice.services.loyalty.domain;

public class LoyaltyAccount {
    private int guestId;
    private int balance = 0;

    public LoyaltyAccount(int guestId) {
        this.guestId = guestId;
    }

    public int getGuestId() {
        return guestId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int totalPay) {
        this.balance += (int) (totalPay * 0.10);
    }
}


