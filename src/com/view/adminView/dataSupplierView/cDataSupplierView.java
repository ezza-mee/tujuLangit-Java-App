package com.view.adminView.dataSupplierView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cDataSupplierView extends cPanelContentApp{

    private cContentAdminView parentPanel;

    // component label header Data Supplier
    private cBigFont labelHeaderDataSupplier = new cBigFont("Supplier", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // componet panel data Supplier
    private cPanelRounded panelDataSupplier = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component label data Supplier
    private cLabelInfo labelDataSupplier = new cLabelInfo("Data Supplier", 40, 30, 300, 30);

    // component button data Supplier
    private cButtonRounded btnInputDataSupplier = new cButtonRounded("input", 610, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataSupplier = new cButtonRounded("Update", 730, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataSupplier = new cButtonRounded("Delete", 850, 25, 110, 40, 10);


    public cDataSupplierView(cContentAdminView parentPanel){
        super();
        this.parentPanel = parentPanel;
        initsDataSupplierView();
    }

    private void initsDataSupplierView(){
        setVisible(true);

        btnInputDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputDataSupplierView();
            }
        });

        btnUpdateDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showUpdateDataSupplierView();
            }
        });

        btnDeleteDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDeleteDataSupplierView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        btnInputDataSupplier.setFont(cFonts.BUTTON_INPUT_FONT);
        btnUpdateDataSupplier.setFont(cFonts.BUTTON_INPUT_FONT);
        btnDeleteDataSupplier.setFont(cFonts.BUTTON_INPUT_FONT);

        panelDataSupplier.add(labelDataSupplier);

        panelDataSupplier.add(btnInputDataSupplier);
        panelDataSupplier.add(btnUpdateDataSupplier);
        panelDataSupplier.add(btnDeleteDataSupplier);

        bgPanel.add(panelDataSupplier);
        bgPanel.add(labelHeaderDataSupplier);
        bgPanel.add(labelCopyright);
    }
    
}
