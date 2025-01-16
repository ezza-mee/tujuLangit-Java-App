package com.view.staffView;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.main.database.transaction.cDataTransaction;
import com.main.resources.templates.cPanelContentApp;
import com.partials.*;

public class cHistoryTransaksiView extends cPanelContentApp {

    // ini adalah component data transaksi
    private cBigFont labelHeaderDataTransaksi = new cBigFont("Data Transaksi", 40, 5);

    // ini adalah component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // ini adalah component data transaksi
    private cPanelRounded panelListTransaksi = new cPanelRounded(40, 80, 1050, 560, 10, 10);
    private cPanelRounded panelTableTransaksi = new cPanelRounded(0, 120, 1050, 350, 0, 0);

    // component Search Data
    private cTextField txtSearchData = new cTextField(75, 75, 300);

    // ini adalah component label data transaksi
    private cLabelInfo labelDataTransaksi = new cLabelInfo("List Transaksi", 30, 30, 600, 40);

    // component table transaction
    private cTable tblTransaction;
    private cScrollTable spTransaction;


    public cHistoryTransaksiView() {
        super();
        initsHistoryTransaksiView();
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

    public void initsHistoryTransaksiView() {
        setVisible(true);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelListTransaksi.add(labelDataTransaksi);
        panelListTransaksi.add(panelTableTransaksi);

        panelListTransaksi.add(txtSearchData);
        panelTableTransaksi.setBackground(cColor.GREEN);

        tblTransaction = new cTable(cDataTransaction.getAllTransaction());
        spTransaction = new cScrollTable(tblTransaction, 0, 0, 1050, 350);

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

        tblTransaction.getColumnModel().getColumn(2).setMinWidth(80);
        tblTransaction.getColumnModel().getColumn(2).setMaxWidth(80);
        tblTransaction.getColumnModel().getColumn(2).setWidth(80);

        tblTransaction.getColumnModel().getColumn(3).setMinWidth(150);
        tblTransaction.getColumnModel().getColumn(3).setMaxWidth(150);
        tblTransaction.getColumnModel().getColumn(3).setWidth(150);

        tblTransaction.getColumnModel().getColumn(4).setMinWidth(90);
        tblTransaction.getColumnModel().getColumn(4).setMaxWidth(90);
        tblTransaction.getColumnModel().getColumn(4).setWidth(90);

        tblTransaction.getColumnModel().getColumn(8).setMinWidth(90);
        tblTransaction.getColumnModel().getColumn(8).setMaxWidth(90);
        tblTransaction.getColumnModel().getColumn(8).setWidth(90);

    }
}
