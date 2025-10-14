package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.repository.GuestRepository;
import org.BackOffice.services.loyalty.repository.LoyaltyRepository;
import org.BackOffice.services.loyalty.repository.OrderRepository;

/**
 * 무상태 Service 생성 전용
 */
public class ServiceFactory {

    public GuestService createGuestService(GuestRepository guestRepo) {
        return new GuestService(guestRepo);
    }

    public OrderService createOrderService(OrderRepository orderRepo) {
        return new OrderService(orderRepo);
    }

    public LoyaltyService createLoyaltyService(LoyaltyRepository loyaltyRepo) {
        return new LoyaltyService(loyaltyRepo);
    }
}
