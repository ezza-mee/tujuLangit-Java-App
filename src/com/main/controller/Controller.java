package com.main.controller;

import com.partials.cSidebarMenu;
import com.view.*;

public class Controller {

    private static cLoginView frameLogin = new cLoginView();

    private static cSidebarView sidebarContent = new cSidebarView();

    public static void showLoginAdmin() {
        frameLogin.setVisible(false);
        frameLogin.initsLoginAdmin();
        frameLogin.setVisible(true);
    }

    public static void showSidebarView() {
        sidebarContent.setVisible(false);
        sidebarContent.initsBeranda();
        sidebarContent.setVisible(true);
    }
}
