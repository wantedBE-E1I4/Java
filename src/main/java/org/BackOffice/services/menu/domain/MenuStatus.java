package org.BackOffice.services.menu.domain;

public enum MenuStatus {
    SELLING(1),
    SOLDOUT(2),
    NEW(3),
    DELETE(4);

    public final int statusValue;
    MenuStatus(int statusValue) {
        this.statusValue = statusValue;
    }
}
