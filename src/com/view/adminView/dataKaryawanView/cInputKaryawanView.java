package com.view.adminView.dataKaryawanView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;
import com.view.adminView.cPanelContentView;

public class cInputKaryawanView extends cPanelContentApp {

    private cPanelContentView parentPanel;

    // component label header Data Karyawan
    private cBigFont labelHeaderDataKaryawan = new cBigFont("Product", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component input data karyawan

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
