package com.view.karyawanView;

import com.main.resources.templates.cPanelSidebarApp;
import com.partials.*;

public class cSidebarKaryawanView extends cPanelSidebarApp {

    // ini adalah component sidebar
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 100);
    private cSidebarMenu menuDataMenu = new cSidebarMenu("Data Menu", 100 + 50);
    private cSidebarMenu menuDataKursi = new cSidebarMenu("Data Kursi", 100 + 50 + 50);
    private cSidebarMenu menuTransaksi = new cSidebarMenu("Transaksi", 100 + 50 + 50 + 50);
    private cSidebarMenu menuHistory = new cSidebarMenu("History", 100 + 50 + 50 + 50 + 50);
    private cSidebarMenu menuAbout = new cSidebarMenu("About", 100 + 50 + 50 + 50 + 50 + 50);

    public cSidebarKaryawanView() {
        super();
        initsSidebarKaryawan();
    }

    public void initsSidebarKaryawan() {
        setVisible(true);
        bgPanel.add(menuBeranda);
        bgPanel.add(menuDataMenu);
        bgPanel.add(menuDataKursi);
        bgPanel.add(menuTransaksi);
        bgPanel.add(menuHistory);
        bgPanel.add(menuAbout);
    }

}
