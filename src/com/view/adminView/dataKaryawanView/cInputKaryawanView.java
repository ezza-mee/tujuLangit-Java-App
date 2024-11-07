package com.view.adminView.dataKaryawanView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;
import com.view.adminView.cPanelContentView;

public class cInputKaryawanView extends cPanelContentApp {

    private cPanelContentView parentPanel;

    // component label header Data Karyawan
    private cBigFont labelHeaderDataKaryawan = new cBigFont("Stafff", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component panel Data karyawan 
    private cPanelRounded panelInputKaryawan = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component label Data Karyawan 
    private cLabelInfo labelNameKaryawan = new cLabelInfo("Name Karyawan", 180, 120, 300, 30);
    private cLabelInfo labelAgeKaryawan = new cLabelInfo("Count Karyawan", 180, 195, 300, 30);
    private cLabelInfo labelLocationKaryawan = new cLabelInfo("Price Karyawan", 180, 270, 300, 30);
    private cLabelInfo labelJobdeskKaryawan = new cLabelInfo("Deskripsi Karyawan", 580, 120, 300, 30);
    private cLabelInfo labelStatusKaryawan = new cLabelInfo("Status Product", 180, 345, 300, 30);

    public cInputKaryawanView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsInputKaryawan();
    }

    private void initsInputKaryawan() {
        setVisible(true);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        bgPanel.add(labelHeaderDataKaryawan);
        bgPanel.add(labelCopyright);
    }

}
