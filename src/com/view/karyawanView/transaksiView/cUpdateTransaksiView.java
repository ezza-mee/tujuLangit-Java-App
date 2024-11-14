package com.view.karyawanView.transaksiView;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentKaryawanView;
import com.partials.*;

public class cUpdateTransaksiView extends cPanelContentApp {

    // component panel content
    private cContentKaryawanView parentPanel;

    // add label header update Transaksi
    private cBigFont labelHeaderTransaksi = new cBigFont("Transaksi", 40, 5);
    private cBigFont labelUpdateTransaksi = new cBigFont("Update Data Transaksi", 40, 20);
    private cBigFont labelListOrderTransaksi = new cBigFont("List Order", 40, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // add panel Update
    private cPanelRounded panelUpdateTransaksi = new cPanelRounded(40, 80, 600, 560, 10, 10);
    private cPanelRounded panelListOrderTransaksi = new cPanelRounded(660, 80, 430, 560, 10, 10);

    // component button transaksi
    private cButtonRounded btnAddTransaksi = new cButtonRounded("Add", 450, 30, 110, 40, 10);
    private cButtonRounded btnSaveTransaksi = new cButtonRounded("Save", 210, 490, 110, 40, 10);
    private cButtonRounded btnDeleteTransaksi = new cButtonRounded("Delete", 330, 490, 110, 40, 10);
    private cButtonRounded btnEditTransaksi = new cButtonRounded("Edit", 450, 490, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 40, 490, 110, 40, 10);

    // component label transaksi
    private cLabelInfo labelAddProduct = new cLabelInfo("Prodoct", 40, 110, 300, 30);
    private cLabelInfo labelAddSeats = new cLabelInfo("Seats", 40, 180, 300, 30);
    private cLabelInfo labelAmountProduct = new cLabelInfo("Amount", 40, 250, 300, 30);
    private cLabelInfo labelDeskripsiProduct = new cLabelInfo("Deskripsi", 40, 320, 300, 30);

    // compoenent combobox transaksi
    private cComboBox boxProdoctTransaksi = new cComboBox(new String[] {
            "Add Product"
    }, 40, 140, 520, 30);
    private cComboBox boxSeatsTransaksi = new cComboBox(new String[] {
            "Add Seats"
    }, 40, 210, 520, 30);

    // component textfield transaksi
    private cTextField txtAmountTransaksi = new cTextField(40, 280, 520);
    private cTextArea txtDeskripsiTransaksi = new cTextArea(40, 350, 520, 100, true);

    public cUpdateTransaksiView(cContentKaryawanView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsUpdateTransaksiView();
    }

    public void initsUpdateTransaksiView() {
        setVisible(true);

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataTransaksiView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelUpdateTransaksi.add(labelUpdateTransaksi);
        panelUpdateTransaksi.add(btnSaveTransaksi);
        panelUpdateTransaksi.add(btnDeleteTransaksi);
        panelUpdateTransaksi.add(btnEditTransaksi);
        panelUpdateTransaksi.add(btnBackToHome);
        panelUpdateTransaksi.add(btnAddTransaksi);

        panelUpdateTransaksi.add(labelAddProduct);
        panelUpdateTransaksi.add(labelAddSeats);
        panelUpdateTransaksi.add(labelAmountProduct);
        panelUpdateTransaksi.add(labelDeskripsiProduct);

        panelUpdateTransaksi.add(boxProdoctTransaksi);
        panelUpdateTransaksi.add(boxSeatsTransaksi);

        panelUpdateTransaksi.add(txtAmountTransaksi);
        panelUpdateTransaksi.add(txtDeskripsiTransaksi);

        panelListOrderTransaksi.add(labelListOrderTransaksi);

        bgPanel.add(panelUpdateTransaksi);
        bgPanel.add(panelListOrderTransaksi);
        bgPanel.add(labelHeaderTransaksi);
        bgPanel.add(labelCopyright);
    }

}
