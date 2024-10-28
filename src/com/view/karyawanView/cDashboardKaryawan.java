package com.view.karyawanView;

import com.main.resources.templates.cFrameDashboardApp;

public class cDashboardKaryawan extends cFrameDashboardApp {

    private cSidebarView componentSidebar = new cSidebarView();
    // private cBerandaKaryawanView componentBeranda = new cBerandaKaryawanView();
    // private cDataKursiView componentDataKursi = new cDataKursiView();
    // private cDataTransaksiKaryawanView componentDataTransaksi = new
    // cDataTransaksiKaryawanView();

    // private cDataMenuView componentDataMenu = new cDataMenuView();

    private cHistoryTransaksiView componentHistoryTransaksiView = new cHistoryTransaksiView();

    public cDashboardKaryawan() {
        super();
        initsSidebarKaryawan();
    }

    public void initsSidebarKaryawan() {
        setVisible(true);
        componentHistoryTransaksiView.setBounds(240, 70, 1126, 698);

        sidebarPanel.add(componentSidebar);

        bgFrame.add(componentHistoryTransaksiView);

    }
}
