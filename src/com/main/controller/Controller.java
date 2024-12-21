package com.main.controller;

import com.model.cContentLoginView;
import com.view.StaffView.cDashboardStaffView;
import com.view.adminView.cDashboardAdminView;
import com.view.loginView.cLoginView;

public class Controller {

    // private static cLoginView frameLogin = new cLoginView();

    private static cDashboardStaffView cDashboardStaffView = new
    cDashboardStaffView();

    // private static cDashboardAdminView dashboardAdmin = new cDashboardAdminView();

    // public static void showLoginAdmin() {
    //     frameLogin.initsLoginView();
    //     frameLogin.setVisible(true);
    // }

    // public static void hiddenFrameLogin(){
    //     frameLogin.setVisible(false);
    // }

    // public static void showDashboardAdmin() {
    //     dashboardAdmin.setVisible(false);
    //     dashboardAdmin.initsViewDashboardAdmin();
    //     dashboardAdmin.setVisible(true);
    // }

    // public static void hiddenDashboardAdmin(){
    //     dashboardAdmin.setVisible(false);
    // }

    public static void showcDashboardStaffView() {
    cDashboardStaffView.initsViewDashboardStaff();
    cDashboardStaffView.setVisible(true);
    }

    // public static void showDashboardAdmin() {
    //     DashboardAdmin.initsViewDashboardAdmin();
    //     DashboardAdmin.setVisible(true);
    // }

}
