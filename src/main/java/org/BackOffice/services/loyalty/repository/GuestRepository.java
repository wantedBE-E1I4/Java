package org.BackOffice.services.loyalty.repository;

import org.BackOffice.services.loyalty.domain.Guest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GuestRepository {
    private Map<Integer, Guest> guestMap = new HashMap<>();
    int seq = 0;

    public Guest findById(int id) {
        Collection<Guest> values = guestMap.values();
        for (Guest value : values) {
            if (id == value.getId()) {
                return value;
            }
        }
        return null;
    }
    //Repository가 id 생성 책임을 갖게 한다.
    public void save(Guest guest) {
        //id 발급
        guest.setId(++seq);
        guestMap.put(guest.getId(), guest);
    }
}
