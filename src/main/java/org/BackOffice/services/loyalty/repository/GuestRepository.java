package org.BackOffice.services.loyalty.repository;

import org.BackOffice.services.loyalty.domain.Guest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GuestRepository {
    private final Map<Integer, Guest> guestMap = new HashMap<>();
    static int seq = 100;

    public Guest findById(int guestId) {
        return guestMap.get(guestId);
    }

    /**
     * ID 할당+저장
     * @param guest
     */
    public void create(Guest guest) {
        guest.setId(++seq);
        guestMap.put(guest.getId(), guest);
    }

    /**
     * 상태변경+저장
     * @param guest
     */
    public void update(Guest guest) {
        guestMap.put(guest.getId(), guest);
    }

    public void listGuestIds() {
        Collection<Guest> values = guestMap.values();
        for (Guest value : values) {
            System.out.println(value.getId() + "번 손님"); //어딘가에서 save를 탄듯
        }
    }
}
