package com.view.karyawanView;

import com.partials.*;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;

public class cBerandaKaryawanView extends cPanelContentApp {

    // ini adalah component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // ini adalah component beranda
    private cPanelRounded panelDataMenu = new cPanelRounded(40, 40, 240, 130, 10, 10);
    private cPanelRounded panelDataKursi = new cPanelRounded(310, 40, 240, 130, 10, 10);
    private cPanelRounded panelDataTransaksi = new cPanelRounded(580, 40, 240, 130, 10, 10);
    private cPanelRounded panelDataHistory = new cPanelRounded(850, 40, 240, 130, 10, 10);
    private cPanelRounded panelListTransaksi = new cPanelRounded(40, 210, 1050, 430, 10, 10);

    // ini adalah component label beranda
    private cLabelInfo labelDataMenu = new cLabelInfo("Data Menu", 0, 10, 240, 40);
    private cLabelInfo labelDataKursi = new cLabelInfo("Data Kursi", 0, 10, 240, 40);
    private cLabelInfo labelDataTransaksi = new cLabelInfo("Data Transaksi", 0, 10, 240, 40);
    private cLabelInfo labelDataHistory = new cLabelInfo("Data History", 0, 10, 240, 40);
    private cLabelInfo labelListTransaksi = new cLabelInfo("List Transaksi", 30, 20, 580, 40);

    // ini adalah component value data beranda
    private cLabelInfo valueDataMenu = new cLabelInfo("0", 0, 60, 240, 40);
    private cLabelInfo valueDataKursi = new cLabelInfo("0", 0, 60, 240, 40);
    private cLabelInfo valueDataTransaksi = new cLabelInfo("0", 0, 60, 240, 40);
    private cLabelInfo valueDataHistory = new cLabelInfo("0", 0, 60, 240, 40);

    // ini adalah component gambar data beranda
    private cImage imgDataMenu = new cImage("src/com/main/resources/images/menu(green).png", 20, 50, 55, 50);
    private cImage imgDataKursi = new cImage("src/com/main/resources/images/datakursi(green).png", 20, 50, 55, 50);
    private cImage imgDataTransaksi = new cImage("src/com/main/resources/images/transaksi(green).png", 20, 50, 55, 50);
    private cImage imgDataHistory = new cImage("src/com/main/resources/images/history(green).png", 20, 50, 55, 50);


    // ini adalah component button data beranda
    private cButtonLogin btnListTransaksi = new cButtonLogin("see all", 900, 20, 110, 40, 10);

    public cBerandaKaryawanView() {
        super();
        initsBerandaKaryawan();
    }

    public void initsBerandaKaryawan() {
        setVisible(true);
        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        labelDataMenu.setHorizontalAlignment(JLabel.CENTER);
        labelDataKursi.setHorizontalAlignment(JLabel.CENTER);
        labelDataTransaksi.setHorizontalAlignment(JLabel.CENTER);
        labelDataHistory.setHorizontalAlignment(JLabel.CENTER);

        valueDataMenu.setHorizontalAlignment(JLabel.CENTER);
        valueDataKursi.setHorizontalAlignment(JLabel.CENTER);
        valueDataTransaksi.setHorizontalAlignment(JLabel.CENTER);
        valueDataHistory.setHorizontalAlignment(JLabel.CENTER);

        panelDataMenu.add(labelDataMenu);
        panelDataMenu.add(imgDataMenu);

        panelDataKursi.add(labelDataKursi);
        panelDataKursi.add(imgDataKursi);

        panelDataTransaksi.add(labelDataTransaksi);
        panelDataTransaksi.add(imgDataTransaksi);

        panelDataHistory.add(labelDataHistory);
        panelDataHistory.add(imgDataHistory);

        panelDataMenu.add(valueDataMenu);
        panelDataKursi.add(valueDataKursi);
        panelDataTransaksi.add(valueDataTransaksi);
        panelDataHistory.add(valueDataHistory);

        panelListTransaksi.add(labelListTransaksi);
        panelListTransaksi.add(btnListTransaksi);


        bgPanel.add(panelDataMenu);
        bgPanel.add(panelDataKursi);
        bgPanel.add(panelDataTransaksi);
        bgPanel.add(panelDataHistory);
        bgPanel.add(panelListTransaksi);
        bgPanel.add(labelCopyright);
    }
}
