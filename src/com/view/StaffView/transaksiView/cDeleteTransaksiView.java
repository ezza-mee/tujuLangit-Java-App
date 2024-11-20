package com.view.StaffView.transaksiView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.*;

public class cDeleteTransaksiView extends cPanelContentApp {

    // add object cPanelContentView
    private cContentStaffView parentPanel;

    // add label header Transaksi
    private cBigFont labelHeaderTransaksi = new cBigFont("Transaksi", 40, 5);
    private cBigFont labelDeleteTransaksi = new cBigFont("Delete Data Transaksi", 40, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component panel Data transaksi
    private cPanelRounded panelDataTransaksi = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component button delete Transaksi
    private cButtonRounded btnDeleteTransaksi = new cButtonRounded("Delete", 660, 460, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 780, 460, 110, 40, 10);

    public cDeleteTransaksiView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsDeleteTransaksiView();
    }

    private void initsDeleteTransaksiView() {
        setVisible(true);

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataTransaksiView();
            }
        });

        btnDeleteTransaksi.setFont(cFonts.FONT_SIZE_13);
        btnBackToHome.setFont(cFonts.FONT_SIZE_13);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelDataTransaksi.add(labelDeleteTransaksi);

        panelDataTransaksi.add(btnDeleteTransaksi);
        panelDataTransaksi.add(btnBackToHome);

        bgPanel.add(panelDataTransaksi);
        bgPanel.add(labelHeaderTransaksi);
        bgPanel.add(labelCopyright);

    }

}
