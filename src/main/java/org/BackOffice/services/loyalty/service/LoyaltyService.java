package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.domain.LoyaltyAccount;
import org.BackOffice.services.loyalty.repository.LoyaltyRepository;

public class LoyaltyService {
    LoyaltyRepository loyaltyRepo;

    public LoyaltyService(LoyaltyRepository loyaltyRepo) {
        this.loyaltyRepo = loyaltyRepo;
    }

    public void accruePoints(Long guestId, int totalPay) {
        LoyaltyAccount account = loyaltyRepo.getOrCreateForGuest(guestId);
        account.accruePoints(totalPay);
        loyaltyRepo.save(account);
    }

    public LoyaltyAccount findById(Long guestId) {
        return loyaltyRepo.findById(guestId);
    }

    public void redeemPoints(Long guestId, int points) {
        LoyaltyAccount account = findById(guestId);
        account.redeemPoints(points);
        loyaltyRepo.save(account);
    }

    /**
     * 현재 포인트 잔액 반환
     * @param guestId
     * @return
     */
    public int getPointsBalance(Long guestId) {
        LoyaltyAccount account = findById(guestId);
        return account.getBalance();
    }
}
