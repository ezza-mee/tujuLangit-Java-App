package com.view.adminView.dataKaryawanView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;
import com.view.adminView.cPanelContentView;

public class cDataKaryawanView extends cPanelContentApp {

    private cPanelContentView parentPanel;

    // component label header Data Karyawan
    private cBigFont labelHeaderDataKaryawan = new cBigFont("Staff", 40, 5);
    

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // componet panel data karyawan
    private cPanelRounded panelDataKaryawan = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component label data karyawan
    private cLabelInfo labelDataKaryawan = new cLabelInfo("Data Karyawan", 40, 30, 300, 30);

    // component button data karyawan
    private cButtonRounded btnInputDataKaryawan = new cButtonRounded("input", 610, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataKaryawan = new cButtonRounded("Update", 730, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataKaryawan = new cButtonRounded("Delete", 850, 25, 110, 40, 10);

    public cDataKaryawanView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsDataKaryawanView();
    }

    private void initsDataKaryawanView() {
        setVisible(true);

        btnInputDataKaryawan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputDataKaryawanView();
            }
        });

        btnUpdateDataKaryawan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showUpdateDataKaryawanView();
            }
        });

        btnDeleteDataKaryawan.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDeleteDataKaryawanView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        btnInputDataKaryawan.setFont(cFonts.BUTTON_INPUT_FONT);
        btnUpdateDataKaryawan.setFont(cFonts.BUTTON_INPUT_FONT);
        btnDeleteDataKaryawan.setFont(cFonts.BUTTON_INPUT_FONT);

        panelDataKaryawan.add(labelDataKaryawan);

        panelDataKaryawan.add(btnInputDataKaryawan);
        panelDataKaryawan.add(btnUpdateDataKaryawan);
        panelDataKaryawan.add(btnDeleteDataKaryawan);

        bgPanel.add(panelDataKaryawan);
        bgPanel.add(labelHeaderDataKaryawan);
        bgPanel.add(labelCopyright);
    }
}
