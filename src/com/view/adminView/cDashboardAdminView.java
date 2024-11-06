package com.view.adminView;

import com.main.resources.templates.cFrameDashboardApp;

public class cDashboardAdminView extends cFrameDashboardApp {

    private cHomeView componentHomeView = new cHomeView();

    private cPanelContentView componentContentView = new cPanelContentView();
    private cSidebarAdminView componentSidebarView = new cSidebarAdminView(componentContentView);

    public cDashboardAdminView() {
        super();
        initsViewDashboardAdmin();
    }

    public void initsViewDashboardAdmin() {
        setVisible(true);
        componentHomeView.setBounds(240, 70, 1126, 698);
        sidebarPanel.add(componentSidebarView);
        
        bgFrame.add(componentHomeView);
        bgFrame.add(componentContentView);

    }
}
