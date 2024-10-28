package com.view.karyawanView;

import com.main.resources.templates.cPanelSidebarApp;
import com.partials.*;

public class cSidebarView extends cPanelSidebarApp {

    // ini adalah component sidebar
    private cSidebarMenu menuBeranda = new cSidebarMenu("Home", 150);
    private cSidebarMenu menuDataMenu = new cSidebarMenu("Menu Data", 150 + 50);
    private cSidebarMenu menuDataSeats = new cSidebarMenu("Seats Data", 150 + 50 + 50);
    private cSidebarMenu menuTransaksi = new cSidebarMenu("Transaksi", 150 + 50 + 50 + 50);
    private cSidebarMenu menuHistory = new cSidebarMenu("History", 150 + 50 + 50 + 50 + 50);
    private cSidebarMenu menuAbout = new cSidebarMenu("profile", 150 + 50 + 50 + 50 + 50 + 50);

    public cSidebarView() {
        super();
        initsSidebarView();
    }

    public void initsSidebarView() {
        setVisible(true);
        bgPanel.add(menuBeranda);
        bgPanel.add(menuDataMenu);
        bgPanel.add(menuDataSeats);
        bgPanel.add(menuTransaksi);
        bgPanel.add(menuHistory);
        bgPanel.add(menuAbout);
    }

}
