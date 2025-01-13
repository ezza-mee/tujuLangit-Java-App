package com.view.staffView;

import com.partials.*;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;

public class cHomeView extends cPanelContentApp {

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component beranda
    private cPanelRounded panelDataMenu = new cPanelRounded(40, 40, 240, 130, 10, 10);
    private cPanelRounded panelDataSeats = new cPanelRounded(310, 40, 240, 130, 10, 10);
    private cPanelRounded panelDataTransaksi = new cPanelRounded(580, 40, 240, 130, 10, 10);
    private cPanelRounded panelDataHistory = new cPanelRounded(850, 40, 240, 130, 10, 10);
    private cPanelRounded panelListTransaksi = new cPanelRounded(40, 210, 1050, 430, 10, 10);

    // component label beranda
    private cLabelInfo labelDataMenu = new cLabelInfo("Data Menu", 0, 10, 240, 40);
    private cLabelInfo labelDataSeats = new cLabelInfo("Data Seats", 0, 10, 240, 40);
    private cLabelInfo labelDataTransaksi = new cLabelInfo("Data Transaksi", 0, 10, 240, 40);
    private cLabelInfo labelDataHistory = new cLabelInfo("Data History", 0, 10, 240, 40);
    private cLabelInfo labelListTransaksi = new cLabelInfo("List Transaksi", 30, 20, 580, 40);

    // component value data beranda
    private cLabelInfo valueDataMenu = new cLabelInfo("0", 0, 60, 240, 40);
    private cLabelInfo valueDataSeats = new cLabelInfo("0", 0, 60, 240, 40);
    private cLabelInfo valueDataTransaksi = new cLabelInfo("0", 0, 60, 240, 40);
    private cLabelInfo valueDataHistory = new cLabelInfo("0", 0, 60, 240, 40);

    // component gambar data beranda
    private cImage imgDataMenu = new cImage("src/com/main/resources/images/menu(green).png", 20, 50, 55, 50);
    private cImage imgDataSeats = new cImage("src/com/main/resources/images/datakursi(green).png", 20, 50, 55, 50);
    private cImage imgDataTransaksi = new cImage("src/com/main/resources/images/transaksi(green).png", 20, 50, 55, 50);
    private cImage imgDataHistory = new cImage("src/com/main/resources/images/history(green).png", 20, 50, 55, 50);

    // component button data beranda
    private cButtonRounded btnListTransaksi = new cButtonRounded("see all", 900, 20, 110, 40, 10);

    public cHomeView() {
        super();
        initsShowHomeView();
    }

    public void initsShowHomeView() {
        setVisible(true);
        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        labelDataMenu.setHorizontalAlignment(JLabel.CENTER);
        labelDataSeats.setHorizontalAlignment(JLabel.CENTER);
        labelDataTransaksi.setHorizontalAlignment(JLabel.CENTER);
        labelDataHistory.setHorizontalAlignment(JLabel.CENTER);

        valueDataMenu.setHorizontalAlignment(JLabel.CENTER);
        valueDataSeats.setHorizontalAlignment(JLabel.CENTER);
        valueDataTransaksi.setHorizontalAlignment(JLabel.CENTER);
        valueDataHistory.setHorizontalAlignment(JLabel.CENTER);

        panelDataMenu.add(labelDataMenu);
        panelDataMenu.add(imgDataMenu);

        panelDataSeats.add(labelDataSeats);
        panelDataSeats.add(imgDataSeats);

        panelDataTransaksi.add(labelDataTransaksi);
        panelDataTransaksi.add(imgDataTransaksi);

        panelDataHistory.add(labelDataHistory);
        panelDataHistory.add(imgDataHistory);

        panelDataMenu.add(valueDataMenu);
        panelDataSeats.add(valueDataSeats);
        panelDataTransaksi.add(valueDataTransaksi);
        panelDataHistory.add(valueDataHistory);

        panelListTransaksi.add(labelListTransaksi);
        panelListTransaksi.add(btnListTransaksi);

        bgPanel.add(panelDataMenu);
        bgPanel.add(panelDataSeats);
        bgPanel.add(panelDataTransaksi);
        bgPanel.add(panelDataHistory);
        bgPanel.add(panelListTransaksi);
        bgPanel.add(labelCopyright);
    }
}
