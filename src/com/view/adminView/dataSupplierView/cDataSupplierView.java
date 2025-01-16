package com.view.adminView.dataSupplierView;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.main.database.supplier.cDataSupplier;
import com.main.database.supplier.cDeleteDataSupplier;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cDataSupplierView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    // component label header Data Supplier
    private cBigFont labelHeaderDataSupplier = new cBigFont("Supplier", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component panel data Supplier
    private cPanelRounded panelDataSupplier = new cPanelRounded(40, 80, 1050, 560, 10, 10);
    private cPanelRounded panelTableSupplier = new cPanelRounded(0, 80, 1050, 560, 10, 10);

    // component Search Data
    private cTextField txtSearchData = new cTextField(75, 75, 300);

    // component label data Supplier
    private cLabelInfo labelDataSupplier = new cLabelInfo("Data Supplier", 40, 30, 300, 30);

    // component button data Supplier
    private cButtonRounded btnInputDataSupplier = new cButtonRounded("input", 610, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataSupplier = new cButtonRounded("Update", 730, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataSupplier = new cButtonRounded("Delete", 850, 25, 110, 40, 10);

    // component tabel data supplier
    private cTable tblDataSupplier;
    private cScrollTable spDataSupplier;

    public cDataSupplierView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsDataSupplierView();
    }

    public void refreshContent() {
        try {
            panelTableSupplier.removeAll();
            panelTableSupplier.revalidate();
            panelTableSupplier.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initsDataSupplierView() {
        refreshContent();

        btnInputDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputDataSupplierView();
            }
        });

        btnUpdateDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedIndex = tblDataSupplier.getSelectedRow();

                if (selectedIndex != -1) {
                    String idString = tblDataSupplier.getValueAt(selectedIndex, 0).toString();
                    int idSupplier = Integer.parseInt(idString.replaceAll("[^0-9]", ""));

                    String typeSupplier = tblDataSupplier.getValueAt(selectedIndex, 1).toString();
                    int supplierAmount = Integer.parseInt(tblDataSupplier.getValueAt(selectedIndex, 2).toString());
                    String priceTotalString = tblDataSupplier.getValueAt(selectedIndex, 3).toString();
                    priceTotalString = priceTotalString.replaceAll("[^0-9]", "");
                    int priceTotal = Integer.parseInt(priceTotalString);
                    String descriptionProduct = tblDataSupplier.getValueAt(selectedIndex, 4).toString();

                    parentPanel.showUpdateDataSupplierView(idSupplier, typeSupplier, supplierAmount, priceTotal,
                            descriptionProduct);
                } else {
                    System.out.println("Pilih supplier untuk diperbarui.");
                }
            }
        });

        btnDeleteDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                int selectedRow = tblDataSupplier.getSelectedRow();
                if (selectedRow != -1) {
                    String idSupplierString = tblDataSupplier.getValueAt(selectedRow, 0).toString();
                    int idSupplier = Integer.parseInt(idSupplierString.replaceAll("[^0-9]", ""));

                    boolean deleted = cDeleteDataSupplier.handleDeleteDataSupplier(idSupplier);

                    if (deleted) {
                        DefaultTableModel model = (DefaultTableModel) tblDataSupplier.getModel();
                        model.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Supplier berhasil dihapus!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Gagal menghapus supplier.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih supplier yang akan dihapus.");
                }
            }
        });

        tblDataSupplier = new cTable(cDataSupplier.getAllSupplier());
        spDataSupplier = new cScrollTable(tblDataSupplier, 0, 50, 1050, 400);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        btnInputDataSupplier.setFont(cFonts.FONT_SIZE_13);
        btnUpdateDataSupplier.setFont(cFonts.FONT_SIZE_13);
        btnDeleteDataSupplier.setFont(cFonts.FONT_SIZE_13);

        panelDataSupplier.add(labelDataSupplier);

        panelDataSupplier.add(btnInputDataSupplier);
        panelDataSupplier.add(btnUpdateDataSupplier);
        panelDataSupplier.add(btnDeleteDataSupplier);
        panelDataSupplier.add(txtSearchData);

        panelTableSupplier.add(spDataSupplier);
        panelDataSupplier.add(panelTableSupplier);

        bgPanel.add(panelDataSupplier);
        bgPanel.add(labelHeaderDataSupplier);
        bgPanel.add(labelCopyright);

        loadDataSuppliers();

        setVisible(true);
    }

    public void loadDataSuppliers() {
        DefaultTableModel modelTable = cDataSupplier.getAllSupplier();

        tblDataSupplier.setModel(modelTable);

        panelDataSupplier.revalidate();
        panelDataSupplier.repaint();

        tblDataSupplier.getColumnModel().getColumn(0).setMinWidth(80);
        tblDataSupplier.getColumnModel().getColumn(0).setMaxWidth(80);
        tblDataSupplier.getColumnModel().getColumn(0).setWidth(80);

        tblDataSupplier.getColumnModel().getColumn(1).setMinWidth(220);
        tblDataSupplier.getColumnModel().getColumn(1).setMaxWidth(220);
        tblDataSupplier.getColumnModel().getColumn(1).setWidth(220);

        tblDataSupplier.getColumnModel().getColumn(2).setMinWidth(120);
        tblDataSupplier.getColumnModel().getColumn(2).setMaxWidth(120);
        tblDataSupplier.getColumnModel().getColumn(2).setWidth(120);

        tblDataSupplier.getColumnModel().getColumn(3).setMinWidth(180);
        tblDataSupplier.getColumnModel().getColumn(3).setMaxWidth(180);
        tblDataSupplier.getColumnModel().getColumn(3).setWidth(180);

    }

}
