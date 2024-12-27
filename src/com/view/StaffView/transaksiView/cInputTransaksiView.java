package com.view.StaffView.transaksiView;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.*;

public class cInputTransaksiView extends cPanelContentApp {

    // add object cPanelContentView
    private cContentStaffView parentPanel;

    // add label header Transaksi
    private cBigFont labelHeaderTransaksi = new cBigFont("Transaksi", 40, 5);
    private cBigFont labelInputTransaksi = new cBigFont("Input Data Transaksi", 40, 20);
    private cBigFont labelListOrderTransaksi = new cBigFont("List Order", 40, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // add panel Input
    private cPanelRounded panelInputTransaksi = new cPanelRounded(40, 80, 600, 560, 10, 10);
    private cPanelRounded panelListOrderTransaksi = new cPanelRounded(660, 80, 430, 560, 10, 10);

    // component button transaksi
    private cButtonRounded btnAddTransaksi = new cButtonRounded("Add Product", 40, 140, 220, 40, 10);
    private cButtonRounded btnSaveTransaksi = new cButtonRounded("Save", 210, 490, 110, 40, 10);
    private cButtonRounded btnDeleteTransaksi = new cButtonRounded("Delete", 330, 490, 110, 40, 10);
    private cButtonRounded btnEditTransaksi = new cButtonRounded("Edit", 450, 490, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 40, 490, 110, 40, 10);

    // component label transaksi
    private cLabelInfo labelAddProduct = new cLabelInfo("Product", 40, 110, 300, 30);
    private cLabelInfo labelAddSeats = new cLabelInfo("Seats", 330, 110, 300, 30);
    private cLabelInfo labelAmountProduct = new cLabelInfo("Amount", 40, 250, 300, 30);
    private cLabelInfo labelDeskripsiProduct = new cLabelInfo("Deskripsi", 40, 320, 300, 30);

    // compoenent combobox transaksi
    private cComboBox boxSeatsTransaksi = new cComboBox(new String[] {
            "Add Seats"
    }, 330, 140, 220, 40);

    // component textfield transaksi
    private cTextField txtAmountTransaksi = new cTextField(40, 280, 520);
    private cTextArea txtDeskripsiTransaksi = new cTextArea(40, 350, 520, 100, true);

    private List<String> cartItems = new ArrayList<>();

    private cLabelInfo labelCart = new cLabelInfo("", 40, 200, 300, 300);

    public cInputTransaksiView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsInputTransaksiView();
    }

    public void addProductToCart(int idProduct, String nameProduct, int count, int price, String description) {
        // Tambahkan item ke daftar
        cartItems.add(nameProduct);

        // Perbarui label keranjang
        updateCartDisplay();
    }

    private void updateCartDisplay() {
        StringBuilder sb = new StringBuilder();
        cartItems.forEach(e -> sb.append(e));
        labelCart.setText("Keranjag");
    }

    private void initsInputTransaksiView() {
        setVisible(true);

        btnAddTransaksi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataProductTransaksiView();
            }
        });

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataTransaksiView();
            }
        });

        System.out.println("sayang acoo");

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        labelInputTransaksi.setFont(cFonts.FONT_SIZE_20);

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

        bgPanel.add(panelInputTransaksi);
        bgPanel.add(panelListOrderTransaksi);
        bgPanel.add(labelHeaderTransaksi);
        bgPanel.add(labelCopyright);
    }
}
