package com.view.adminView.dataStaffView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.main.database.staff.cDataStaff;
import com.main.database.staff.cDeleteDataStaff;
import com.main.database.staff.cSearchDataStaff;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cDataStaffView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    // component label header Data Staff
    private cBigFont labelHeaderDataStaff = new cBigFont("Data Staff", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2025. TujuLangit ForestPark", 0, 650, 1126, 40);

    // componet panel data Staff
    private cPanelRounded panelDataStaff = new cPanelRounded(40, 80, 1050, 560, 10, 10);
    private cPanelRounded panelTableStaff = new cPanelRounded(0, 80, 1050, 560, 0, 0);

    // component Search Data
    private cPanelRounded panelSearch = new cPanelRounded(10, 75, 600, 80, 0, 0);
    private cTextField txtSearchData = new cTextField(75, 13, 300);

    // component label data Staff
    private cLabelInfo labelDataStaff = new cLabelInfo("Data Staff", 40, 30, 300, 30);

    // component button data Staff
    private cButtonRounded btnInputDataStaff = new cButtonRounded("input", 610, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataStaff = new cButtonRounded("Update", 730, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataStaff = new cButtonRounded("Delete", 850, 25, 110, 40, 10);

    private cImage imgSearch = new cImage("src/com/main/resources/images/search(green).png", 40, 18, 18, 18);

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
        refreshContent();

        txtSearchData.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String keyword = txtSearchData.getText();

                tblDataStaff.setModel(cSearchDataStaff.searchStaff(keyword));
                tblDataStaff.getColumnModel().getColumn(0).setMinWidth(80);
                tblDataStaff.getColumnModel().getColumn(0).setMaxWidth(80);
                tblDataStaff.getColumnModel().getColumn(0).setWidth(80);

                tblDataStaff.getColumnModel().getColumn(1).setMinWidth(180);
                tblDataStaff.getColumnModel().getColumn(1).setMaxWidth(180);
                tblDataStaff.getColumnModel().getColumn(1).setWidth(180);

            }
        });

        btnInputDataStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputDataStaffView();
            }
        });

        btnUpdateDataStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedIndex = tblDataStaff.getSelectedRow();

                if (selectedIndex != -1) {
                    String idString = tblDataStaff.getValueAt(selectedIndex, 0).toString();
                    int idStaff = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

                    String nameStaff = tblDataStaff.getValueAt(selectedIndex, 2).toString();
                    String phoneNumber = tblDataStaff.getValueAt(selectedIndex, 3).toString();
                    String email = tblDataStaff.getValueAt(selectedIndex, 4).toString();
                    String jobdesk = tblDataStaff.getValueAt(selectedIndex, 5).toString();
                    String address = tblDataStaff.getValueAt(selectedIndex, 6).toString();
                    String status = tblDataStaff.getValueAt(selectedIndex, 7).toString();

                    parentPanel.showUpdateDataStaffView(idStaff, nameStaff, phoneNumber, email, address, jobdesk,
                            status);
                } else {
                    System.out.println("Pilih Staff untuk diperbarui.");
                }
            }
        });

        btnDeleteDataStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedRow = tblDataStaff.getSelectedRow();
                if (selectedRow != -1) {
                    String idStaffString = tblDataStaff.getValueAt(selectedRow, 0).toString();
                    int idStaff = Integer.parseInt(idStaffString.replaceAll("[^0-9]", ""));

                    boolean deleted = cDeleteDataStaff.handleDeleteDataStaff(idStaff);

                    if (deleted) {
                        DefaultTableModel model = (DefaultTableModel) tblDataStaff.getModel();
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

        tblDataStaff = new cTable(cDataStaff.getAllStaff());
        spDataStaff = new cScrollTable(tblDataStaff, 0, 130, 1050, 400);

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

        panelSearch.add(imgSearch);
        panelSearch.add(txtSearchData);

        panelDataStaff.add(panelSearch);

        bgPanel.add(panelDataStaff);
        bgPanel.add(labelHeaderDataStaff);
        bgPanel.add(labelCopyright);

        loadDataStaff();

        setVisible(true);

    }

    public void loadDataStaff() {
        DefaultTableModel modelTable = cDataStaff.getAllStaff();

        tblDataStaff.setModel(modelTable);

        panelDataStaff.revalidate();
        panelDataStaff.repaint();

        tblDataStaff.getColumnModel().getColumn(0).setMinWidth(80);
        tblDataStaff.getColumnModel().getColumn(0).setMaxWidth(80);
        tblDataStaff.getColumnModel().getColumn(0).setWidth(80);

        tblDataStaff.getColumnModel().getColumn(1).setMinWidth(180);
        tblDataStaff.getColumnModel().getColumn(1).setMaxWidth(180);
        tblDataStaff.getColumnModel().getColumn(1).setWidth(180);

    }
}
