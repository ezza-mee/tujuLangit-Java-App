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
    private cLabelInfo labelTypeSupplier = new cLabelInfo("Type Supplier", 180, 120, 300, 30);
    private cLabelInfo labelSupplierAmount = new cLabelInfo("Supplier Amount", 180, 195, 300, 30);
    private cLabelInfo labelPriceSupplier = new cLabelInfo("Price Supplier", 580, 120, 300, 30);
    private cLabelInfo labelDescriptionSupplier = new cLabelInfo("Description Supplier", 580, 195, 300, 30);

    // add textfield input Supplier
    private cTextField txtTypeSupplier = new cTextField(180, 145, 300);
    private cTextField txtSupplierAmount = new cTextField(180, 220, 300);
    private cTextField txtPriceSupplier = new cTextField(580, 145, 300);
    private cTextArea txtDescriptionSupplier = new cTextArea(580, 220, 300, 100, true);

    // component button Input Supplier
    private cButtonRounded btnSaveSupplier = new cButtonRounded("Save", 780, 480, 110, 40, 10);
    private cButtonRounded btnResetSupplier = new cButtonRounded("Reset", 660, 480, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 180, 480, 110, 40, 10);

    // component label error Supplier
    private cErrorLabel errorTypeSupplier = new cErrorLabel("Type Supplier is Empty", 180, 170, 300);
    private cErrorLabel errorCountSupplier = new cErrorLabel("Count Supplier is Empty", 180, 245, 300);
    private cErrorLabel errorPriceSupplier = new cErrorLabel("Price Supplier is Empty", 580, 170, 300);
    private cErrorLabel errorDescriptionSupplier = new cErrorLabel("Description Supplier is Empty", 580, 315, 300);

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
                txtPriceSupplier.setText(null);
                txtDescriptionSupplier.setText(null);
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelInputSupplier.add(labelInputSupplier);

        panelInputSupplier.add(labelTypeSupplier);
        panelInputSupplier.add(labelSupplierAmount);
        panelInputSupplier.add(labelPriceSupplier);
        panelInputSupplier.add(labelDescriptionSupplier);

        panelInputSupplier.add(txtTypeSupplier);
        panelInputSupplier.add(txtSupplierAmount);
        panelInputSupplier.add(txtPriceSupplier);
        panelInputSupplier.add(txtDescriptionSupplier);

        panelInputSupplier.add(btnSaveSupplier);
        panelInputSupplier.add(btnResetSupplier);
        panelInputSupplier.add(btnBackToHome);

        bgPanel.add(panelInputSupplier);
        bgPanel.add(labelHeaderInputSupplier);
        bgPanel.add(labelCopyright);
    }

    private void handleInsertSupplier() {
        String typeSupplier = txtTypeSupplier.getText();
        String supplierAmount = txtSupplierAmount.getText();
        String priceSupplier = txtPriceSupplier.getText();
        String descriptionSupplier = txtDescriptionSupplier.getText();

        if (typeSupplier.isEmpty() || supplierAmount.isEmpty() || priceSupplier.isEmpty() ||
                descriptionSupplier.isEmpty()) {
            if (typeSupplier.isEmpty()) {
                panelInputSupplier.add(errorTypeSupplier);
            } else {
                panelInputSupplier.remove(errorTypeSupplier);
            }
            if (supplierAmount.isEmpty()) {
                panelInputSupplier.add(errorCountSupplier);
            } else {
                panelInputSupplier.remove(errorCountSupplier);
            }

            if (priceSupplier.isEmpty()) {
                panelInputSupplier.add(errorPriceSupplier);
            } else {
                panelInputSupplier.remove(errorPriceSupplier);
            }

            if (descriptionSupplier.isEmpty()) {
                panelInputSupplier.add(errorDescriptionSupplier);
            } else {
                panelInputSupplier.remove(errorDescriptionSupplier);
            }

            panelInputSupplier.revalidate();
            panelInputSupplier.repaint();

            return;
        }

        int countSupplierText = 0;
        int priceSupplierText = 0;

        countSupplierText = Integer.parseInt(supplierAmount);
        priceSupplierText = Integer.parseInt(priceSupplier);

        boolean saveData = cInsertDataSupplier.dataSupplier(typeSupplier, countSupplierText, priceSupplierText,
                descriptionSupplier);
        if (saveData) {
            txtTypeSupplier.setText(null);
            txtSupplierAmount.setText(null);
            txtPriceSupplier.setText(null);
            txtDescriptionSupplier.setText(null);
            JOptionPane.showMessageDialog(this, "SavedSupplier successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to save Supplier.");
        }

    }

}
