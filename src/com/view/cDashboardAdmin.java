package com.view;
import com.main.resources.templates.cFrameDashboardApp;
import com.partials.cButton;
import com.partials.cSidebarMenu;

public class cDashboardAdmin extends cFrameDashboardApp {
    
    private cSidebarMenu menuBeranda = new cSidebarMenu("beranda", 100);

    private cSidebarMenu daftarMenu = new cSidebarMenu("Daftar Menu", 100 +50);

    private cSidebarMenu historyTransaksi = new cSidebarMenu("History Transaksi", 100 +50+50);

    private cSidebarMenu bahanMenu = new cSidebarMenu("Bahan", 100 +50+50+50);

    private cSidebarMenu menuCheckout = new cSidebarMenu("Checkout", 100 +50+50+50+50);

    
    public cDashboardAdmin() {
        super();
    }
    public void initDashboardAdmin(){
        setVisible(true);
        sidebarPanel.add(menuBeranda);
        sidebarPanel.add(daftarMenu);
        sidebarPanel.add(historyTransaksi);
        sidebarPanel.add(bahanMenu);
        sidebarPanel.add(menuCheckout);
        // sidebarPanel.add(btnDaftarMenu);
        // sidebarPanel.add(btnHistoryTransaksi);
        // sidebarPanel.add(btnDaftarTransaksi);
        // sidebarPanel.add(btnBahan);
    }
}

