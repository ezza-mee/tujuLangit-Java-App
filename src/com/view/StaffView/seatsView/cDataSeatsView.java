package com.view.staffView.seatsView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.main.database.seats.cDataSeats;
import com.main.database.seats.cDataUsedSeats;
import com.main.database.seats.cDeleteDataSeats;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.*;

public class cDataSeatsView extends cPanelContentApp {

    private cContentStaffView parentPanel;

    // component header data Seats
    private cBigFont labelHeaderDataSeats = new cBigFont("Seats", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2025. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component Data Seats
    private cPanelRounded panelListSeats = new cPanelRounded(40, 80, 600, 560, 10, 10);
    private cPanelRounded panelListUsed = new cPanelRounded(660, 80, 430, 560, 10, 10);
    private cPanelRounded panelTableReadySeats = new cPanelRounded(0, 80, 600, 400, 0, 0);
    private cPanelRounded panelTableUsedSeats = new cPanelRounded(0, 80, 600, 400, 0, 0);

    // component label data Seats
    private cLabelInfo labelListDataSeats = new cLabelInfo("List Data Seats", 30, 30, 580, 30);
    private cLabelInfo labelListUsed = new cLabelInfo("Seats Used", 30, 30, 400, 30);

    // component button data Seats
    private cButtonRounded btnInputDataSeats = new cButtonRounded("Input", 210, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataSeats = new cButtonRounded("Update", 330, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataSeats = new cButtonRounded("Delete", 450, 25, 110, 40, 10);

    private cTable tblDataSeats;
    private cTable tblDataUsedSeats;
    private cScrollTable spDataSeats;
    private cScrollTable spDataUsedSeats;

    public cDataSeatsView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsDataSeatsView();
    }

    public void refreshContent() {
        try {
            panelTableReadySeats.removeAll();
            panelTableReadySeats.revalidate();
            panelTableReadySeats.repaint();

            panelTableUsedSeats.removeAll();
            panelTableUsedSeats.revalidate();
            panelTableUsedSeats.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initsDataSeatsView() {
        refreshContent();

        btnInputDataSeats.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputDataSeatsView();
            }
        });

        btnUpdateDataSeats.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectAllDataSeat = tblDataSeats.getSelectedRow();
                int selectAllDataSeatsUsed = tblDataUsedSeats.getSelectedRow();

                if (selectAllDataSeat != -1) {
                    String idString = tblDataSeats.getValueAt(selectAllDataSeat, 0).toString();
                    int idSeats = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

                    String numberSeats = tblDataSeats.getValueAt(selectAllDataSeat, 2).toString();
                    int amountSeats = Integer.parseInt(tblDataSeats.getValueAt(selectAllDataSeat, 3).toString());
                    String descriptionSeats = tblDataSeats.getValueAt(selectAllDataSeat, 4).toString();
                    String statusSeats = tblDataSeats.getValueAt(selectAllDataSeat, 5).toString();

                    parentPanel.showUpdateDataSeatsView(idSeats, numberSeats, amountSeats,
                            descriptionSeats, statusSeats);

                } else if (selectAllDataSeatsUsed != -1) {
                    String idString = tblDataUsedSeats.getValueAt(selectAllDataSeatsUsed, 0).toString();
                    int idSeats = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

                    String numberSeats = tblDataUsedSeats.getValueAt(selectAllDataSeatsUsed, 2).toString();
                    int amountSeats = Integer
                            .parseInt(tblDataUsedSeats.getValueAt(selectAllDataSeatsUsed, 3).toString());
                    String descriptionSeats = tblDataUsedSeats.getValueAt(selectAllDataSeatsUsed, 4).toString();
                    String statusSeats = tblDataUsedSeats.getValueAt(selectAllDataSeatsUsed, 5).toString();

                    parentPanel.showUpdateDataSeatsView(idSeats, numberSeats, amountSeats,
                            descriptionSeats, statusSeats);

                } else {
                    System.out.println("Pilih Seats untuk diperbarui.");
                }
            }
        });

        btnDeleteDataSeats.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedRow = tblDataSeats.getSelectedRow();
                if (selectedRow != -1) {
                    String idStaffString = tblDataSeats.getValueAt(selectedRow, 0).toString();
                    int idStaff = Integer.parseInt(idStaffString.replaceAll("[^0-9]", ""));

                    boolean deleted = cDeleteDataSeats.handleDeleteDataSeats(idStaff);

                    if (deleted) {
                        DefaultTableModel model = (DefaultTableModel) tblDataSeats.getModel();
                        model.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Staff berhasil dihapus!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal menghapus Staff.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih Staff yang akan dihapus.");
                }
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        btnInputDataSeats.setFont(cFonts.FONT_SIZE_13);
        btnUpdateDataSeats.setFont(cFonts.FONT_SIZE_13);
        btnDeleteDataSeats.setFont(cFonts.FONT_SIZE_13);

        tblDataSeats = new cTable(cDataSeats.getAllSeats());
        spDataSeats = new cScrollTable(tblDataSeats, 0, 0, 600, 400);

        tblDataUsedSeats = new cTable(cDataUsedSeats.getAllUsedSeats());
        spDataUsedSeats = new cScrollTable(tblDataUsedSeats, 0, 0, 430, 400);

        panelTableReadySeats.add(spDataSeats);
        panelListSeats.add(panelTableReadySeats);

        panelTableUsedSeats.add(spDataUsedSeats);
        panelListUsed.add(panelTableUsedSeats);

        panelListSeats.add(labelListDataSeats);
        panelListSeats.add(btnInputDataSeats);
        panelListSeats.add(btnUpdateDataSeats);
        panelListSeats.add(btnDeleteDataSeats);
        panelListUsed.add(labelListUsed);

        bgPanel.add(labelHeaderDataSeats);

        bgPanel.add(panelListSeats);
        bgPanel.add(panelListUsed);
        bgPanel.add(labelCopyright);

        loadDataSeats();

        setVisible(true);
    }

    public void loadDataSeats() {
        DefaultTableModel modelTableReadySeats = cDataSeats.getAllSeats();
        DefaultTableModel modelTableUsedSeats = cDataUsedSeats.getAllUsedSeats();

        tblDataSeats.setModel(modelTableReadySeats);
        tblDataUsedSeats.setModel(modelTableUsedSeats);

        panelListSeats.revalidate();
        panelListSeats.repaint();

        panelListUsed.revalidate();
        panelListUsed.repaint();

        tblDataSeats.getColumnModel().getColumn(0).setMinWidth(65);
        tblDataSeats.getColumnModel().getColumn(0).setMaxWidth(65);
        tblDataSeats.getColumnModel().getColumn(0).setWidth(65);

        tblDataSeats.getColumnModel().getColumn(1).setMinWidth(150);
        tblDataSeats.getColumnModel().getColumn(1).setMaxWidth(150);
        tblDataSeats.getColumnModel().getColumn(1).setWidth(150);

        tblDataSeats.getColumnModel().getColumn(2).setMinWidth(75);
        tblDataSeats.getColumnModel().getColumn(2).setMaxWidth(75);
        tblDataSeats.getColumnModel().getColumn(2).setWidth(75);

        tblDataSeats.getColumnModel().getColumn(3).setMinWidth(70);
        tblDataSeats.getColumnModel().getColumn(3).setMaxWidth(70);
        tblDataSeats.getColumnModel().getColumn(3).setWidth(70);

        tblDataSeats.getColumnModel().getColumn(4).setMinWidth(130);
        tblDataSeats.getColumnModel().getColumn(4).setMaxWidth(130);
        tblDataSeats.getColumnModel().getColumn(4).setWidth(130);

        tblDataSeats.getColumnModel().getColumn(5).setMinWidth(80);
        tblDataSeats.getColumnModel().getColumn(5).setMaxWidth(80);
        tblDataSeats.getColumnModel().getColumn(5).setWidth(80);

        tblDataUsedSeats.getColumnModel().getColumn(0).setMinWidth(65);
        tblDataUsedSeats.getColumnModel().getColumn(0).setMaxWidth(65);
        tblDataUsedSeats.getColumnModel().getColumn(0).setWidth(65);

        tblDataUsedSeats.getColumnModel().getColumn(1).setMinWidth(180);
        tblDataUsedSeats.getColumnModel().getColumn(1).setMaxWidth(180);
        tblDataUsedSeats.getColumnModel().getColumn(1).setWidth(180);

        tblDataUsedSeats.getColumnModel().getColumn(2).setMinWidth(75);
        tblDataUsedSeats.getColumnModel().getColumn(2).setMaxWidth(75);
        tblDataUsedSeats.getColumnModel().getColumn(2).setWidth(75);

        tblDataUsedSeats.getColumnModel().getColumn(3).setMinWidth(0);
        tblDataUsedSeats.getColumnModel().getColumn(3).setMaxWidth(0);
        tblDataUsedSeats.getColumnModel().getColumn(3).setWidth(0);

        tblDataUsedSeats.getColumnModel().getColumn(4).setMinWidth(0);
        tblDataUsedSeats.getColumnModel().getColumn(4).setMaxWidth(0);
        tblDataUsedSeats.getColumnModel().getColumn(4).setWidth(0);

    }

}
