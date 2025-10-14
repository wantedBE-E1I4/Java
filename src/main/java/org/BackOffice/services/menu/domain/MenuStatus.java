package org.BackOffice.services.menu.domain;

public enum MenuStatus {
    SELLING("판매중",1),
    SOLDOUT("품절",2),
    NEW("신규",3),
    DELETE("삭제",4);


    public final String statusValue;
    public final int statusCode;

    MenuStatus(String statusValue, int statusCode) {
        this.statusValue = statusValue;
        this.statusCode = statusCode;
    }
}
