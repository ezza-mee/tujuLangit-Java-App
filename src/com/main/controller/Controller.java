package com.main.controller;

import com.view.StaffView.cDashboardStaffView;
import com.view.adminView.cDashboardAdminView;
import com.view.loginView.cLoginView;

public class Controller {

    private static cLoginView frameLogin = new cLoginView();

    private static cDashboardStaffView cDashboardStaffView;
    private static cDashboardAdminView cDashboardAdminView;

    public static void showLoginAdmin() {
        frameLogin.initsLoginView();
        frameLogin.setVisible(true);
    }

    public static void hiddenFrameLogin() {
        frameLogin.setVisible(false);
    }

    public static void showDashboardAdmin() {
        if (cDashboardAdminView == null) {
            cDashboardAdminView = new cDashboardAdminView();
            cDashboardAdminView.initsViewDashboardAdmin();
        }
        hiddenFrameLogin();
        cDashboardAdminView.setVisible(true);
    }

    public static void hiddenDashboardAdmin() {
        if (cDashboardAdminView != null) {
            cDashboardAdminView.setVisible(false);
        }
    }

    public static void hiddenDashboardStaffView() {
        if (cDashboardStaffView != null) {
            cDashboardStaffView.setVisible(false);
        }
    }

    public static void showDashboardStaff() {
        if (cDashboardStaffView == null) {
            cDashboardStaffView = new cDashboardStaffView();
            cDashboardStaffView.initsViewDashboardStaff();
        }
        hiddenFrameLogin();
        cDashboardStaffView.setVisible(true);
    }

    public static void showcDashboardStaffView() {
        if (cDashboardStaffView == null) {
            cDashboardStaffView = new cDashboardStaffView();
            cDashboardStaffView.initsViewDashboardStaff();
        }
        hiddenFrameLogin();
        cDashboardStaffView.setVisible(true);
    }
}