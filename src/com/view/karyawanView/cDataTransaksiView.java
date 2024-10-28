package com.view.karyawanView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;

public class cDataTransaksiView extends cPanelContentApp {

    // ini adalah component data transaksi
    private cBigFont labelHeaderDataTransaksi = new cBigFont("Data Transaksi", 40, 5);

    // ini adalah component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // ini adalah component data transaksi
    private cPanelRounded panelListTransaksi = new cPanelRounded(40, 80, 600, 560, 10, 10);
    private cPanelRounded panelDoneTransaksi = new cPanelRounded(660, 80, 430, 560, 10, 10);

    // ini adalah component label data transaksi
    private cLabelInfo labelDataTransaksi = new cLabelInfo("List Transaksi", 30, 30, 600, 40);
    private cLabelInfo labelStatusTransaksi = new cLabelInfo("Status", 30, 30, 430, 30);

    // ini adalah component button data transaksi
    private cButtonLogin btnInputDataTransaksi = new cButtonLogin("input", 210, 25, 110, 40, 10);
    private cButtonLogin btnUpdateDataTransaksi = new cButtonLogin("Update", 330, 25, 110, 40, 10);
    private cButtonLogin btnDeleteDataTransaksi = new cButtonLogin("Delete", 450, 25, 110, 40, 10);

    public cDataTransaksiView() {
        super();
        initsDataTransaksiView();
    }

    public void initsDataTransaksiView() {
        setVisible(true);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        btnInputDataTransaksi.setFont(cFonts.BUTTON_INPUT_FONT);
        btnUpdateDataTransaksi.setFont(cFonts.BUTTON_INPUT_FONT);
        btnDeleteDataTransaksi.setFont(cFonts.BUTTON_INPUT_FONT);

        panelListTransaksi.add(labelDataTransaksi);
        panelListTransaksi.add(btnInputDataTransaksi);
        panelListTransaksi.add(btnUpdateDataTransaksi);
        panelListTransaksi.add(btnDeleteDataTransaksi);

        panelDoneTransaksi.add(labelStatusTransaksi);

        bgPanel.add(panelListTransaksi);
        bgPanel.add(panelDoneTransaksi);
        bgPanel.add(labelHeaderDataTransaksi);
        bgPanel.add(labelCopyright);
    }
}
