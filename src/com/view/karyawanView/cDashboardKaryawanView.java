package com.view.karyawanView;

import com.main.resources.templates.cFrameDashboardApp;

public class cDashboardKaryawanView extends cFrameDashboardApp {

    private cPanelContentView componentContentView = new cPanelContentView();
    private cSidebarKaryawanView componentSidebarView = new cSidebarKaryawanView(componentContentView);

    public cDashboardKaryawanView() {
        super();
        initsViewDashboardKaryawan();
    }

    public void initsViewDashboardKaryawan() {
        setVisible(true);

        componentContentView.setBounds(240, 70, 1126, 698);

        sidebarPanel.add(componentSidebarView);

        bgFrame.add(componentContentView);

    }

}
