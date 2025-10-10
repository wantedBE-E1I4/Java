package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.repository.GuestRepository;
import org.BackOffice.services.loyalty.repository.LoyaltyRepository;
import org.BackOffice.services.loyalty.repository.OrderRepository;

public class ServiceFactory {
    AppContext ctx = new AppContext();
    ServiceFactory factory = new ServiceFactory(
            ctx.guestRepo, ctx.orderRepo, ctx.loyaltyRepo);

    public ServiceFactory(GuestRepository guestRepo, OrderRepository orderRepo, LoyaltyRepository loyaltyRepo) {
        factory.createGuestService(guestRepo);
        factory.createOrderService(orderRepo);
        factory.createLoyaltyService(loyaltyRepo);
    }

    public void createGuestService(GuestRepository guestRepo) {
        GuestService guestService = new GuestService(guestRepo);
    }

    public void createOrderService(OrderRepository orderRepo) {
        OrderService orderService = new OrderService(orderRepo);
    }

    public void createLoyaltyService(LoyaltyRepository loyaltyRepo) {
        LoyaltyService loyaltyService = new LoyaltyService(loyaltyRepo);
    }
}
