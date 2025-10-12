package org.BackOffice.services.loyalty.domain;

public class Guest {
    private Long id;
    private Long openOrderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOpenOrderId(Long openOrderId) {
        this.openOrderId = openOrderId;
    }

    public Long getOpenOrderId() {
        return openOrderId;
    }

    public boolean isOpenOrderId() {
        return true;
    }
}
