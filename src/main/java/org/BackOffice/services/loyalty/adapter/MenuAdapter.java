package org.BackOffice.services.loyalty.adapter;

import org.BackOffice.domain.InMemoryData;
import org.BackOffice.services.loyalty.domain.MenuItem;

public class MenuAdapter {

    public int resolveMenuItem(InMemoryData.Menu menu) {
        int id = 0;
        switch (menu) {
            case AMERICANO -> {
                id = MenuItem.AMERICANO.id;
            }
            case LATTE -> {
                id = MenuItem.LATTE.id;
            }
            case MOCHA -> {
                id = MenuItem.MOCHA.id;
            }
        }
        return id;
    }
}
