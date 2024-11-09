package com.view.adminView.dataProductView;

import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.database.cProductDatabase;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cInputProductView extends cPanelContentApp {

    // add object cPanelContentView
    private cContentAdminView parentPanel;

    // add label header product
    private cBigFont labelHeaderDataProduct = new cBigFont("Product", 40, 5);
    private cBigFont labelInputDataProduct = new cBigFont("Input Data Product", 180, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // add panel Input
    private cPanelRounded panelInputDataProduct = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // add label input product
    private cLabelInfo labelNameProduct = new cLabelInfo("Name Product", 180, 120, 300, 30);
    private cLabelInfo labelCountProduct = new cLabelInfo("Count Product", 180, 205, 300, 30);
    private cLabelInfo labelPriceProduct = new cLabelInfo("Price Product", 180, 290, 300, 30);
    private cLabelInfo labelStatusProduct = new cLabelInfo("Status Product", 180, 375, 300, 30);
    private cLabelInfo labelImageProduct = new cLabelInfo("Image Product", 580, 120, 300, 30);
    private cLabelInfo labelDeskripsiProduct = new cLabelInfo("Deskripsi Product", 580, 205, 300, 30);
    private cLabelInfo labelTypeProduct = new cLabelInfo("Type Product", 580, 375, 300, 30);

    // add textfield input product
    private cTextField txtNameProduct = new cTextField(180, 150, 300);
    private cTextField txtCountProduct = new cTextField(180, 235, 300);
    private cTextField txtPriceProduct = new cTextField(180, 320, 300);

    private cTextArea txtDeskripsiProduct = new cTextArea(580, 235, 300, 105, true);

    // add radion button input product
    private cRadioButton statusReadyProduct = new cRadioButton("Ready", "Active", 180, 405, 100);
    private cRadioButton statusSoldProduct = new cRadioButton("Sold", "Inactive", 320, 405, 100);
    private cRadioButton typeCoffeProduct = new cRadioButton("Coffe", "Active", 580, 405, 100);
    private cRadioButton typeFoodProduct = new cRadioButton("Drink", "Inactive", 700, 405, 100);
    private cRadioButton typeDrinkProduct = new cRadioButton("Food", "Inactive", 820, 405, 100);

    // add input image product
    JTextField inputImageProduct = new JTextField(20);
    private cImageInput imageButton = new cImageInput("Select", 580, 150, 300, 30, 10, inputImageProduct);

    // component button Input Product
    private cButtonRounded btnSaveProduct = new cButtonRounded("Save", 780, 480, 110, 40, 10);
    private cButtonRounded btnResetProduct = new cButtonRounded("Reset", 660, 480, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 180, 480, 110, 40, 10);

    cDataProductView dataProductView = new cDataProductView(parentPanel);

    public cInputProductView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        showInputProductView();
    }

    private void showInputProductView() {
        setVisible(true);

        btnSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                inputDataProduct();
            }
        });

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataProductView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        panelInputDataProduct.add(labelInputDataProduct);

        panelInputDataProduct.add(labelNameProduct);
        panelInputDataProduct.add(labelCountProduct);
        panelInputDataProduct.add(labelPriceProduct);
        panelInputDataProduct.add(labelStatusProduct);
        panelInputDataProduct.add(labelImageProduct);
        panelInputDataProduct.add(labelDeskripsiProduct);
        panelInputDataProduct.add(labelTypeProduct);

        panelInputDataProduct.add(txtNameProduct);
        panelInputDataProduct.add(txtCountProduct);
        panelInputDataProduct.add(txtPriceProduct);

        panelInputDataProduct.add(txtDeskripsiProduct);

        panelInputDataProduct.add(imageButton);

        ButtonGroup groupStatus = new ButtonGroup();
        groupStatus.add(statusReadyProduct);
        groupStatus.add(statusSoldProduct);

        ButtonGroup groupTypeProduct = new ButtonGroup();
        groupTypeProduct.add(typeCoffeProduct);
        groupTypeProduct.add(typeDrinkProduct);
        groupTypeProduct.add(typeFoodProduct);

        panelInputDataProduct.add(statusReadyProduct);
        panelInputDataProduct.add(statusSoldProduct);
        panelInputDataProduct.add(typeCoffeProduct);
        panelInputDataProduct.add(typeDrinkProduct);
        panelInputDataProduct.add(typeFoodProduct);

        panelInputDataProduct.add(btnSaveProduct);
        panelInputDataProduct.add(btnResetProduct);
        panelInputDataProduct.add(btnBackToHome);

        bgPanel.add(panelInputDataProduct);
        bgPanel.add(labelHeaderDataProduct);
        bgPanel.add(labelCopyright);

    }

    private void inputDataProduct() {
        try {
            String namaProduct = txtNameProduct.getText();
            String imageProduct = inputImageProduct.getText();
            int countProduct = Integer.valueOf(txtCountProduct.getText());
            int priceProduct = Integer.valueOf(txtPriceProduct.getText());
            String deskripsiProduct = txtDeskripsiProduct.getText();
            String typeProduct = null;
            String statusProduct = null;

            if (typeCoffeProduct.isSelected()) {
                typeProduct = "Coffe";
            } else if (typeDrinkProduct.isSelected()) {
                typeProduct = "Drink";
            } else if (typeFoodProduct.isSelected()) {
                typeProduct = "Food";
            }

            if (statusReadyProduct.isSelected()) {
                statusProduct = "Ready";
            } else if (statusSoldProduct.isSelected()) {
                statusProduct = "Sold";
            }

            boolean saveData = cProductDatabase.dataProduct(namaProduct, imageProduct, countProduct, priceProduct,
                    deskripsiProduct, typeProduct, statusProduct);
            if (saveData) {
                JOptionPane.showMessageDialog(this, "Product saved successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save product.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
