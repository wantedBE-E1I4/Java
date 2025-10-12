package org.BackOffice.services.loyalty.service;

import org.BackOffice.services.loyalty.domain.Guest;
import org.BackOffice.services.loyalty.repository.GuestRepository;

import java.util.Scanner;

/**
 * ID를 발급하고 게스트를 생성
 */
public class GuestService {
    private final GuestRepository guestRepo;
    public GuestService(GuestRepository guestRepo) {
        this.guestRepo = guestRepo;
    }

    public Long createGuest() {
        Guest guest = new Guest();
        guestRepo.create(guest);
        return guest.getId();
    }

    public Guest findGuest(Long guestId) {
        return guestRepo.findById(guestId);
    }

    /*public Long selectExistingGuest() {
        //TODO 기존 손님이 없을 경우
        guestRepo.listGuestIds();
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }*/

    /**
     * 게스트에게 진행중인 주문을 할당
     * @param guestId
     * @param orderId
     */
    public void assignOpenOrderToGuest(Long guestId, Long orderId) {
        Guest guest = findGuest(guestId);
        guest.setOpenOrderId(orderId);
        guestRepo.update(guest);
    }
}



