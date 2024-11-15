package com.view.adminView.dataSupplierView;

import javax.swing.JLabel;

import com.main.database.supplier.cDataSupplier;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cDataSupplierView extends cPanelContentApp{

    private cContentAdminView parentPanel;

    // component label header Data Supplier
    private cBigFont labelHeaderDataSupplier = new cBigFont("Supplier", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component panel data Supplier
    private cPanelRounded panelDataSupplier = new cPanelRounded(40, 80, 1050, 560, 10, 10);
    private cPanelRounded panelTableSupplier = new cPanelRounded(0, 80, 1050, 560, 10, 10);

    // component label data Supplier
    private cLabelInfo labelDataSupplier = new cLabelInfo("Data Supplier", 40, 30, 300, 30);

    // component button data Supplier
    private cButtonRounded btnInputDataSupplier = new cButtonRounded("input", 610, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataSupplier = new cButtonRounded("Update", 730, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataSupplier = new cButtonRounded("Delete", 850, 25, 110, 40, 10);

    // component tabel data supplier
    private cTable tblDataSupplier;
    private cScrollTable spDataSupplier;


    public cDataSupplierView(cContentAdminView parentPanel){
        super();
        this.parentPanel = parentPanel;
        initsDataSupplierView();
    }

    public void refreshContent(){
        try {
            panelTableSupplier.removeAll();
            panelTableSupplier.revalidate();
            panelTableSupplier.repaint();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initsDataSupplierView(){
        refreshContent();
        

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

        tblDataSupplier = new cTable(cDataSupplier.getAllSupplier());
        spDataSupplier = new cScrollTable(tblDataSupplier, 0, 10, 1050, 400);
        
        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        btnInputDataSupplier.setFont(cFonts.FONT_SIZE_13);
        btnUpdateDataSupplier.setFont(cFonts.FONT_SIZE_13);
        btnDeleteDataSupplier.setFont(cFonts.FONT_SIZE_13);

        panelDataSupplier.add(labelDataSupplier);

        panelDataSupplier.add(btnInputDataSupplier);
        panelDataSupplier.add(btnUpdateDataSupplier);
        panelDataSupplier.add(btnDeleteDataSupplier);

        panelTableSupplier.add(spDataSupplier);
        panelDataSupplier.add(panelTableSupplier);

        bgPanel.add(panelDataSupplier);
        bgPanel.add(labelHeaderDataSupplier);
        bgPanel.add(labelCopyright);

        setVisible(true);
    }
    
}
