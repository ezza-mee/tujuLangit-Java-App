package com.view.adminView.dataProductView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.main.database.product.cUpdateDataProduct;
import com.main.database.product.cLoadDataProduct.Product;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cUpdateProductView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    private cBigFont labelHeaderDataProduct = new cBigFont("Data Product", 40, 5);
    private cBigFont labelUpdateDataProduct = new cBigFont("Update Data Product", 180, 20);
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2025. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelUpdateDataProduct = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    private cLabelInfo labelNameProduct = new cLabelInfo("Name Product", 180, 120, 300, 30);
    private cLabelInfo labelCountProduct = new cLabelInfo("Count Product", 180, 205, 300, 30);
    private cLabelInfo labelPriceProduct = new cLabelInfo("Price Product", 180, 290, 300, 30);
    private cLabelInfo labelStatusProduct = new cLabelInfo("Status Product", 180, 375, 300, 30);
    private cLabelInfo labelImageProduct = new cLabelInfo("Image Product", 580, 120, 300, 30);
    private cLabelInfo labelDescriptionProduct = new cLabelInfo("Description Product", 580, 205, 300, 30);
    private cLabelInfo labelTypeProduct = new cLabelInfo("Type Product", 580, 375, 300, 30);

    private cTextField txtNameProduct = new cTextField(180, 150, 300);
    private cTextField txtCountProduct = new cTextField(180, 235, 300);
    private cTextField txtPriceProduct = new cTextField(180, 320, 300);
    private cTextArea txtDescriptionProduct = new cTextArea(580, 235, 300, 105, true);

    private cRadioButton statusReadyProduct = new cRadioButton("Ready", "Active", 180, 405, 100);
    private cRadioButton statusSoldProduct = new cRadioButton("Sold", "Inactive", 320, 405, 100);
    private cRadioButton typeCoffeProduct = new cRadioButton("Coffe", "Active", 580, 405, 100);
    private cRadioButton typeDrinkProduct = new cRadioButton("Drink", "Inactive", 700, 405, 100);
    private cRadioButton typeFoodProduct = new cRadioButton("Food", "Inactive", 820, 405, 100);

    private cButtonRounded btnSaveProduct = new cButtonRounded("Save", 780, 480, 110, 40, 10);
    private cButtonRounded btnResetProduct = new cButtonRounded("Reset", 660, 480, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 180, 480, 110, 40, 10);

    private cErrorLabel errorNameProduct = new cErrorLabel("Name Product is Empty", 180, 175, 300);
    private cErrorLabel errorCountProduct = new cErrorLabel("Count Product is Empty", 180, 260, 300);
    private cErrorLabel errorPriceProduct = new cErrorLabel("Price Product is Empty", 180, 345, 300);
    private cErrorLabel errorStatusProduct = new cErrorLabel("Status Product is Empty", 180, 430, 300);
    private cErrorLabel errorImageProduct = new cErrorLabel("Image Product is Empty", 580, 175, 300);
    private cErrorLabel errorDescriptionProduct = new cErrorLabel("Description Product is Empty", 580, 345, 300);
    private cErrorLabel errorTypeProduct = new cErrorLabel("Type Product is Empty", 580, 430, 300);

    private JTextField imageUpdateField = new JTextField(20);
    private cErrorLabel pathImageProduct = new cErrorLabel("", 580, 175, 300);
    private cImageInput imageButton = new cImageInput("Select", 580, 150, 300, 30, 10, imageUpdateField,
            pathImageProduct);

    public cUpdateProductView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsUpdateProductView();
    }

    private void initsUpdateProductView() {
        setVisible(true);

        btnSaveProduct.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                handleUpdateDataProduct(idProduct);
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

        panelUpdateDataProduct.add(labelUpdateDataProduct);
        panelUpdateDataProduct.add(labelNameProduct);
        panelUpdateDataProduct.add(labelCountProduct);
        panelUpdateDataProduct.add(labelPriceProduct);
        panelUpdateDataProduct.add(labelStatusProduct);
        panelUpdateDataProduct.add(labelImageProduct);
        panelUpdateDataProduct.add(labelDescriptionProduct);
        panelUpdateDataProduct.add(labelTypeProduct);
        panelUpdateDataProduct.add(txtNameProduct);
        panelUpdateDataProduct.add(txtCountProduct);
        panelUpdateDataProduct.add(txtPriceProduct);
        panelUpdateDataProduct.add(txtDescriptionProduct);
        panelUpdateDataProduct.add(imageButton);

        ButtonGroup groupStatus = new ButtonGroup();
        groupStatus.add(statusReadyProduct);
        groupStatus.add(statusSoldProduct);

        ButtonGroup groupTypeProduct = new ButtonGroup();
        groupTypeProduct.add(typeCoffeProduct);
        groupTypeProduct.add(typeDrinkProduct);
        groupTypeProduct.add(typeFoodProduct);

        panelUpdateDataProduct.add(statusReadyProduct);
        panelUpdateDataProduct.add(statusSoldProduct);
        panelUpdateDataProduct.add(typeCoffeProduct);
        panelUpdateDataProduct.add(typeDrinkProduct);
        panelUpdateDataProduct.add(typeFoodProduct);

        panelUpdateDataProduct.add(btnSaveProduct);
        panelUpdateDataProduct.add(btnResetProduct);
        panelUpdateDataProduct.add(btnBackToHome);

        bgPanel.add(panelUpdateDataProduct);
        bgPanel.add(labelHeaderDataProduct);
        bgPanel.add(labelCopyright);
    }

    public void setProductData(Product product) {
        this.idProduct = product.getId();
        txtNameProduct.setText(product.getName());
        txtCountProduct.setText(String.valueOf(product.getCount()));
        txtPriceProduct.setText(String.valueOf(product.getPrice()));
        txtDescriptionProduct.setText(product.getDescription());

        String status = product.getStatus();
        if (status.equalsIgnoreCase("Ready")) {
            statusReadyProduct.setSelected(true);
            statusSoldProduct.setSelected(false);
        } else {
            statusReadyProduct.setSelected(false);
            statusSoldProduct.setSelected(true);
        }

        String type = product.getType();
        if (type.equalsIgnoreCase("Coffe")) {
            typeDrinkProduct.setSelected(false);
            typeFoodProduct.setSelected(false);
            typeCoffeProduct.setSelected(true);
        } else if (type.equalsIgnoreCase("Drink")) {
            typeCoffeProduct.setSelected(false);
            typeFoodProduct.setSelected(false);
            typeDrinkProduct.setSelected(true);
        } else {
            typeCoffeProduct.setSelected(false);
            typeDrinkProduct.setSelected(false);
            typeFoodProduct.setSelected(true);
        }

        byte[] imageBytes = product.getImageBytes();
        if (imageBytes != null && imageBytes.length > 0) {
            try {
                String fileExtension = (imageBytes[0] == (byte) 0xFF && imageBytes[1] == (byte) 0xD8) ? ".jpg" : ".png";
                File tempFile = File.createTempFile("product_image_", fileExtension);

                try (FileOutputStream fos = new FileOutputStream(tempFile)) {
                    fos.write(imageBytes);
                }

                String imageFilePath = tempFile.getAbsolutePath();
                imageUpdateField.setText(imageFilePath);
                pathImageProduct.setText("Selected Path: " + imageFilePath);

                panelUpdateDataProduct.add(pathImageProduct);
            } catch (IOException e) {
                e.printStackTrace();
                imageUpdateField.setText("Error loading image");
                pathImageProduct.setText("Error loading image");
            }
        } else {
            imageUpdateField.setText("No image available");
            pathImageProduct.setText("No image available");
        }

    }

    private int idProduct;

    private void handleUpdateDataProduct(int idProduct) {
        try {
            String nameProduct = txtNameProduct.getText().trim();
            String imageProduct = imageUpdateField.getText().trim();
            String countProductText = txtCountProduct.getText().trim();
            String priceProductText = txtPriceProduct.getText().trim();
            String descriptionProduct = txtDescriptionProduct.getText().trim();
            String typeProduct = null;
            String statusProduct = null;

            if (nameProduct.isEmpty() || countProductText.isEmpty() || priceProductText.isEmpty() ||
                    descriptionProduct.isEmpty() || imageProduct.isEmpty() ||
                    (!typeCoffeProduct.isSelected() && !typeDrinkProduct.isSelected() && !typeFoodProduct.isSelected())
                    ||
                    (!statusReadyProduct.isSelected() && !statusSoldProduct.isSelected())) {

                if (nameProduct.isEmpty())
                    panelUpdateDataProduct.add(errorNameProduct);
                else
                    panelUpdateDataProduct.remove(errorNameProduct);

                if (countProductText.isEmpty())
                    panelUpdateDataProduct.add(errorCountProduct);
                else
                    panelUpdateDataProduct.remove(errorCountProduct);

                if (priceProductText.isEmpty())
                    panelUpdateDataProduct.add(errorPriceProduct);
                else
                    panelUpdateDataProduct.remove(errorPriceProduct);

                if (descriptionProduct.isEmpty())
                    panelUpdateDataProduct.add(errorDescriptionProduct);
                else
                    panelUpdateDataProduct.remove(errorDescriptionProduct);

                if (imageProduct.isEmpty())
                    panelUpdateDataProduct.add(errorImageProduct);
                else
                    panelUpdateDataProduct.remove(errorImageProduct);

                if (!typeCoffeProduct.isSelected() && !typeDrinkProduct.isSelected() && !typeFoodProduct.isSelected()) {
                    panelUpdateDataProduct.add(errorTypeProduct);
                } else {
                    panelUpdateDataProduct.remove(errorTypeProduct);
                }

                if (!statusReadyProduct.isSelected() && !statusSoldProduct.isSelected()) {
                    panelUpdateDataProduct.add(errorStatusProduct);
                } else {
                    panelUpdateDataProduct.remove(errorStatusProduct);
                }

                panelUpdateDataProduct.revalidate();
                panelUpdateDataProduct.repaint();
                return;
            }

            int countProduct = Integer.parseInt(countProductText);
            int priceProduct = Integer.parseInt(priceProductText);

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

            boolean updateProduct = cUpdateDataProduct.handleUpdate(idProduct, nameProduct, imageProduct, countProduct,
                    priceProduct, descriptionProduct, typeProduct, statusProduct);

            if (updateProduct) {
                JOptionPane.showMessageDialog(this, "Product updated successfully!");
                parentPanel.showDataProductView();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update product.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred during the update process.");
        }
    }

}
