package org.BackOffice.services.loyalty.domain;

public class Guest {
    private Integer id;
    private Integer openOrderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOpenOrderId(Integer openOrderId) {
        this.openOrderId = openOrderId;
    }

    public Integer getOpenOrderId() {
        return openOrderId;
    }

    public boolean isOpenOrderId() {
        return true;
    }
}
