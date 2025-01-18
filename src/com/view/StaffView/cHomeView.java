package com.view.staffView;

import com.partials.*;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.main.database.product.cCountDataProduct;
import com.main.database.seats.cCountDataSeats;
import com.main.database.transaction.cCountDataHistoryTransaction;
import com.main.database.transaction.cCountDataTransaction;
import com.main.database.transaction.cDataTransaction;
import com.main.resources.templates.cPanelContentApp;

public class cHomeView extends cPanelContentApp {

   // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2025. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component beranda
    private cPanelRounded panelDataProduct = new cPanelRounded(40, 40, 240, 130, 10, 10);
    private cPanelRounded panelDataSeats = new cPanelRounded(310, 40, 240, 130, 10, 10);
    private cPanelRounded panelDataTransaksi = new cPanelRounded(580, 40, 240, 130, 10, 10);
    private cPanelRounded panelDataHistory = new cPanelRounded(850, 40, 240, 130, 10, 10);
    private cPanelRounded panelListTransaction = new cPanelRounded(40, 210, 1050, 430, 10, 10);
    private cPanelRounded panelTableTransaksi = new cPanelRounded(0, 80, 1050, 130, 0, 0);

    // component label beranda
    private cLabelInfo labelDataProduct = new cLabelInfo("Data Product", 0, 10, 240, 40);
    private cLabelInfo labelDataSeats = new cLabelInfo("Data Seats", 0, 10, 240, 40);
    private cLabelInfo labelDataTransaksi = new cLabelInfo("Data Transaksi", 0, 10, 240, 40);
    private cLabelInfo labelDataHistory = new cLabelInfo("Data History", 0, 10, 240, 40);
    private cLabelInfo labelListTransaction = new cLabelInfo("List Transaction", 30, 20, 580, 40);

    // component value data beranda
    private cLabelInfo valueDataProduct = new cLabelInfo("0", 0, 60, 240, 40);
    private cLabelInfo valueDataSeats = new cLabelInfo("0", 0, 60, 240, 40);
    private cLabelInfo valueDataTransaksi = new cLabelInfo("0", 0, 60, 240, 40);
    private cLabelInfo valueDataHistory = new cLabelInfo("0", 0, 60, 240, 40);

    // component gambar data beranda
    private cImage imgDataProduct = new cImage("src/com/main/resources/images/menu(green).png", 20, 50, 55, 50);
    private cImage imgDataSeats = new cImage("src/com/main/resources/images/datakursi(green).png", 20, 50, 55, 50);
    private cImage imgDataTransaksi = new cImage("src/com/main/resources/images/dataTransaksi(green).png", 20, 50, 55,
            50);
    private cImage imgDataHistory = new cImage("src/com/main/resources/images/history(green).png", 20, 50, 55, 50);

    // component button data beranda
    private cButtonRounded btnListTransaction = new cButtonRounded("see all", 900, 20, 110, 40, 10);

    private cTable tblTransaction;
    private cScrollTable spTransaction;

    public cHomeView() {
        super();
        initsShowHomeView();
    }

    public void refreshContent() {
        try {
            valueDataProduct.removeAll();
            valueDataProduct.revalidate();
            valueDataProduct.repaint();

            valueDataSeats.removeAll();
            valueDataSeats.revalidate();
            valueDataSeats.repaint();

            valueDataTransaksi.removeAll();
            valueDataTransaksi.revalidate();
            valueDataTransaksi.repaint();

            valueDataHistory.removeAll();
            valueDataHistory.revalidate();
            valueDataHistory.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initsShowHomeView() {
        refreshContent();

        valueDataProduct.setText(String.valueOf(cCountDataProduct.getTotalProductCount()));
        valueDataSeats.setText(String.valueOf(cCountDataSeats.getTotalSeatCount()));
        valueDataTransaksi.setText(String.valueOf(cCountDataTransaction.getTotalTransacitonCount()));
        valueDataHistory.setText(String.valueOf(cCountDataHistoryTransaction.getTotalHistoryTransactionCount()));

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        labelDataProduct.setHorizontalAlignment(JLabel.CENTER);
        labelDataSeats.setHorizontalAlignment(JLabel.CENTER);
        labelDataTransaksi.setHorizontalAlignment(JLabel.CENTER);
        labelDataHistory.setHorizontalAlignment(JLabel.CENTER);

        valueDataProduct.setHorizontalAlignment(JLabel.CENTER);
        valueDataSeats.setHorizontalAlignment(JLabel.CENTER);
        valueDataTransaksi.setHorizontalAlignment(JLabel.CENTER);
        valueDataHistory.setHorizontalAlignment(JLabel.CENTER);

        panelDataProduct.add(labelDataProduct);
        panelDataProduct.add(imgDataProduct);

        panelDataSeats.add(labelDataSeats);
        panelDataSeats.add(imgDataSeats);

        panelDataTransaksi.add(labelDataTransaksi);
        panelDataTransaksi.add(imgDataTransaksi);

        panelDataHistory.add(labelDataHistory);
        panelDataHistory.add(imgDataHistory);

        panelDataProduct.add(valueDataProduct);
        panelDataSeats.add(valueDataSeats);
        panelDataTransaksi.add(valueDataTransaksi);
        panelDataHistory.add(valueDataHistory);

        panelListTransaction.add(labelListTransaction);
        panelListTransaction.add(btnListTransaction);
        
        tblTransaction = new cTable(cDataTransaction.getAllTransaction());
        spTransaction = new cScrollTable(tblTransaction, 0, 0, 1050, 130);

        panelTableTransaksi.add(spTransaction);

        panelListTransaction.add(panelTableTransaksi);

        bgPanel.add(panelDataProduct);
        bgPanel.add(panelDataSeats);
        bgPanel.add(panelDataTransaksi);
        bgPanel.add(panelDataHistory);
        bgPanel.add(panelListTransaction);
        bgPanel.add(labelCopyright);

        loadData();

        loadDataTransaction();

        setVisible(true);
    }

    public void loadData() {
        refreshContent();
        try {
            valueDataProduct.setText(String.valueOf(cCountDataProduct.getTotalProductCount()));
            valueDataSeats.setText(String.valueOf(cCountDataSeats.getTotalSeatCount()));
            valueDataTransaksi.setText(String.valueOf(cCountDataTransaction.getTotalTransacitonCount()));
            valueDataHistory.setText(String.valueOf(cCountDataHistoryTransaction.getTotalHistoryTransactionCount()));

            valueDataProduct.revalidate();
            valueDataProduct.repaint();
            valueDataSeats.revalidate();
            valueDataSeats.repaint();
            valueDataTransaksi.revalidate();
            valueDataTransaksi.repaint();
            valueDataHistory.revalidate();
            valueDataHistory.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

        tblTransaction.getColumnModel().getColumn(3).setMinWidth(0);
        tblTransaction.getColumnModel().getColumn(3).setMaxWidth(0);
        tblTransaction.getColumnModel().getColumn(3).setWidth(0);

        tblTransaction.getColumnModel().getColumn(4).setMinWidth(90);
        tblTransaction.getColumnModel().getColumn(4).setMaxWidth(90);
        tblTransaction.getColumnModel().getColumn(4).setWidth(90);

        tblTransaction.getColumnModel().getColumn(5).setMinWidth(150);
        tblTransaction.getColumnModel().getColumn(5).setMaxWidth(150);
        tblTransaction.getColumnModel().getColumn(5).setWidth(150);

        tblTransaction.getColumnModel().getColumn(8).setMinWidth(65);
        tblTransaction.getColumnModel().getColumn(8).setMaxWidth(65);
        tblTransaction.getColumnModel().getColumn(8).setWidth(65);

        tblTransaction.getColumnModel().getColumn(10).setMinWidth(0);
        tblTransaction.getColumnModel().getColumn(10).setMaxWidth(0);
        tblTransaction.getColumnModel().getColumn(10).setWidth(0);

        tblTransaction.getColumnModel().getColumn(12).setMinWidth(65);
        tblTransaction.getColumnModel().getColumn(12).setMaxWidth(65);
        tblTransaction.getColumnModel().getColumn(12).setWidth(65);

        tblTransaction.getColumnModel().getColumn(14).setMinWidth(0);
        tblTransaction.getColumnModel().getColumn(14).setMaxWidth(0);
        tblTransaction.getColumnModel().getColumn(14).setWidth(0);
    }

}
