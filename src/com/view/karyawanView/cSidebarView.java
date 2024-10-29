package com.view.karyawanView;

import com.main.resources.templates.cPanelSidebarApp;
import com.partials.*;

public class cSidebarView extends cPanelSidebarApp {

    private cIconImage iconImage = new cIconImage();

    // component sidebar
    private cSidebarMenu menuHome = new cSidebarMenu(iconImage.iconHomeDefault, iconImage.iconHomeHover, "Home", 150);
    private cSidebarMenu menuProduct = new cSidebarMenu(iconImage.iconMenuDefault, iconImage.iconMenuHover, "Product",
            150 + 50);
    private cSidebarMenu menuSeats = new cSidebarMenu(iconImage.iconSeatsDefault, iconImage.iconSeatsHover, "Seats",
            150 + 50 + 50);
    private cSidebarMenu menuTransaksi = new cSidebarMenu(iconImage.iconTransaksiDefault, iconImage.iconTransaksiHover,
            "Transaksi", 150 + 50 + 50 + 50);
    private cSidebarMenu menuHistory = new cSidebarMenu(iconImage.iconHistoryDefault, iconImage.iconHistoryHover,
            "History",
            150 + 50 + 50 + 50 + 50);

    public cSidebarView() {
        super();

        initsSidebarView();
    }

    public void initsSidebarView() {
        setVisible(true);

        bgPanel.add(menuHome);
        bgPanel.add(menuProduct);
        bgPanel.add(menuSeats);
        bgPanel.add(menuTransaksi);
        bgPanel.add(menuHistory);

    }

}
