package com.view.StaffView.transaksiView;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.*;

public class cInputTransaksiView extends cPanelContentApp {

    private cContentStaffView parentPanel;
    private cBigFont labelHeaderTransaksi = new cBigFont("Transaksi", 40, 5);
    private cBigFont labelInputTransaksi = new cBigFont("Input Data Transaksi", 40, 20);
    private cBigFont labelListOrderTransaksi = new cBigFont("List Order", 40, 20);
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelInputTransaksi = new cPanelRounded(40, 80, 600, 560, 10, 10);
    private cPanelRounded panelListOrderTransaksi = new cPanelRounded(660, 80, 430, 560, 10, 10);
    private cPanelRounded panelListCardOrder = new cPanelRounded(0, 80, 430, 400, 0, 0);

    private cButtonRounded btnAddTransaksi = new cButtonRounded("Add Product", 40, 140, 220, 40, 10);
    private cButtonRounded btnSaveTransaksi = new cButtonRounded("Save", 210, 490, 110, 40, 10);
    private cButtonRounded btnDeleteTransaksi = new cButtonRounded("Delete", 330, 490, 110, 40, 10);
    private cButtonRounded btnEditTransaksi = new cButtonRounded("Edit", 450, 490, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 40, 490, 110, 40, 10);

    private cLabelInfo labelAddProduct = new cLabelInfo("Product", 40, 110, 300, 30);
    private cLabelInfo labelAddSeats = new cLabelInfo("Seats", 330, 110, 300, 30);
    private cLabelInfo labelAmountProduct = new cLabelInfo("Nama Pembeli", 40, 210, 300, 30);
    private cLabelInfo labelDeskripsiProduct = new cLabelInfo("Deskripsi", 40, 290, 300, 30);

    private cComboBox boxSeatsTransaksi = new cComboBox(new String[] { "Add Seats" }, 330, 140, 220, 40);

    private cTextField txtAmountTransaksi = new cTextField(40, 240, 520);
    private cTextArea txtDeskripsiTransaksi = new cTextArea(40, 320, 520, 100, true);

    private ArrayList<CartItem> cartItems;

    public cInputTransaksiView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        cartItems = new ArrayList<CartItem>();

        initsInputTransaksiView();
    }

    public void addProductToCart(int idProduct, String nameProduct, int price) {
        cartItems.add(new CartItem(nameProduct, 1, price));
        updateCartDisplay();
    }

    private void updateCartDisplay() {
        panelListCardOrder.removeAll();

        JPanel cardContainer = new JPanel();
        cardContainer.setLayout(new BoxLayout(cardContainer, BoxLayout.Y_AXIS));
        cardContainer.setBackground(cColor.WHITE);

        for (CartItem item : cartItems) {
            JPanel cardPanel = new JPanel();
            cardPanel.setLayout(null);
            cardPanel.setPreferredSize(new Dimension(400, 100));
            cardPanel.setBorder(BorderFactory.createLineBorder(cColor.GREY, 1));
            cardPanel.setBackground(cColor.WHITE);

            JLabel productLabel = new JLabel(item.getNameProduct());
            productLabel.setFont(cFonts.FONT_SIZE_15);
            productLabel.setBounds(20, 10, 200, 30);

            JLabel priceLabel = new JLabel("Rp. " + item.getPrice());
            priceLabel.setFont(cFonts.FONT_SIZE_15);
            priceLabel.setBounds(240, 10, 100, 30);

            JLabel countLabel = new JLabel(String.valueOf(item.getCount()));
            countLabel.setFont(cFonts.FONT_SIZE_20);
            countLabel.setBounds(190, 50, 40, 30);
            countLabel.setHorizontalAlignment(SwingConstants.CENTER);

            cImage iconMinus = new cImage("src/com/main/resources/images/minus.png", 0, 0, 20, 20);
            cButtonRounded minusButton = new cButtonRounded("", 140, 50, 40, 30, 10);
            minusButton.setIcon(iconMinus);
            minusButton.addActionListener(e -> {
                if (item.getCount() > 1) {
                    item.setCount(item.getCount() - 1);
                    item.setPrice(item.getCount() * item.getUnitPrice());
                    updateCartDisplay();
                }
            });

            cImage iconTambah = new cImage("src/com/main/resources/images/tambah.png", 0, 0, 20, 20);
            cButtonRounded addButton = new cButtonRounded("", 240, 50, 40, 30, 10);
            addButton.setIcon(iconTambah);
            addButton.addActionListener(e -> {
                item.setCount(item.getCount() + 1);
                item.setPrice(item.getCount() * item.getUnitPrice());
                updateCartDisplay();
            });

            cImage iconDelete = new cImage("src/com/main/resources/images/delete.png", 0, 0, 20, 20);
            cButtonRounded deleteButton = new cButtonRounded("", 300, 50, 60, 30, 10);
            deleteButton.setIcon(iconDelete);
            deleteButton.addActionListener(e -> {
                cartItems.remove(item);
                updateCartDisplay();
            });

            cardPanel.add(productLabel);
            cardPanel.add(priceLabel);
            cardPanel.add(countLabel);
            cardPanel.add(minusButton);
            cardPanel.add(addButton);
            cardPanel.add(deleteButton);

            cardContainer.add(cardPanel);
            cardContainer.add(Box.createRigidArea(new Dimension(0, 10))); // Spasi antar kartu
        }

        cScrollPane scrollPane = new cScrollPane(cardContainer, 0, 0, 430, 400);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setBorder(null);

        panelListCardOrder.add(scrollPane);

        panelListCardOrder.revalidate();
        panelListCardOrder.repaint();
    }

    class CartItem {
        private String nameProduct;
        private int count;
        private int price;
        private int unitPrice;

        public CartItem(String nameProduct, int count, int unitPrice) {
            this.nameProduct = nameProduct;
            this.count = count;
            this.unitPrice = unitPrice;
            this.price = count * unitPrice;
        }

        public String getNameProduct() {
            return nameProduct;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getUnitPrice() {
            return unitPrice;
        }
    }

    private void initsInputTransaksiView() {
        setVisible(true);

        btnAddTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                parentPanel.showDataProductTransaksiView();
            }
        });

        btnBackToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                parentPanel.showDataTransaksiView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        labelInputTransaksi.setFont(cFonts.FONT_SIZE_20);
        labelListOrderTransaksi.setFont(cFonts.FONT_SIZE_20);

        btnAddTransaksi.setFont(cFonts.FONT_SIZE_13);
        btnDeleteTransaksi.setFont(cFonts.FONT_SIZE_13);
        btnSaveTransaksi.setFont(cFonts.FONT_SIZE_13);
        btnEditTransaksi.setFont(cFonts.FONT_SIZE_13);
        btnBackToHome.setFont(cFonts.FONT_SIZE_13);

        panelInputTransaksi.add(labelInputTransaksi);
        panelInputTransaksi.add(btnSaveTransaksi);
        panelInputTransaksi.add(btnDeleteTransaksi);
        panelInputTransaksi.add(btnEditTransaksi);
        panelInputTransaksi.add(btnBackToHome);
        panelInputTransaksi.add(btnAddTransaksi);

        panelInputTransaksi.add(labelAddProduct);
        panelInputTransaksi.add(labelAddSeats);
        panelInputTransaksi.add(labelAmountProduct);
        panelInputTransaksi.add(labelDeskripsiProduct);

        panelInputTransaksi.add(boxSeatsTransaksi);

        panelInputTransaksi.add(txtAmountTransaksi);
        panelInputTransaksi.add(txtDeskripsiTransaksi);

        panelListOrderTransaksi.add(labelListOrderTransaksi);
        panelListOrderTransaksi.add(panelListCardOrder);

        bgPanel.add(panelInputTransaksi);
        bgPanel.add(panelListOrderTransaksi);
        bgPanel.add(labelHeaderTransaksi);
        bgPanel.add(labelCopyright);
    }
}
