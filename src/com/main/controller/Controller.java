package com.main.controller;

import com.view.StaffView.cDashboardStaffView;
import com.view.adminView.cDashboardAdminView;
import com.view.loginView.cLoginView;

public class Controller {

    // Frame untuk login
    private static cLoginView frameLogin = new cLoginView();

    // Frame untuk dashboard
    private static cDashboardStaffView cDashboardStaffView;
    private static cDashboardAdminView cDashboardAdminView;

    // ID Staff yang sedang login
    private static Integer currentStaffId = null;

    // Tampilkan login frame
    public static void showLogin() {
        frameLogin.initsLoginView();
        frameLogin.setVisible(true);
    }

    // Sembunyikan login frame
    public static void hiddenFrameLogin() {
        frameLogin.setVisible(false);
    }

    // Tampilkan dashboard admin
    public static void showDashboardAdmin() {
        if (cDashboardAdminView == null) {
            cDashboardAdminView = new cDashboardAdminView();
            cDashboardAdminView.initsViewDashboardAdmin();
        }
        hiddenFrameLogin();
        cDashboardAdminView.setVisible(true);
    }

    // Sembunyikan dashboard admin
    public static void hiddenDashboardAdmin() {
        if (cDashboardAdminView != null) {
            cDashboardAdminView.setVisible(false);
        }
    }

    // Tampilkan dashboard staff
    public static void showDashboardStaffView(int staffId) {
        if (cDashboardStaffView == null) {
            // Simpan ID staff yang login
            setCurrentStaffId(staffId);

            // Buat instance dashboard staff
            cDashboardStaffView = new cDashboardStaffView();
        }
        hiddenFrameLogin();
        cDashboardStaffView.setVisible(true);
    }

    // Sembunyikan dashboard staff
    public static void hiddenDashboardStaffView() {
        if (cDashboardStaffView != null) {
            cDashboardStaffView.setVisible(false);
        }
    }

    // Getter untuk mendapatkan ID staff yang sedang login
    public static Integer getCurrentStaffId() {
        return currentStaffId;
    }

    // Setter untuk menyimpan ID staff yang login
    private static void setCurrentStaffId(Integer staffId) {
        currentStaffId = staffId;
    }

    // Logout dan reset semua data
    public static void logout() {
        // Reset ID staff
        currentStaffId = null;

        // Sembunyikan semua dashboard
        hiddenDashboardStaffView();
        hiddenDashboardAdmin();

        // Tampilkan login frame
        showLogin();
    }
}
