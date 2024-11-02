package com.view.karyawanView.transaksiView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;
import com.view.karyawanView.cPanelContentView;

public class cInputTransaksiView extends cPanelContentApp {

    // add object cPanelContentView
    private cPanelContentView parentPanel;

    // add label header Transaksi
    private cBigFont labelHeaderTransaksi = new cBigFont("Transaksi", 40, 5);
    private cBigFont labelInputTransaksi = new cBigFont("Input Data Transaksi", 40, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // add panel Input
    private cPanelRounded panelInputTransaksi = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    public cInputTransaksiView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsInputTransaksiView();
    }

    private void initsInputTransaksiView() {
        setVisible(true);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        panelInputTransaksi.add(labelInputTransaksi);

        bgPanel.add(panelInputTransaksi);
        bgPanel.add(labelHeaderTransaksi);
        bgPanel.add(labelCopyright);
    }
}
