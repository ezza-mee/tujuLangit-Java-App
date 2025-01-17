package com.view.adminView.dataSupplierView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cDeleteSupplierView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    // add label header supplier
    private cBigFont labelHeaderDataSupplier = new cBigFont("Data Supplier", 40, 5);
    private cBigFont labelDeleteDataSupplier = new cBigFont("Delete Data Supplier", 40, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2025. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelDataSupplier = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component button delete Supplier
    private cButtonRounded btnDeleteSupplier = new cButtonRounded("Delete", 660, 460, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 780, 460, 110, 40, 10);

    public cDeleteSupplierView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsDeleteKaryawanView();
    }

    private void initsDeleteKaryawanView() {
        setVisible(true);

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataSupplierView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelDataSupplier.add(labelDeleteDataSupplier);

        panelDataSupplier.add(btnDeleteSupplier);
        panelDataSupplier.add(btnBackToHome);

        bgPanel.add(labelHeaderDataSupplier);
        bgPanel.add(labelCopyright);
        bgPanel.add(panelDataSupplier);
    }

}
