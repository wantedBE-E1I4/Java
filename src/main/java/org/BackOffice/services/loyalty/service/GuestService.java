package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.domain.Guest;

/**
 * ID를 발급하고 게스트를 생성
 */
public class GuestService {
    public int createGuest() {
        Guest guest = new Guest();
        return guest.getId();
    }
}
