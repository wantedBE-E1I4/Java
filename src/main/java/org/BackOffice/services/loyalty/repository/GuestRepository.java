package org.BackOffice.services.loyalty.repository;

import org.BackOffice.services.loyalty.domain.Guest;

import java.util.HashMap;
import java.util.Map;

public class GuestRepository {
    private final Map<Integer, Guest> guestMap = new HashMap<>();
    static int seq = 100;

    public Guest findById(int guestId) {
        return guestMap.get(guestId);
    }

    public void save(Guest guest) {
        guest.setId(++seq);
        guestMap.put(guest.getId(), guest);
    }
}
