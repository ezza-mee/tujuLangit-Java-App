package com.view;

import com.main.resources.templates.cFrameDashboardApp;

public class cDashboardAdmin extends cFrameDashboardApp {

    private cSidebarView componentSidebar = new cSidebarView();
    private cBerandaView componentBeranda = new cBerandaView();

    public cDashboardAdmin() {
        super();
        initsSidebar();
    }

    public void initsSidebar() {
        setVisible(true);
        componentBeranda.setBounds(240, 70, 1126, 698);
        sidebarPanel.add(componentSidebar);
        bgFrame.add(componentBeranda);

    }
}
