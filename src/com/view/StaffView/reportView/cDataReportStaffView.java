package com.view.staffView.reportView;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.main.database.seats.cDataSeats;
import com.main.database.transaction.cDataTransaction;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.cBigFont;
import com.partials.cButtonRounded;
import com.partials.cComboBox;
import com.partials.cFonts;
import com.partials.cLabelInfo;
import com.partials.cPanelRounded;
import com.partials.cScrollTable;
import com.partials.cTable;

public class cDataReportStaffView extends cPanelContentApp {

    private cContentStaffView parentPanel;

    // component header data Seats
    private cBigFont labelHeaderDataReport = new cBigFont("", 40, 5);

    private cLabelInfo labelListDataReport = new cLabelInfo("List Data Report", 30, 25, 300, 40);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2025. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelListReport = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // ini adalah component data Seats
    private cPanelRounded panelTableSeats = new cPanelRounded(0, 80, 1050, 400, 0, 0);
    private cButtonRounded btnPrintDataSeats = new cButtonRounded("Print", 410, 25, 110, 40, 10);
    private cTable tblDataSeats;
    private cScrollTable spDataSeats;

    // ini adalah component data transaksi
    private cPanelRounded panelTableTransaksi = new cPanelRounded(0, 80, 1050, 400, 0, 0);
    private cButtonRounded btnPrintDataTransaction = new cButtonRounded("Print", 410, 25, 110, 40, 10);

    // component table transaction
    private cTable tblTransaction;
    private cScrollTable spTransaction;

    private cComboBox boxDataReport = new cComboBox(
            new String[] { "Seats", "Transaction" }, 180, 30,
            200, 30);

    public cDataReportStaffView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsDataReportView();
    }

    public void refreshContent() {
        try {
            panelTableSeats.removeAll();
            panelTableSeats.revalidate();
            panelTableSeats.repaint();

            panelTableTransaksi.removeAll();
            panelTableTransaksi.revalidate();
            panelTableTransaksi.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initsDataReportView() {
        refreshContent();

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        boxDataReport.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String selectedItem = (String) boxDataReport.getSelectedItem();

                panelListReport.removeAll();
                panelListReport.revalidate();
                panelListReport.repaint();

                panelListReport.add(boxDataReport);
                panelListReport.add(labelListDataReport);

                if ("Seats".equals(selectedItem)) {
                    initsReportDataSeatsView();
                } else if ("Transaction".equals(selectedItem)) {
                    initsReportDataTransactionView();
                }
            }
        });

        panelListReport.add(boxDataReport);
        panelListReport.add(labelListDataReport);

        bgPanel.add(labelCopyright);
        bgPanel.add(panelListReport);
        bgPanel.add(labelHeaderDataReport);

        initsReportDataSeatsView();

        setVisible(true);
    }

    private void initsReportDataSeatsView() {

        labelHeaderDataReport.setText("Data Seats");

        tblDataSeats = new cTable(cDataSeats.getAllSeats());
        spDataSeats = new cScrollTable(tblDataSeats, 0, 0, 1050, 400);

        panelTableSeats.add(spDataSeats);
        panelListReport.add(btnPrintDataSeats);
        panelListReport.add(panelTableSeats);

        loadDataSeats();

        setVisible(true);
    }

    private void initsReportDataTransactionView() {

        labelHeaderDataReport.setText("Data Transaction");

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        tblTransaction = new cTable(cDataTransaction.getAllTransaction());
        spTransaction = new cScrollTable(tblTransaction, 0, 0, 1050, 400);

        panelTableTransaksi.add(spTransaction);

        panelListReport.add(panelTableTransaksi);
        panelListReport.add(btnPrintDataTransaction);

        loadDataTransaction();

        setVisible(true);
    }

    public void loadDataSeats() {
        DefaultTableModel modelTableSeats = cDataSeats.getAllSeats();

        tblDataSeats.setModel(modelTableSeats);

    }

    public void loadDataTransaction() {
        DefaultTableModel modelTableTransaction = cDataTransaction.getAllTransaction();

        tblTransaction.setModel(modelTableTransaction);

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
