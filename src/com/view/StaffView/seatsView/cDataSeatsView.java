package com.view.StaffView.seatsView;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.main.database.seats.cDataSeats;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.*;

public class cDataSeatsView extends cPanelContentApp {

    private cContentStaffView parentPanel;

    // component header data Seats
    private cBigFont labelHeaderDataSeats = new cBigFont("Seats", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component Data Seats
    private cPanelRounded panelListSeats = new cPanelRounded(40, 80, 600, 560, 10, 10);
    private cPanelRounded panelListUsed = new cPanelRounded(660, 80, 430, 560, 10, 10);

    // component label data Seats
    private cLabelInfo labelListDataSeats = new cLabelInfo("List Data Seats", 30, 30, 580, 30);
    private cLabelInfo labelListUsed = new cLabelInfo("Seats Used", 30, 30, 400, 30);

    // component button data Seats
    private cButtonRounded btnInputDataSeats = new cButtonRounded("input", 210, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataSeats = new cButtonRounded("Update", 330, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataSeats = new cButtonRounded("Delete", 450, 25, 110, 40, 10);

    private cTable tblDataSeats;
    private cScrollTable spDataSeats;

    public cDataSeatsView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsDataSeatsView();
    }

    public void initsDataSeatsView() {
        setVisible(true);

        btnInputDataSeats.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputDataSeatsView();
            }
        });

        btnUpdateDataSeats.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedIndex = tblDataSeats.getSelectedRow();

                if (selectedIndex != -1) {
                    String idString = tblDataSeats.getValueAt(selectedIndex, 0).toString();
                    int idSeats = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

                    String typeSeats = tblDataSeats.getValueAt(selectedIndex, 1).toString();
                    int amountSeats = Integer.parseInt(tblDataSeats.getValueAt(selectedIndex, 2).toString());
                    String descriptionSeats = tblDataSeats.getValueAt(selectedIndex, 4).toString();
                    String statusSeats = tblDataSeats.getValueAt(selectedIndex, 4).toString();

                    parentPanel.showUpdateDataSeatsView(idSeats, typeSeats, amountSeats,
                            descriptionSeats, statusSeats);
                } else {
                    System.out.println("Pilih supplier untuk diperbarui.");
                }
            }
        });

        btnDeleteDataSeats.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDeleteDataSeatsView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        btnInputDataSeats.setFont(cFonts.FONT_SIZE_13);
        btnUpdateDataSeats.setFont(cFonts.FONT_SIZE_13);
        btnDeleteDataSeats.setFont(cFonts.FONT_SIZE_13);

        tblDataSeats = new cTable(cDataSeats.getAllSeats());
        spDataSeats = new cScrollTable(tblDataSeats, 0, 10, 1050, 400);

        panelListSeats.add(spDataSeats);

        panelListSeats.add(labelListDataSeats);
        panelListSeats.add(btnInputDataSeats);
        panelListSeats.add(btnUpdateDataSeats);
        panelListSeats.add(btnDeleteDataSeats);
        panelListUsed.add(labelListUsed);

        bgPanel.add(labelHeaderDataSeats);

        bgPanel.add(panelListSeats);
        bgPanel.add(panelListUsed);
        bgPanel.add(labelCopyright);
    }

    public void loadDataSeats() {
        DefaultTableModel modelTable = cDataSeats.getAllSeats();

        tblDataSeats.setModel(modelTable);

        panelListSeats.revalidate();
        panelListSeats.repaint();

    }

}
