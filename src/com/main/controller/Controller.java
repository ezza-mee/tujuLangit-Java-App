package com.main.controller;

import com.view.StaffView.cDashboardStaffView;
import com.view.adminView.cDashboardAdminView;
import com.view.loginView.cLoginView;

public class Controller {

    // Inisialisasi frame login saja
    private static cLoginView frameLogin = new cLoginView();

    // Tunda inisialisasi frame dashboard hingga diperlukan
    private static cDashboardStaffView cDashboardStaffView;
    private static cDashboardAdminView dashboardAdmin;

    // Menampilkan login
    public static void showLoginAdmin() {
        frameLogin.initsLoginView();
        frameLogin.setVisible(true);
    }

    // Menyembunyikan login
    public static void hiddenFrameLogin() {
        frameLogin.setVisible(false);
    }

    // Menampilkan dashboard admin
    public static void showDashboardAdmin() {
        if (dashboardAdmin == null) {
            dashboardAdmin = new cDashboardAdminView();
            dashboardAdmin.initsViewDashboardAdmin();
        }
        hiddenFrameLogin();
        dashboardAdmin.setVisible(true);
    }

    // Menyembunyikan dashboard admin
    public static void hiddenDashboardAdmin() {
        if (dashboardAdmin != null) {
            dashboardAdmin.setVisible(false);
        }
    }

    // Menampilkan dashboard staff
    public static void showcDashboardStaffView() {
        if (cDashboardStaffView == null) {
            cDashboardStaffView = new cDashboardStaffView();
            cDashboardStaffView.initsViewDashboardStaff();
        }
        hiddenFrameLogin();
        cDashboardStaffView.setVisible(true);
    }

    // Metode main untuk memulai aplikasi
    public static void main(String[] args) {
        showLoginAdmin();
    }
}