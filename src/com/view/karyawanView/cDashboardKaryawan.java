package com.view.karyawanView;

import com.main.resources.templates.cFrameDashboardApp;

public class cDashboardKaryawan extends cFrameDashboardApp {

    private cPanelContentView componentContentView = new cPanelContentView();
    private cSidebarView componentSidebar = new cSidebarView(componentContentView);

    public cDashboardKaryawan() {
        super();
        initsViewDashboardKaryawan();
    }

    public void initsViewDashboardKaryawan() {
        setVisible(true);

        componentContentView.setBounds(240, 70, 1126, 698);

        sidebarPanel.add(componentSidebar);

        bgFrame.add(componentContentView);

    }

}
