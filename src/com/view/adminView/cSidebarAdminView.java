package com.view.adminView;

import com.main.resources.templates.cPanelSidebarApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cSidebarAdminView extends cPanelSidebarApp {

    public cContentAdminView contentView;

    private cIconImage iconImage = new cIconImage();

    // component sidebar
    private cSidebarMenu menuHome = new cSidebarMenu(iconImage.iconHomeDefault, iconImage.iconHomeHover, "Home",
            150);
    private cSidebarMenu menuKaryawan = new cSidebarMenu(iconImage.iconMenuDefault, iconImage.iconMenuHover,
            "Product",
            150 + 50);
    private cSidebarMenu menuSupplier = new cSidebarMenu(iconImage.iconSupplierDefault, iconImage.iconSupplierHover,
            "Supplier",
            150 + 50 + 50);
    private cSidebarMenu menuStaff = new cSidebarMenu(iconImage.iconStaffDefault,
            iconImage.iconStaffHover,
            "Staff", 150 + 50 + 50 + 50);
    private cSidebarMenu menuHistorySupplier = new cSidebarMenu(iconImage.iconHistoryDefault,
            iconImage.iconHistoryHover,
            "History",
            150 + 50 + 50 + 50 + 50);
            private cSidebarMenu menuReport = new cSidebarMenu(iconImage.iconReportDefault, iconImage.iconReportHover,
            "Report", 150 + 50 + 50 + 50 + 50 + 50);

    private void resetSidebar() {
        setVisible(false);

        menuHome.setForeground(cColor.WHITE);
        menuHome.setBackground(cColor.GREEN);
        menuHome.setSidebarInAktif();

        menuKaryawan.setForeground(cColor.WHITE);
        menuKaryawan.setBackground(cColor.GREEN);
        menuKaryawan.setSidebarInAktif();

        menuSupplier.setForeground(cColor.WHITE);
        menuSupplier.setBackground(cColor.GREEN);
        menuSupplier.setSidebarInAktif();

        menuStaff.setForeground(cColor.WHITE);
        menuStaff.setBackground(cColor.GREEN);
        menuStaff.setSidebarInAktif();

        menuHistorySupplier.setForeground(cColor.WHITE);
        menuHistorySupplier.setBackground(cColor.GREEN);
        menuHistorySupplier.setSidebarInAktif();

        menuReport.setForeground(cColor.WHITE);
        menuReport.setBackground(cColor.GREEN);
        menuReport.setSidebarInAktif();
    }

    public cSidebarAdminView(cContentAdminView contentView) {
        super();
        this.contentView = contentView;

        menuHome.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsHomeView();
            }
        });

        menuKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsDataProductView();
            }
        });

        menuSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsDataSupplierView();
            }
        });

        menuStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsDataKaryawanView();
            }
        });

        menuHistorySupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsTransactionsView();
            }
        });

        menuReport.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                initsReportView();
            }
        });

        bgPanel.add(menuHome);
        bgPanel.add(menuKaryawan);
        bgPanel.add(menuSupplier);
        bgPanel.add(menuStaff);
        bgPanel.add(menuHistorySupplier);
        bgPanel.add(menuReport);
        initsHomeView();
    }

    private void initsHomeView() {
        resetSidebar();
        menuHome.setForeground(cColor.GREEN);
        menuHome.setBackground(cColor.WHITE);
        menuHome.setSidebarAktif();

        contentView.showHomeView();

        setVisible(true);

    }

    private void initsDataProductView() {
        resetSidebar();

        menuKaryawan.setForeground(cColor.GREEN);
        menuKaryawan.setBackground(cColor.WHITE);
        menuKaryawan.setSidebarAktif();

        contentView.showDataProductView();

        setVisible(true);

    }

    private void initsDataSupplierView() {
        resetSidebar();

        menuSupplier.setForeground(cColor.GREEN);
        menuSupplier.setBackground(cColor.WHITE);
        menuSupplier.setSidebarAktif();
        contentView.showDataSupplierView();

        setVisible(true);

    }

    private void initsDataKaryawanView() {
        resetSidebar();

        menuStaff.setForeground(cColor.GREEN);
        menuStaff.setBackground(cColor.WHITE);
        menuStaff.setSidebarAktif();

        contentView.showDataStaffView();

        setVisible(true);

    }

    private void initsTransactionsView() {
        resetSidebar();

        menuHistorySupplier.setForeground(cColor.GREEN);
        menuHistorySupplier.setBackground(cColor.WHITE);
        menuHistorySupplier.setSidebarAktif();

        contentView.showTransactionsView();

        setVisible(true);

    }

    private void initsReportView() {
        resetSidebar();

        menuReport.setForeground(cColor.GREEN);
        menuReport.setBackground(cColor.WHITE);
        menuReport.setSidebarAktif();

        contentView.showReportDataProductView();

        setVisible(true);
    }

}
