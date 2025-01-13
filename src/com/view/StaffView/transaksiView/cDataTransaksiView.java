package com.view.staffView.transaksiView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.main.database.transaction.cDataTransaction;
import com.main.database.transaction.cDeleteTransaction;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.*;

public class cDataTransaksiView extends cPanelContentApp {

    // add object cPanelContentView
    private cContentStaffView parentPanel;

    // ini adalah component data transaksi
    private cBigFont labelHeaderDataTransaksi = new cBigFont("Data Transaksi", 40, 5);

    // ini adalah component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // ini adalah component data transaksi
    private cPanelRounded panelListTransaksi = new cPanelRounded(40, 80, 1050, 560, 10, 10);
    private cPanelRounded panelTableTransaksi = new cPanelRounded(0, 80, 1050, 400, 0, 0);

    // ini adalah component label data transaksi
    private cLabelInfo labelDataTransaksi = new cLabelInfo("List Transaksi", 30, 30, 600, 40);

    // ini adalah component button data transaksi
    private cButtonRounded btnInputDataTransaksi = new cButtonRounded("Input", 860, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataTransaksi = new cButtonRounded("Update", 580, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataTransaksi = new cButtonRounded("Delete", 720, 25, 110, 40, 10);

    // component table transaction
    private cTable tblTransaction;
    private cScrollTable spTransaction;

    public cDataTransaksiView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsDataTransaksiView();
    }

    public void refreshContent() {
        try {
            panelTableTransaksi.removeAll();
            panelTableTransaksi.revalidate();
            panelTableTransaksi.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initsDataTransaksiView() {

        refreshContent();

        btnInputDataTransaksi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputTransaksiView();
            }
        });

        btnUpdateDataTransaksi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedIndex = tblTransaction.getSelectedRow();

                if (selectedIndex != -1) {
                    String idString = tblTransaction.getValueAt(selectedIndex, 0).toString();
                    int idTransaction = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

                    int idProductTransaction = Integer.parseInt(tblTransaction.getValueAt(selectedIndex, 1).toString());
                    int idProduct = Integer.parseInt(tblTransaction.getValueAt(selectedIndex, 2).toString());
                    String numberSeats = tblTransaction.getValueAt(selectedIndex, 3).toString();
                    String nameCustomer = tblTransaction.getValueAt(selectedIndex, 4).toString();
                    int amountTransaction = Integer.parseInt(tblTransaction.getValueAt(selectedIndex, 5).toString());
                    String priceTotalString = tblTransaction.getValueAt(selectedIndex, 6).toString();
                    priceTotalString = priceTotalString.replaceAll("[^0-9]", "");
                    int priceTransaction = Integer.parseInt(priceTotalString);
                    String description = tblTransaction.getValueAt(selectedIndex, 7).toString();
                    String nameProduct = tblTransaction.getValueAt(selectedIndex, 8).toString();
                    int amountProduct = Integer.parseInt(tblTransaction.getValueAt(selectedIndex, 9).toString());
                    String priceProductString = tblTransaction.getValueAt(selectedIndex, 10).toString();
                    priceProductString = priceProductString.replaceAll("[^0-9]", "");
                    int priceProduct = Integer.parseInt(priceProductString);

                    parentPanel.showUpdateTransaksiView(idTransaction, idProduct, idProductTransaction, numberSeats, nameCustomer,
                            amountTransaction, priceTransaction, description, nameProduct, amountProduct, priceProduct);
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih transaksi yang akan diperbarui.");
                }
            }
        });

        btnDeleteDataTransaksi.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedRow = tblTransaction.getSelectedRow();
                if (selectedRow != -1) {
                    String idTransactionString = tblTransaction.getValueAt(selectedRow, 0).toString();
                    int idTransaction = Integer.parseInt(idTransactionString.replaceAll("[^0-9]", ""));

                    boolean deleted = cDeleteTransaction.handleDeleteDataTransaction(idTransaction);

                    if (deleted) {
                        DefaultTableModel model = (DefaultTableModel) tblTransaction.getModel();
                        model.removeRow(selectedRow);
                        loadDataTransaction();
                        JOptionPane.showMessageDialog(null, "Staff Berhasil dihapus!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal Menghapus Transaksi.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih Transaksi yang akan dihapus.");
                }
            }
        });

        System.out.println("Archo Ngawi 456");

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        btnInputDataTransaksi.setFont(cFonts.FONT_SIZE_13);
        btnUpdateDataTransaksi.setFont(cFonts.FONT_SIZE_13);
        btnDeleteDataTransaksi.setFont(cFonts.FONT_SIZE_13);

        panelListTransaksi.add(labelDataTransaksi);
        panelListTransaksi.add(btnInputDataTransaksi);
        panelListTransaksi.add(btnUpdateDataTransaksi);
        panelListTransaksi.add(btnDeleteDataTransaksi);
        panelListTransaksi.add(panelTableTransaksi);

        tblTransaction = new cTable(cDataTransaction.getAllTransaction());
        spTransaction = new cScrollTable(tblTransaction, 0, 0, 1050, 400);

        panelTableTransaksi.add(spTransaction);

        bgPanel.add(panelListTransaksi);
        bgPanel.add(labelHeaderDataTransaksi);
        bgPanel.add(labelCopyright);

        loadDataTransaction();

        setVisible(true);
    }

    public void loadDataTransaction() {
        DefaultTableModel modelTableTransaction = cDataTransaction.getAllTransaction();

        tblTransaction.setModel(modelTableTransaction);

        panelTableTransaksi.revalidate();
        panelTableTransaksi.repaint();

        tblTransaction.getColumnModel().getColumn(0).setMinWidth(65);
        tblTransaction.getColumnModel().getColumn(0).setMaxWidth(65);
        tblTransaction.getColumnModel().getColumn(0).setWidth(65);

        tblTransaction.getColumnModel().getColumn(1).setMinWidth(0);
        tblTransaction.getColumnModel().getColumn(1).setMaxWidth(0);
        tblTransaction.getColumnModel().getColumn(1).setWidth(0);

        tblTransaction.getColumnModel().getColumn(2).setMinWidth(0);
        tblTransaction.getColumnModel().getColumn(2).setMaxWidth(0);
        tblTransaction.getColumnModel().getColumn(2).setWidth(0);

        tblTransaction.getColumnModel().getColumn(3).setMinWidth(80);
        tblTransaction.getColumnModel().getColumn(3).setMaxWidth(80);
        tblTransaction.getColumnModel().getColumn(3).setWidth(80);

        tblTransaction.getColumnModel().getColumn(4).setMinWidth(150);
        tblTransaction.getColumnModel().getColumn(4).setMaxWidth(150);
        tblTransaction.getColumnModel().getColumn(4).setWidth(150);

        tblTransaction.getColumnModel().getColumn(5).setMinWidth(90);
        tblTransaction.getColumnModel().getColumn(5).setMaxWidth(90);
        tblTransaction.getColumnModel().getColumn(5).setWidth(90);

        tblTransaction.getColumnModel().getColumn(6).setMinWidth(90);
        tblTransaction.getColumnModel().getColumn(6).setMaxWidth(90);
        tblTransaction.getColumnModel().getColumn(6).setWidth(90);

    }
}
