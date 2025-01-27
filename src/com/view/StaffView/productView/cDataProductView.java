package com.view.staffView.productView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.main.database.product.cLoadDataProduct;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.*;

public class cDataProductView extends cPanelContentApp {

    private cContentStaffView parentPanel;
    private JPanel cardContainer;

    // component label header Data Product
    private cBigFont labelHeaderDataProduct = new cBigFont("Product", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2025. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component Data Product
    private cPanelRounded panelListProduct = new cPanelRounded(40, 80, 1050, 560, 10, 10);
    private cPanelRounded panelProduct = new cPanelRounded(0, 130, 1050, 430, 0, 0);

    // component label data Product
    private cLabelInfo labelListDataProduct = new cLabelInfo("List Data Product", 30, 30, 580, 30);

    public cDataProductView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsDataMenuView();
    }

    public void refreshContent() {
        try {
            panelProduct.removeAll();
            panelProduct.revalidate();
            panelProduct.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initsDataMenuView() {
        setVisible(true);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelListProduct.add(labelListDataProduct);
        panelListProduct.add(panelProduct);

        bgPanel.add(labelHeaderDataProduct);
        bgPanel.add(panelListProduct);
        bgPanel.add(labelCopyright);

        loadDataProducts();
        setVisible(true);
    }

    private JPanel createProductCard(int idProduct, String nameProduct, byte[] imageBytes, String countProduct,
            String priceProduct,
            String descriptionProduct, String status, String type) {
        cPanelRounded cardPanel = new cPanelRounded(0, 0, 220, 350, 10, 10);
        cardPanel.setLayout(null);
        cardPanel.setPreferredSize(new Dimension(220, 350));
        cardPanel.setBackground(cColor.WHITE);

        cPanelRounded panelLabel = new cPanelRounded(0, 185, 290, 165, 10, 10);
        panelLabel.setLayout(null);

        cLabelInfo productName = new cLabelInfo(nameProduct, 12, 5, 200, 30);
        cLabelInfo productCount = new cLabelInfo(countProduct, 12, 90, 200, 30);
        cLabelInfo lineProduct = new cLabelInfo("Pcs", 80, 90, 40, 30);
        cLabelInfo labelCurrency = new cLabelInfo("Rp.", 12, 120, 40, 30);
        cLabelInfo productPrice = new cLabelInfo(priceProduct, 50, 120, 200, 30);

        cTextArea productDescription = new cTextArea(12, 40, 240, 40, false);
        productDescription.setText(descriptionProduct);
        productDescription.setBorder(new javax.swing.border.LineBorder(cColor.GREEN, 0));
        productDescription.setFont(cFonts.FONT_SIZE_8);

        panelLabel.add(productName);
        panelLabel.add(productCount);
        panelLabel.add(lineProduct);
        panelLabel.add(labelCurrency);
        panelLabel.add(productPrice);
        panelLabel.add(productDescription);

        cPanelRounded panelImage = new cPanelRounded();
        panelImage.setLayout(null);
        panelImage.setBounds(12, 12, 267, 170);
        panelImage.setBackground(cColor.GREY);

        ImageIcon productImage = new ImageIcon(imageBytes);
        Image scaledImage = productImage.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        imageLabel.setBounds(0, 0, 267, 170);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        panelImage.add(imageLabel);

        cardPanel.add(panelImage);
        cardPanel.add(panelLabel);

        return cardPanel;
    }

    public void loadDataProducts() {
        refreshContent();
        cLoadDataProduct dataProductLoader = new cLoadDataProduct();
        List<cLoadDataProduct.Product> products = dataProductLoader.loadProducts();

        cardContainer = new JPanel(new GridLayout(0, 3, 40, 40)); 
        cardContainer.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        cardContainer.setBackground(cColor.WHITE);

        for (cLoadDataProduct.Product product : products) {
            JPanel productCard = createProductCard(
                    product.getId(),
                    product.getName(),
                    product.getImageBytes(),
                    String.valueOf(product.getCount()),
                    String.valueOf(product.getPrice()),
                    product.getDescription(),
                    product.getType(),
                    product.getStatus());
            cardContainer.add(productCard);
        }

        cScrollPane scrollPanel = new cScrollPane(cardContainer, 0, 0, 1050, 430);
        scrollPanel.getVerticalScrollBar().setUnitIncrement(10);
        scrollPanel.setBackground(cColor.WHITE);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panelProduct.setLayout(new BorderLayout());
        panelProduct.add(scrollPanel, BorderLayout.CENTER);
        panelProduct.revalidate();
        panelProduct.repaint();
    }

}
