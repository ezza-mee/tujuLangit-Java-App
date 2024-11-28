package com.view.adminView.dataSupplierView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cUpdateSupplierView extends cPanelContentApp {
    
    private cContentAdminView parentPanel;

    // component label header Update Supplier
    private cBigFont labelHeaderUpdateSupplier = new cBigFont("Update Data", 40, 5);
    private cBigFont labelUpdateSupplier = new cBigFont("Update Data Supplier", 180, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelUpdateSupplier = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component Update Supplier
    private cLabelInfo labelNameCompany = new cLabelInfo("Name Company", 180, 120, 300, 30);
    private cLabelInfo labelTypeSupplier = new cLabelInfo("Type Supplier", 180, 195, 300, 30);
    private cLabelInfo labelSupplierAmount = new cLabelInfo("Supplier Amount", 180, 270, 300, 30);
    private cLabelInfo labelPriceTotal = new cLabelInfo("Price Total", 580, 120, 300, 30);
    private cLabelInfo labelDescriptionProduct = new cLabelInfo("Description Product", 580, 195, 300, 30);

    // add textfield Update product
    private cTextField txtNameCompany = new cTextField(180, 145, 300);
    private cTextField txtTypeSupplier = new cTextField(180, 220, 300);
    private cTextField txtSupplierAmount = new cTextField(180, 295, 300);
    private cTextField txtPriceTotal = new cTextField(580, 145, 300);
    private cTextArea txtDescriptionProduct = new cTextArea(580, 220, 300, 100, true);

    // component button Update Product
    private cButtonRounded btnSaveSupplier = new cButtonRounded("Save", 780, 480, 110, 40, 10);
    private cButtonRounded btnResetSupplier = new cButtonRounded("Reset", 660, 480, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 180, 480, 110, 40, 10);

    public cUpdateSupplierView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsUpdateSupplierView();
    }

    private void initsUpdateSupplierView() {
        setVisible(true);

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataSupplierView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelUpdateSupplier.add(labelUpdateSupplier);

        panelUpdateSupplier.add(labelNameCompany);
        panelUpdateSupplier.add(labelTypeSupplier);
        panelUpdateSupplier.add(labelSupplierAmount);
        panelUpdateSupplier.add(labelPriceTotal);
        panelUpdateSupplier.add(labelDescriptionProduct);

        panelUpdateSupplier.add(txtNameCompany);
        panelUpdateSupplier.add(txtTypeSupplier);
        panelUpdateSupplier.add(txtSupplierAmount);
        panelUpdateSupplier.add(txtPriceTotal);
        panelUpdateSupplier.add(txtDescriptionProduct);

        panelUpdateSupplier.add(btnSaveSupplier);
        panelUpdateSupplier.add(btnResetSupplier);
        panelUpdateSupplier.add(btnBackToHome);

        bgPanel.add(panelUpdateSupplier);
        bgPanel.add(labelHeaderUpdateSupplier);
        bgPanel.add(labelCopyright);
    }
}
