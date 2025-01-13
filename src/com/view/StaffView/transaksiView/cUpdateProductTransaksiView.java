package com.view.StaffView.transaksiView;

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

public class cUpdateProductTransaksiView extends cPanelContentApp {

    private cContentStaffView parentPanel;
    private JPanel cardContainer;

    // component label header Data Product
    private cBigFont labelHeaderDataProduct = new cBigFont("Product", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component Data Product
    private cPanelRounded panelListProduct = new cPanelRounded(40, 80, 1050, 560, 10, 10);
    private cPanelRounded panelProduct = new cPanelRounded(0, 130, 1050, 430, 0, 0);

    // component label data Product
    private cLabelInfo labelListDataProduct = new cLabelInfo("List Data Product", 30, 30, 580, 30);

    // component button data product transaksi
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 900, 20, 110, 40, 10);

    private cUpdateTransaksiView updateTransaksiView;

    public cUpdateProductTransaksiView(cContentStaffView parentPanel, cUpdateTransaksiView updateTransaksiView) {
        super();
        this.parentPanel = parentPanel;
        this.updateTransaksiView = updateTransaksiView;

        initsDataTransaksiProductView();
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

    public void initsDataTransaksiProductView() {
        setVisible(true);

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showTransaksiUpdateView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelListProduct.add(labelListDataProduct);
        panelListProduct.add(panelProduct);
        panelListProduct.add(btnBackToHome);

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
        cLabelInfo productCount = new cLabelInfo(countProduct, 180, 85, 200, 30);
        cLabelInfo lineProduct = new cLabelInfo("Pcs", 220, 85, 40, 30);
        cLabelInfo labelCurrency = new cLabelInfo("Rp.", 12, 85, 40, 30);
        cLabelInfo productPrice = new cLabelInfo(priceProduct, 50, 85, 200, 30);

        cTextArea productDescription = new cTextArea(12, 40, 260, 40, false);
        productDescription.setText(descriptionProduct);
        productDescription.setBorder(new javax.swing.border.LineBorder(cColor.GREEN, 1));
        productDescription.setFont(cFonts.FONT_SIZE_8);

        cButtonRounded btnAddTransaction = new cButtonRounded("Add to cart", 12, 120, 260, 30, 10);

        panelLabel.add(productName);
        panelLabel.add(productCount);
        panelLabel.add(lineProduct);
        panelLabel.add(labelCurrency);
        panelLabel.add(productPrice);
        panelLabel.add(productDescription);
        panelLabel.add(btnAddTransaction);

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

        btnAddTransaction.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                updateTransaksiView.addProductToCart(idProduct, nameProduct,
                        Integer.parseInt(priceProduct));
            }
        });

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
        scrollPanel.setBackground(cColor.GREEN);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panelProduct.setLayout(new BorderLayout());
        panelProduct.add(scrollPanel, BorderLayout.CENTER);
        panelProduct.revalidate();
        panelProduct.repaint();
    }
}
