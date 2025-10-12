package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.domain.LoyaltyAccount;
import org.BackOffice.services.loyalty.repository.LoyaltyRepository;

public class LoyaltyService {
    LoyaltyRepository loyaltyRepo;

    public LoyaltyService(LoyaltyRepository loyaltyRepo) {
        this.loyaltyRepo = loyaltyRepo;
    }

    public void accruePoints(int guestId, int totalPay) {
        LoyaltyAccount account = loyaltyRepo.getOrCreateForGuest(guestId);
        account.setBalance(totalPay);
        System.out.println("포인트 잔액은 "+account.getBalance());
    }
}
