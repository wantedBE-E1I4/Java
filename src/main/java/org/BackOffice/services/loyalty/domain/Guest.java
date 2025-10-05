package org.BackOffice.services.loyalty.domain;

public class Guest {
    private int seq;
    private final int id = ++seq;

    public int getId() {
        return id;
    }
}
