package com.view;

import com.main.resources.templates.cFrameDashboardApp;
import com.partials.*;

public class cSidebarView extends cFrameDashboardApp {

    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 100);
    private cSidebarMenu menuDataMenu = new cSidebarMenu("Data Menu", 100 + 50);
    private cSidebarMenu menuDataKursi = new cSidebarMenu("Data Kursi", 100 + 50 + 50);

    public cSidebarView() {
        super();
    }

    public void initsBeranda() {
        setVisible(true);
        sidebarPanel.add(menuBeranda);
        sidebarPanel.add(menuDataMenu);
        sidebarPanel.add(menuDataKursi);
    }

}
