package com.view.staffView.reportView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.main.database.transaction.cDataTransaction;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.cBigFont;
import com.partials.cButtonRounded;
import com.partials.cFonts;
import com.partials.cLabelInfo;
import com.partials.cPanelRounded;
import com.partials.cScrollTable;
import com.partials.cTable;

public class cReportTransactionView extends cPanelContentApp {

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

    // component table transaction
    private cTable tblTransaction;
    private cScrollTable spTransaction;

    public cReportTransactionView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsReportDataTransactionView();
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

    private void initsReportDataTransactionView() {
        refreshContent();

        System.out.println("Archo Ngawi 456");

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelListTransaksi.add(labelDataTransaksi);
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
