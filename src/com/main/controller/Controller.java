package com.main.controller;

import com.view.adminView.cDashboardAdmin;
import com.view.karyawanView.cDashboardKaryawan;
import com.view.loginView.cLoginView;

public class Controller {

    // private static cLoginView frameLogin = new cLoginView();

    private static cDashboardKaryawan DashboardKaryawan = new cDashboardKaryawan();

    private static cDashboardAdmin DashboardAdmin = new cDashboardAdmin();

    // public static void showLoginAdmin() {
    //     frameLogin.initsLoginAdmin();
    //     frameLogin.setVisible(true);
    // }

    public static void showDashboardKaryawan() {
        DashboardKaryawan.initsSidebarKaryawan();
        DashboardKaryawan.setVisible(true);
    }

    public static void showDashboardAdmin(){
        DashboardAdmin.initsSidebarAdmin();
        DashboardAdmin.setVisible(true);
    }

}
