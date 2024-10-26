package com.main.controller;

import com.view.*;

public class Controller {

    private static cLoginView frameLogin = new cLoginView();

    private static cDashboardAdmin frameDashboardApp = new cDashboardAdmin();

    public static void showLoginAdmin() {
        frameLogin.initsLoginAdmin();
        frameLogin.setVisible(true);
    }

    public static void showDashboardAdmin() {
        frameDashboardApp.initsSidebar();
        frameDashboardApp.setVisible(true);
    }

}
