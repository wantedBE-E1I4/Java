package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.domain.Guest;
import org.BackOffice.services.loyalty.domain.LoyaltyAccount;
import org.BackOffice.services.loyalty.repository.GuestRepository;
import org.BackOffice.services.loyalty.repository.LoyaltyRepository;

public class LoyaltyService {
    GuestService guestService = new GuestService();

    public void accruePoints(LoyaltyRepository loyaltyRepository, int guestId, int totalPay) {
        LoyaltyAccount account = new LoyaltyAccount(guestId, totalPay);

        loyaltyRepository.save(account);
    }
}
