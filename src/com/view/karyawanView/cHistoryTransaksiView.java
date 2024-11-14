package com.view.karyawanView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;

public class cHistoryTransaksiView extends cPanelContentApp {

    // component History transaksi
    private cBigFont labelHeaderHistoryTransaksi = new cBigFont("History Transaksi", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component panel history transaksi
    private cPanelRounded panelDataHistory = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component label history transaksi
    private cLabelInfo labelListHistory = new cLabelInfo("List Hitory Pesanan", 30, 20, 300, 30);

    public cHistoryTransaksiView() {
        super();
        initsHistoryTransaksiView();
    }

    public void initsHistoryTransaksiView() {
        setVisible(true);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelDataHistory.add(labelListHistory);

        bgPanel.add(panelDataHistory);
        bgPanel.add(labelHeaderHistoryTransaksi);
        bgPanel.add(labelCopyright);
    }
}
