package com.view.adminView.dataStaffView;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.main.database.staff.cDataStaff;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cDataStaffView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    // component label header Data Staff
    private cBigFont labelHeaderDataStaff = new cBigFont("Staff", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // componet panel data Staff
    private cPanelRounded panelDataStaff = new cPanelRounded(40, 80, 1050, 560, 10, 10);
    private cPanelRounded panelTableStaff = new cPanelRounded(0, 80, 1050, 560, 10, 10);

    // component label data Staff
    private cLabelInfo labelDataStaff = new cLabelInfo("Data Staff", 40, 30, 300, 30);

    // component button data Staff
    private cButtonRounded btnInputDataStaff = new cButtonRounded("input", 610, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataStaff = new cButtonRounded("Update", 730, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataStaff = new cButtonRounded("Delete", 850, 25, 110, 40, 10);

    // component tabel data supplier
    private cTable tblDataStaff;
    private cScrollTable spDataStaff;

    public cDataStaffView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsDataStaffView();
    }

    public void refreshContent() {
        try {
            panelTableStaff.removeAll();
            panelTableStaff.revalidate();
            panelTableStaff.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initsDataStaffView() {
        setVisible(true);

        btnInputDataStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputDataStaffView();
            }
        });

        btnUpdateDataStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showUpdateDataStaffView();
            }
        });

        btnDeleteDataStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDeleteDataStaffView();
            }
        });

        tblDataStaff = new cTable(cDataStaff.getAllStaff());
        spDataStaff = new cScrollTable(tblDataStaff, 0, 80, 1050, 400);

        tblDataStaff.getColumnModel().getColumn(0).setMinWidth(80);
        tblDataStaff.getColumnModel().getColumn(0).setMaxWidth(80);
        tblDataStaff.getColumnModel().getColumn(0).setWidth(80);

        tblDataStaff.getColumnModel().getColumn(1).setMinWidth(220);
        tblDataStaff.getColumnModel().getColumn(1).setMaxWidth(220);
        tblDataStaff.getColumnModel().getColumn(1).setWidth(220);

        tblDataStaff.getColumnModel().getColumn(2).setMinWidth(120);
        tblDataStaff.getColumnModel().getColumn(2).setMaxWidth(120);
        tblDataStaff.getColumnModel().getColumn(2).setWidth(120);

        tblDataStaff.getColumnModel().getColumn(3).setMinWidth(180);
        tblDataStaff.getColumnModel().getColumn(3).setMaxWidth(180);
        tblDataStaff.getColumnModel().getColumn(3).setWidth(180);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        btnInputDataStaff.setFont(cFonts.FONT_SIZE_13);
        btnUpdateDataStaff.setFont(cFonts.FONT_SIZE_13);
        btnDeleteDataStaff.setFont(cFonts.FONT_SIZE_13);

        panelDataStaff.add(labelDataStaff);
        panelDataStaff.add(spDataStaff);

        panelDataStaff.add(btnInputDataStaff);
        panelDataStaff.add(btnUpdateDataStaff);
        panelDataStaff.add(btnDeleteDataStaff);

        bgPanel.add(panelDataStaff);
        bgPanel.add(labelHeaderDataStaff);
        bgPanel.add(labelCopyright);

    }
    public void loadDataSuppliers() {
        DefaultTableModel modelTable = cDataStaff.getAllStaff();

        tblDataStaff.setModel(modelTable);

        panelDataStaff.revalidate();
        panelDataStaff.repaint();

        
        tblDataStaff.getColumnModel().getColumn(0).setMinWidth(80);
        tblDataStaff.getColumnModel().getColumn(0).setMaxWidth(80);
        tblDataStaff.getColumnModel().getColumn(0).setWidth(80);

        tblDataStaff.getColumnModel().getColumn(1).setMinWidth(220);
        tblDataStaff.getColumnModel().getColumn(1).setMaxWidth(220);
        tblDataStaff.getColumnModel().getColumn(1).setWidth(220);

        tblDataStaff.getColumnModel().getColumn(2).setMinWidth(120);
        tblDataStaff.getColumnModel().getColumn(2).setMaxWidth(120);
        tblDataStaff.getColumnModel().getColumn(2).setWidth(120);

        tblDataStaff.getColumnModel().getColumn(3).setMinWidth(180);
        tblDataStaff.getColumnModel().getColumn(3).setMaxWidth(180);
        tblDataStaff.getColumnModel().getColumn(3).setWidth(180);

    }
}
