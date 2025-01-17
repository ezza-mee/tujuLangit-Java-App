package com.view.adminView.reportAdmin;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.main.database.product.cDataProduct;
import com.main.database.staff.cDataStaff;
import com.main.database.supplier.cDataSupplier;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.cBigFont;
import com.partials.cButtonRounded;
import com.partials.cComboBox;
import com.partials.cFonts;
import com.partials.cLabelInfo;
import com.partials.cPanelRounded;
import com.partials.cScrollTable;
import com.partials.cTable;

public class cDataReportAdminView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    // component label header Data Product
    private cBigFont labelHeaderDataReport = new cBigFont("", 40, 5);

    private cLabelInfo labelListDataReport = new cLabelInfo("List Data Report", 30, 25, 300, 40);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2025. TujuLangit ForestPark", 0, 650, 1126, 40);

    // componet panel report
    private cPanelRounded panelListReport = new cPanelRounded(40, 80, 1050, 560, 10, 10);
    private cPanelRounded panelTableProduct = new cPanelRounded(0, 80, 1050, 400, 0, 0);
    private cPanelRounded panelTableStaff = new cPanelRounded(0, 80, 1050, 400, 0, 0);
    private cPanelRounded panelTableSupplier = new cPanelRounded(0, 80, 1050, 400, 0, 0);

    // component button
    private cButtonRounded btnPrintDataProduct = new cButtonRounded("Print", 410, 25, 110, 40, 10);
    private cButtonRounded btnPrintDataStaff = new cButtonRounded("Print", 410, 25, 110, 40, 10);
    private cButtonRounded btnPrintDataSupplier = new cButtonRounded("Print", 410, 25, 110, 40, 10);

    // add combobox jobdesk Product
    private cComboBox boxDataReport = new cComboBox(
            new String[] { "Product", "Staff", "Supplier" }, 180, 30,
            200, 30);

    // component tabel data supplier
    private cTable tblDataProduct;
    private cScrollTable spDataProduct;

    // component tabel data staff
    private cTable tblDataStaff;
    private cScrollTable spDataStaff;

    // component tabel data supplier
    private cTable tblDataSupplier;
    private cScrollTable spDataSupplier;

    public cDataReportAdminView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsDataReportAdminView();
    }

    private void initsDataReportAdminView() {
        refreshContent();

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        boxDataReport.addActionListener(ae -> {
            String selectedItem = (String) boxDataReport.getSelectedItem();
            clearTablePanels();

            if ("Product".equals(selectedItem)) {
                initsDataProductView();
            } else if ("Staff".equals(selectedItem)) {
                initsDataStaffView();
            } else if ("Supplier".equals(selectedItem)) {
                initsDataSupplierView();
            }

            panelListReport.revalidate();
            panelListReport.repaint();
        });

        panelListReport.add(boxDataReport);
        panelListReport.add(labelListDataReport);

        bgPanel.add(labelCopyright);
        bgPanel.add(panelListReport);
        bgPanel.add(labelHeaderDataReport);

        initsDataProductView();
        setVisible(true);
    }

    private void clearTablePanels() {
        
        panelTableProduct.removeAll();
        panelTableStaff.removeAll();
        panelTableSupplier.removeAll();

        panelListReport.remove(panelTableProduct);
        panelListReport.remove(panelTableStaff);
        panelListReport.remove(panelTableSupplier);

        panelListReport.remove(btnPrintDataProduct);
        panelListReport.remove(btnPrintDataStaff);
        panelListReport.remove(btnPrintDataSupplier);
    }

    private void initsDataProductView() {
        labelHeaderDataReport.setText("Data Product");

        tblDataProduct = new cTable(cDataProduct.getAllDataProduct());
        spDataProduct = new cScrollTable(tblDataProduct, 0, 0, 1050, 400);

        panelTableProduct.add(spDataProduct);

        panelListReport.add(panelTableProduct);
        panelListReport.add(btnPrintDataProduct);

        loadDataProduct();
    }

    private void initsDataStaffView() {
        labelHeaderDataReport.setText("Data Staff");

        tblDataStaff = new cTable(cDataStaff.getAllStaff());
        spDataStaff = new cScrollTable(tblDataStaff, 0, 0, 1050, 400);

        panelTableStaff.add(spDataStaff);

        panelListReport.add(panelTableStaff);
        panelListReport.add(btnPrintDataStaff);

        loadDataStaff();
    }

    private void initsDataSupplierView() {
        labelHeaderDataReport.setText("Data Supplier");

        tblDataSupplier = new cTable(cDataSupplier.getAllSupplier());
        spDataSupplier = new cScrollTable(tblDataSupplier, 0, 0, 1050, 400);

        panelTableSupplier.add(spDataSupplier);

        panelListReport.add(panelTableSupplier);
        panelListReport.add(btnPrintDataSupplier);

        loadDataSupplier();
    }

    public void refreshContent() {
        try {
            clearTablePanels();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void loadDataProduct() {
        DefaultTableModel modelTableProduct = cDataProduct.getAllDataProduct();
        tblDataProduct.setModel(modelTableProduct);
    }

    public void loadDataStaff() {
        DefaultTableModel modelTableStaff = cDataStaff.getAllStaff();
        tblDataStaff.setModel(modelTableStaff);
    }

    public void loadDataSupplier() {
        DefaultTableModel modelTableSupplier = cDataSupplier.getAllSupplier();
        tblDataSupplier.setModel(modelTableSupplier);
    }
}
