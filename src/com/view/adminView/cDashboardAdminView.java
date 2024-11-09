package com.view.adminView;

import com.main.resources.templates.cFrameDashboardApp;
import com.model.cContentAdminView;

public class cDashboardAdminView extends cFrameDashboardApp {

    private cContentAdminView componentContentView = new cContentAdminView();
    private cSidebarAdminView componentSidebarView = new cSidebarAdminView(componentContentView);

    public cDashboardAdminView() {
        super();
        initsViewDashboardAdmin();
    }

    public void initsViewDashboardAdmin() {
        setVisible(true);

        componentContentView.setBounds(240, 70, 1126, 698);

        sidebarPanel.add(componentSidebarView);

        bgFrame.add(componentContentView);

    }
}
