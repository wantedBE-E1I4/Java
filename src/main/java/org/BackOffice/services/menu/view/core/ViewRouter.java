package org.BackOffice.services.menu.view.core;

import java.util.HashMap;
import java.util.Map;
import org.BackOffice.services.menu.ProductMenu;
import org.BackOffice.services.menu.view.MenuAddAndDeleteView;
import org.BackOffice.services.menu.view.MenuBoardSettingView;
import org.BackOffice.services.menu.view.MenuBoardView;
import org.BackOffice.services.menu.view.MenuDeleteView;
import org.BackOffice.services.menu.view.MenuManagerView;
import org.BackOffice.services.menu.view.MenuPriceSettingView;
import org.BackOffice.services.menu.view.MenuRegisterView;
import org.BackOffice.services.menu.view.MenuStatusSettingView;

public class ViewRouter {
    private static final Map<String, View> viewMap = new HashMap<>();

    static {
        viewMap.put("productMenu", new ProductMenu());
        viewMap.put("menuBoard", new MenuBoardView());
        viewMap.put("menuManager", new MenuManagerView());
        viewMap.put("menuBoardSetting", new MenuBoardSettingView());
        viewMap.put("menuPriceSetting", new MenuPriceSettingView());
        viewMap.put("menuStatusSetting", new MenuStatusSettingView());
        viewMap.put("menuAddAndDelete", new MenuAddAndDeleteView());
        viewMap.put("menuRegister", new MenuRegisterView());
        viewMap.put("menuDelete", new MenuDeleteView());
    }

    public static void navigatorTo(String route) {
        View view = viewMap.get(route);
        if (view != null) {
            view.show();
        } else {
            System.out.println("존재하지 않는 번호입니다.");
        }
    }
}
