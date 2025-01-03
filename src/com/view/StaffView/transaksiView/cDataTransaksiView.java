package com.view.StaffView.transaksiView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.*;

public class cDataTransaksiView extends cPanelContentApp {

    // add object cPanelContentView
    private cContentStaffView parentPanel;

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
    private cButtonRounded btnInputDataTransaksi = new cButtonRounded("Input", 210, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataTransaksi = new cButtonRounded("Update", 330, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataTransaksi = new cButtonRounded("Delete", 450, 25, 110, 40, 10);

    public cDataTransaksiView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsDataTransaksiView();
    }

    public void initsDataTransaksiView() {
        setVisible(true);

        btnInputDataTransaksi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputTransaksiView();
            }
        });

        btnUpdateDataTransaksi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showUpdateTransaksiView();
            }
        });

        btnDeleteDataTransaksi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDeleteTransaksiView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        btnInputDataTransaksi.setFont(cFonts.FONT_SIZE_13);
        btnUpdateDataTransaksi.setFont(cFonts.FONT_SIZE_13);
        btnDeleteDataTransaksi.setFont(cFonts.FONT_SIZE_13);

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
