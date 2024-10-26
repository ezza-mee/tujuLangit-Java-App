package com.main.controller;

import com.view.*;

public class Controller {

    private static cLoginView frameLogin = new cLoginView();

    private static cDashboardAdmin FrameDashboard = new cDashboardAdmin();


    public static void showLoginAdmin() {
        frameLogin.setVisible(false);
        frameLogin.initsLoginAdmin();
        frameLogin.setVisible(true);
    }

    public static void showDashboardAdmin(){
        FrameDashboard.setVisible(false);
        FrameDashboard.initDashboardAdmin();
        FrameDashboard.setVisible(true);
    }
}
