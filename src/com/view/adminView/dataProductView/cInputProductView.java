package com.view.adminView.dataProductView;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.main.database.product.cInsertDataProduct;
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
    private cLabelInfo labelDescriptionProduct = new cLabelInfo("Description Product", 580, 205, 300, 30);
    private cLabelInfo labelTypeProduct = new cLabelInfo("Type Product", 580, 375, 300, 30);

    // add textfield input product
    private cTextField txtNameProduct = new cTextField(180, 150, 300);
    private cTextField txtCountProduct = new cTextField(180, 235, 300);
    private cTextField txtPriceProduct = new cTextField(180, 320, 300);

    private cTextArea txtDescriptionProduct = new cTextArea(580, 235, 300, 115, true);

    // add radion button input product
    private cRadioButton statusReadyProduct = new cRadioButton("Ready", "Active", 180, 405, 100);
    private cRadioButton statusSoldProduct = new cRadioButton("Sold", "Inactive", 320, 405, 100);
    private cRadioButton typeCoffeProduct = new cRadioButton("Coffe", "Active", 580, 405, 100);
    private cRadioButton typeFoodProduct = new cRadioButton("Drink", "Inactive", 700, 405, 100);
    private cRadioButton typeDrinkProduct = new cRadioButton("Food", "Inactive", 820, 405, 100);

    // component button Input Product
    private cButtonRounded btnSaveProduct = new cButtonRounded("Save", 780, 480, 110, 40, 10);
    private cButtonRounded btnResetProduct = new cButtonRounded("Reset", 660, 480, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 180, 480, 110, 40, 10);

    // component error label input product
    private cErrorLabel errorNameProduct = new cErrorLabel("Name Product is Empty", 180, 175, 300);
    private cErrorLabel errorCountProduct = new cErrorLabel("Count Product is Empty", 180, 260, 300);
    private cErrorLabel errorPriceProduct = new cErrorLabel("Price Product is Empty", 180, 345, 300);
    private cErrorLabel errorStatusProduct = new cErrorLabel("Status Product is Empty", 180, 430, 300);
    private cErrorLabel errorImageProduct = new cErrorLabel("Image Product is Empty", 580, 175, 300);
    private cErrorLabel errorDescriptionProduct = new cErrorLabel("Description Product is Empty", 580, 345, 300);
    private cErrorLabel errorTypeProduct = new cErrorLabel("Type Product is Empty", 580, 430, 300);

    // add input image product
    private JTextField imageInputField = new JTextField(20);
    private cErrorLabel pathImageProduct = new cErrorLabel("", 580, 175, 300);
    private cImageInput imageButton = new cImageInput("Select", 580, 150, 300, 30, 10, imageInputField,
            pathImageProduct);

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
                handleInsertDataProduct();
            }
        });

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataProductView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelInputDataProduct.add(labelInputDataProduct);

        panelInputDataProduct.add(labelNameProduct);
        panelInputDataProduct.add(labelCountProduct);
        panelInputDataProduct.add(labelPriceProduct);
        panelInputDataProduct.add(labelStatusProduct);
        panelInputDataProduct.add(labelImageProduct);
        panelInputDataProduct.add(labelDescriptionProduct);
        panelInputDataProduct.add(labelTypeProduct);

        panelInputDataProduct.add(txtNameProduct);
        panelInputDataProduct.add(txtCountProduct);
        panelInputDataProduct.add(txtPriceProduct);

        panelInputDataProduct.add(txtDescriptionProduct);

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
        panelInputDataProduct.add(pathImageProduct);

        panelInputDataProduct.add(btnSaveProduct);
        panelInputDataProduct.add(btnResetProduct);
        panelInputDataProduct.add(btnBackToHome);

        bgPanel.add(panelInputDataProduct);
        bgPanel.add(labelHeaderDataProduct);
        bgPanel.add(labelCopyright);

    }

    private void handleInsertDataProduct() {
        try {
            String nameProduct = txtNameProduct.getText().trim();
            String imageProduct = imageInputField.getText().trim();
            String countProductText = txtCountProduct.getText().trim();
            String priceProductText = txtPriceProduct.getText().trim();
            String DescriptionProduct = txtDescriptionProduct.getText().trim();
            String typeProduct = null;
            String statusProduct = null;

            if (nameProduct.isEmpty() || countProductText.isEmpty() || priceProductText.isEmpty() ||
                    DescriptionProduct.isEmpty() || imageProduct.isEmpty() ||
                    (!typeCoffeProduct.isSelected() && !typeDrinkProduct.isSelected() && !typeFoodProduct.isSelected())
                    ||
                    (!statusReadyProduct.isSelected() && !statusSoldProduct.isSelected())) {
                if (nameProduct.isEmpty()) {
                    panelInputDataProduct.add(errorNameProduct);
                } else {
                    panelInputDataProduct.remove(errorNameProduct);
                }
                if (countProductText.isEmpty()) {
                    panelInputDataProduct.add(errorCountProduct);
                } else {
                    panelInputDataProduct.remove(errorCountProduct);
                }

                if (priceProductText.isEmpty()) {
                    panelInputDataProduct.add(errorPriceProduct);
                } else {
                    panelInputDataProduct.remove(errorPriceProduct);
                }

                if (DescriptionProduct.isEmpty()) {
                    panelInputDataProduct.add(errorDescriptionProduct);
                } else {
                    panelInputDataProduct.remove(errorDescriptionProduct);
                }

                if (imageProduct.isEmpty()) {
                    panelInputDataProduct.add(errorImageProduct);
                } else {
                    panelInputDataProduct.remove(errorImageProduct);
                }

                if (!typeCoffeProduct.isSelected() && !typeDrinkProduct.isSelected() && !typeFoodProduct.isSelected()) {
                    panelInputDataProduct.add(errorTypeProduct);
                } else {
                    panelInputDataProduct.remove(errorTypeProduct);
                }

                if (!statusReadyProduct.isSelected() && !statusSoldProduct.isSelected()) {
                    panelInputDataProduct.add(errorStatusProduct);
                } else {
                    panelInputDataProduct.remove(errorStatusProduct);
                }

                panelInputDataProduct.revalidate();
                panelInputDataProduct.repaint();

                return;
            }

            int countProduct = 0;
            int priceProduct = 0;

            countProduct = Integer.parseInt(countProductText);
            priceProduct = Integer.parseInt(priceProductText);

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

            boolean saveData = cInsertDataProduct.dataProduct(nameProduct, imageProduct, countProduct, priceProduct,
                    DescriptionProduct, typeProduct, statusProduct);
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
