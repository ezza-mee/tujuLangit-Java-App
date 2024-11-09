package com.main.controller;

import com.model.cContentLoginView;
import com.view.adminView.cDashboardAdminView;
import com.view.karyawanView.cDashboardKaryawanView;
import com.view.loginView.cLoginView;

public class Controller {

    // private static cLoginView frameLogin = new cLoginView();

    // private static cDashboardKaryawanView DashboardKaryawan = new
    // cDashboardKaryawanView();

    private static cDashboardAdminView dashboardAdmin = new cDashboardAdminView();

    // public static void showLoginAdmin() {
    //     frameLogin.initsLoginView();
    //     frameLogin.setVisible(true);
    // }

    // public static void hiddenFrameLogin(){
    //     frameLogin.setVisible(false);
    // }

    public static void showDashboardAdmin() {
        dashboardAdmin.initsViewDashboardAdmin();
        dashboardAdmin.setVisible(true);
    }

    public static void hiddenDashboardAdmin(){
        dashboardAdmin.setVisible(false);
    }

    // public static void showDashboardKaryawan() {
    // DashboardKaryawan.initsViewDashboardKaryawan();
    // DashboardKaryawan.setVisible(true);
    // }

    // public static void showDashboardAdmin() {
    //     DashboardAdmin.initsViewDashboardAdmin();
    //     DashboardAdmin.setVisible(true);
    // }

}
