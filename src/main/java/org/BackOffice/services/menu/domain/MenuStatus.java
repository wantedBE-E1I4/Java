package org.BackOffice.services.menu.domain;

public enum MenuStatus {
    판매중(1),
    품절(2),
    신규(3),
    삭제(4);

    public final int statusValue;
    MenuStatus(int statusValue) {
        this.statusValue = statusValue;
    }
}
