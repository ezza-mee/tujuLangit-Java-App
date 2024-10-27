package com.view.karyawanView;

import com.main.resources.templates.cFrameDashboardApp;

public class cDashboardKaryawan extends cFrameDashboardApp {

    private cSidebarKaryawanView componentSidebar = new cSidebarKaryawanView();
    private cBerandaKaryawanView componentBeranda = new cBerandaKaryawanView();

    public cDashboardKaryawan() {
        super();
        initsSidebarKaryawan();
    }

    public void initsSidebarKaryawan() {
        setVisible(true);
        componentBeranda.setBounds(240, 70, 1126, 698);
        sidebarPanel.add(componentSidebar);
        bgFrame.add(componentBeranda);

    }
}
