package com.view.adminView.dataKaryawanView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;
import com.view.adminView.cPanelContentView;

public class cDeleteKaryawanView extends cPanelContentApp {

    private cPanelContentView parentPanel;

    // add label header Karyawan
    private cBigFont labelHeaderKaryawan = new cBigFont("Staff", 40, 5);
    private cBigFont labelDeleteKaryawan = new cBigFont("Delete Data Staff", 40, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component panel Data Karyawan
    private cPanelRounded panelDataKaryawan = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component button delete Karyawan
    private cButtonRounded btnDeleteKaryawan = new cButtonRounded("Delete", 660, 460, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 780, 460, 110, 40, 10);

    public cDeleteKaryawanView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsDeleteKaryawanView();
    }

    private void initsDeleteKaryawanView() {
        setVisible(true);

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataKaryawanView();
            }
        });

        btnDeleteKaryawan.setFont(cFonts.BUTTON_INPUT_FONT);
        btnBackToHome.setFont(cFonts.BUTTON_INPUT_FONT);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        panelDataKaryawan.add(labelDeleteKaryawan);

        panelDataKaryawan.add(btnDeleteKaryawan);
        panelDataKaryawan.add(btnBackToHome);

        bgPanel.add(panelDataKaryawan);
        bgPanel.add(labelHeaderKaryawan);
        bgPanel.add(labelCopyright);
    }

}
