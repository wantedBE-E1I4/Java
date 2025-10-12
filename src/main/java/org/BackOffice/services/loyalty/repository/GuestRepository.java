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
     * <br>-시퀀스 증가로 ID 부여 후 저장
     * @param guest
     */
    public void create(Guest guest) {
        guest.setId(++seq);
        guestMap.put(guest.getId(), guest);
    }

    /**
     * 상태변경+저장
     * <br>-기존 ID 유지한 채 상태만 갱신
     * @param guest
     */
    public void update(Guest guest) {
        guestMap.put(guest.getId(), guest);
    }

    public void listGuestIds() {
        Collection<Guest> values = guestMap.values();
        for (Guest value : values) {
            System.out.println(value.getId() + "번 손님");
        }
    }
}
