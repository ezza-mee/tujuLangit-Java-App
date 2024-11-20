package com.view.StaffView;

import com.main.resources.templates.cFrameDashboardApp;
import com.model.cContentStaffView;

public class cDashboardStaffView extends cFrameDashboardApp {

    private cContentStaffView componentContentView = new cContentStaffView();
    private cSidebarStaffView componentSidebarView = new cSidebarStaffView(componentContentView);

    public cDashboardStaffView() {
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
