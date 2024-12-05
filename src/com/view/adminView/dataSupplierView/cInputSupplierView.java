package com.view.adminView.dataSupplierView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.main.database.supplier.*;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cInputSupplierView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    // component label header Input Supplier
    private cBigFont labelHeaderInputSupplier = new cBigFont("Input Data", 40, 5);
    private cBigFont labelInputSupplier = new cBigFont("Input Data Supplier", 180, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelInputSupplier = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component Input Supplier
    private cLabelInfo labelTypeSupplier = new cLabelInfo("Type Supplier", 180, 195, 300, 30);
    private cLabelInfo labelSupplierAmount = new cLabelInfo("Supplier Amount", 180, 270, 300, 30);
    private cLabelInfo labelPriceTotal = new cLabelInfo("Price Total", 580, 120, 300, 30);
    private cLabelInfo labelDescriptionProduct = new cLabelInfo("Description Product", 580, 195, 300, 30);

    // add textfield input product
    private cTextField txtTypeSupplier = new cTextField(180, 220, 300);
    private cTextField txtSupplierAmount = new cTextField(180, 295, 300);
    private cTextField txtPriceTotal = new cTextField(580, 145, 300);
    private cTextArea txtDescriptionProduct = new cTextArea(580, 220, 300, 100, true);

    // component button Input Product
    private cButtonRounded btnSaveSupplier = new cButtonRounded("Save", 780, 480, 110, 40, 10);
    private cButtonRounded btnResetSupplier = new cButtonRounded("Reset", 660, 480, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 180, 480, 110, 40, 10);

    public cInputSupplierView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsInputSupplierView();
    }

    private void initsInputSupplierView() {
        setVisible(true);

        btnSaveSupplier.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                handleInsertSupplier();
            }
        });

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataSupplierView();
            }
        });

        btnResetSupplier.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                txtTypeSupplier.setText(null);
                txtSupplierAmount.setText(null);
                txtPriceTotal.setText(null);
                txtDescriptionProduct.setText(null);
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelInputSupplier.add(labelInputSupplier);

        panelInputSupplier.add(labelTypeSupplier);
        panelInputSupplier.add(labelSupplierAmount);
        panelInputSupplier.add(labelPriceTotal);
        panelInputSupplier.add(labelDescriptionProduct);

        panelInputSupplier.add(txtTypeSupplier);
        panelInputSupplier.add(txtSupplierAmount);
        panelInputSupplier.add(txtPriceTotal);
        panelInputSupplier.add(txtDescriptionProduct);

        panelInputSupplier.add(btnSaveSupplier);
        panelInputSupplier.add(btnResetSupplier);
        panelInputSupplier.add(btnBackToHome);

        bgPanel.add(panelInputSupplier);
        bgPanel.add(labelHeaderInputSupplier);
        bgPanel.add(labelCopyright);
    }

    private void handleInsertSupplier() {
        String typeSupplier = txtTypeSupplier.getText();
        int supplierAmount = Integer.valueOf(txtSupplierAmount.getText());
        int priceTotal = Integer.valueOf(txtPriceTotal.getText());
        String descriptionProduct = txtDescriptionProduct.getText();

        boolean saveData = cInsertDataSupplier.dataSupplier(typeSupplier, supplierAmount, priceTotal,
                descriptionProduct);
        if (saveData) {
            txtTypeSupplier.setText(null);
            txtSupplierAmount.setText(null);
            txtPriceTotal.setText(null);
            txtDescriptionProduct.setText(null);
            JOptionPane.showMessageDialog(this, "SavedProduct successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to save product.");
        }

    }

}
