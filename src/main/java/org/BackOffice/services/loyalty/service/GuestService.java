package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.MembershipCouponMenu;
import org.BackOffice.services.loyalty.domain.Guest;
import org.BackOffice.services.loyalty.repository.GuestRepository;

/**
 * ID를 발급하고 게스트를 생성
 */
public class GuestService {
    public int createGuest(GuestRepository guestRepository) {
        Guest guest = new Guest();
        guestRepository.save(guest);
        return guest.getId();
    }

    public Guest findGuest(GuestRepository guestRepository, int guestId) {
        return guestRepository.findById(guestId);
    }
}
