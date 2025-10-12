package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.repository.GuestRepository;
import org.BackOffice.services.loyalty.repository.LoyaltyRepository;
import org.BackOffice.services.loyalty.repository.OrderRepository;

/**
 * Repository 생성 (인스턴스 재사용)
 */
public class AppContext {
    GuestRepository guestRepo = new GuestRepository();
    OrderRepository orderRepo = new OrderRepository();
    LoyaltyRepository loyaltyRepo = new LoyaltyRepository();

    public GuestRepository getGuestRepo() {
        return guestRepo;
    }

    public OrderRepository getOrderRepo() {
        return orderRepo;
    }

    public LoyaltyRepository getLoyaltyRepo() {
        return loyaltyRepo;
    }
}
