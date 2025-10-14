package org.BackOffice.services.loyalty.repository;

import org.BackOffice.services.loyalty.domain.LoyaltyAccount;

import java.util.HashMap;
import java.util.Map;

public class LoyaltyRepository {
    private final Map<Long, LoyaltyAccount> loyaltyMap = new HashMap<>();

    public LoyaltyAccount findById(Long guestId) {
        return loyaltyMap.get(guestId);
    }

    public void save(LoyaltyAccount account) {
        loyaltyMap.put(account.getGuestId(), account);
    }

    public LoyaltyAccount getOrCreateForGuest(Long guestId) {
        LoyaltyAccount account = findById(guestId);
        if (account != null) {
            return account;
        }
        LoyaltyAccount newAccount = new LoyaltyAccount(guestId);
        save(newAccount);
        return newAccount;
    }
}
