package org.BackOffice.services.loyalty.repository;

import org.BackOffice.services.loyalty.domain.Guest;
import org.BackOffice.services.loyalty.domain.LoyaltyAccount;

import java.util.HashMap;
import java.util.Map;

public class LoyaltyRepository {
    private final Map<Integer, LoyaltyAccount> loyaltyMap = new HashMap<>();

    public LoyaltyAccount findById(int guestId) {
        return loyaltyMap.get(guestId);
    }

    public void save(Guest guest, LoyaltyAccount account) {
        loyaltyMap.put(guest.getId(), account);
    }
}
