package com.view;

import com.main.resources.templates.cFrameSidebarApp;
import com.partials.*;

public class cSidebarView extends cFrameSidebarApp {

    // ini adalah component sidebar
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 100);
    private cSidebarMenu menuDataMenu = new cSidebarMenu("Data Menu", 100 + 50);
    private cSidebarMenu menuDataKursi = new cSidebarMenu("Data Kursi", 100 + 50 + 50);
    private cSidebarMenu menuTransaksi = new cSidebarMenu("Transaksi", 100 + 50 + 50 + 50);
    private cSidebarMenu menuHistory = new cSidebarMenu("History", 100 + 50 + 50 + 50 + 50);
    private cSidebarMenu menuAbout = new cSidebarMenu("About", 100 + 50 + 50 + 50 + 50 + 50);

    public cSidebarView() {
        super();
        initsSidebarView();
    }

    public void initsSidebarView() {
        setVisible(true);
        bgFrame.add(menuBeranda);
        bgFrame.add(menuDataMenu);
        bgFrame.add(menuDataKursi);
        bgFrame.add(menuTransaksi);
        bgFrame.add(menuHistory);
        bgFrame.add(menuAbout);
    }

}
