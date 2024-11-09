package com.view.adminView.dataProductView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.database.cLoadDataProduct;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cDataProductView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    // component label header Data menu
    private cBigFont labelHeaderDataMenu = new cBigFont("Product", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component Data Menu
    private cPanelRounded panelListMenu = new cPanelRounded(40, 80, 1050, 560, 10, 10);
    private cPanelRounded panelMenu = new cPanelRounded(0, 130, 1050, 430, 0, 0);

    // component label data Menu
    private cLabelInfo labelListDataMenu = new cLabelInfo("List Data Menu", 30, 30, 580, 30);

    // component button data Menu
    private cButtonRounded btnInputDataMenu = new cButtonRounded("input", 610, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataMenu = new cButtonRounded("Update", 730, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataMenu = new cButtonRounded("Delete", 850, 25, 110, 40, 10);

    public void refreshContent() {
        try {
            bgPanel.remove(panelMenu);
            bgPanel.revalidate();
            bgPanel.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public cDataProductView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsDataMenuView();
    }

    public void initsDataMenuView() {
        refreshContent();

        btnInputDataMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputDataProductView();
            }
        });

        btnUpdateDataMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showUpdateDataProductView();
            }
        });

        btnDeleteDataMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDeleteDataProductView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        btnInputDataMenu.setFont(cFonts.BUTTON_INPUT_FONT);
        btnUpdateDataMenu.setFont(cFonts.BUTTON_INPUT_FONT);
        btnDeleteDataMenu.setFont(cFonts.BUTTON_INPUT_FONT);

        panelListMenu.add(labelListDataMenu);
        panelListMenu.add(btnInputDataMenu);
        panelListMenu.add(btnUpdateDataMenu);
        panelListMenu.add(btnDeleteDataMenu);

        panelMenu.setLayout(new BorderLayout());

        panelListMenu.add(panelMenu);

        bgPanel.add(labelHeaderDataMenu);
        bgPanel.add(panelListMenu);
        bgPanel.add(labelCopyright);

        loadDataProducts();
        setVisible(true);
    }

    private JPanel createProductCard(String name, byte[] imageBytes) {
        cPanelRounded cardPanel = new cPanelRounded();
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
        cardPanel.setPreferredSize(new Dimension(220, 300));
        cardPanel.setBackground(cColor.WHITE);

        cPanelRounded panelLabel = new cPanelRounded();
        panelLabel.setLayout(null);
        cLabelInfo nameLabel = new cLabelInfo(name, 0, 0, 200, 40);
        panelLabel.add(nameLabel);

        cPanelRounded panelImage = new cPanelRounded();
        panelImage.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelImage.setBackground(cColor.GREY);
        ImageIcon productImage = new ImageIcon(imageBytes);
        Image scaledImage = productImage.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImage));
        panelImage.add(imageLabel);

        cardPanel.add(panelImage);
        cardPanel.add(panelLabel);

        return cardPanel;
    }

    public void loadDataProducts() {
        cLoadDataProduct dataProductLoader = new cLoadDataProduct();
        List<cLoadDataProduct.Product> products = dataProductLoader.loadProducts();

        JPanel cardContainer = new JPanel(new GridLayout(0, 3, 40, 40)); // 5 kartu per baris
        cardContainer.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        cardContainer.setBackground(cColor.WHITE);

        for (cLoadDataProduct.Product product : products) {
            JPanel productCard = createProductCard(product.getName(), product.getImageBytes());
            cardContainer.add(productCard);
        }

        cScrollPane scrollPanel = new cScrollPane(cardContainer, 0, 0, 1050, 430);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panelMenu.setLayout(new BorderLayout());
        panelMenu.add(scrollPanel, BorderLayout.CENTER);
        panelMenu.revalidate();
        panelMenu.repaint();
    }

}
