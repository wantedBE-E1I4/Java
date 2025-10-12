package org.BackOffice.services.loyalty.repository;

import org.BackOffice.services.loyalty.domain.LoyaltyAccount;

import java.util.HashMap;
import java.util.Map;

public class LoyaltyRepository {
    private final Map<Integer, LoyaltyAccount> loyaltyMap = new HashMap<>();

    public LoyaltyAccount findById(int guestId) {
        return loyaltyMap.get(guestId);
    }

    public void save(LoyaltyAccount account) {
        loyaltyMap.put(account.getGuestId(), account);
    }

    public LoyaltyAccount getOrCreateForGuest(int guestId) {
        LoyaltyAccount account = findById(guestId);
        if (account != null) {
            return account;
        }
        LoyaltyAccount newAccount = new LoyaltyAccount(guestId);
        save(newAccount);
        return newAccount;
    }
}
