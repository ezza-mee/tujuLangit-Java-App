package com.view.adminView;

import com.main.resources.templates.cFrameDashboardApp;
import com.model.cContentAdminView;
import com.partials.cLabelInfo;

public class cDashboardAdminView extends cFrameDashboardApp {

    private cContentAdminView componentContentView = new cContentAdminView();
    private cSidebarAdminView componentSidebarView = new cSidebarAdminView(componentContentView);

    private cLabelInfo labelRole = new cLabelInfo("Welcome", 40, 20, 500, 30);

    public cDashboardAdminView() {
        super();
        initsViewDashboardAdmin();
    }

    public void initsViewDashboardAdmin() {
        setVisible(true);

        headerPanel.add(labelRole);

        componentContentView.setBounds(240, 70, 1126, 698);

        sidebarPanel.add(componentSidebarView);

        bgFrame.add(componentContentView);

    }
}
