package com.view.adminView.reportAdmin;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.main.database.staff.cDataStaff;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cReportStaffView extends cPanelContentApp {

        // component label header Data Staff
        private cBigFont labelHeaderDataStaff = new cBigFont("Report", 40, 5);

        // component copyright
        private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);
    
        // componet panel data Staff
        private cPanelRounded panelDataStaff = new cPanelRounded(40, 80, 1050, 560, 10, 10);
        private cPanelRounded panelTableStaff = new cPanelRounded(0, 80, 1050, 560, 10, 10);

        // component button Cetak Staff
        private cButtonRounded btnPrintStaff = new cButtonRounded("Print", 410, 25, 110, 40, 10);
    
        // component label data Staff
        private cLabelInfo labelDataStaff = new cLabelInfo("Data Staff", 40, 30, 300, 30);
    
        // component tabel data staff
        private cTable tblDataStaff;
        private cScrollTable spDataStaff;

        // add combobox Report Staff
        private cComboBox boxReportStaff = new cComboBox(
            new String[] { "Product", "Staff", "Supplier" }, 180, 30,
            200, 30);

    private cContentAdminView parentPanel;

    public cReportStaffView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        
        initsReportDataStaffView();
    }

    private void initsReportDataStaffView() {
        setVisible(true);
        tblDataStaff = new cTable(cDataStaff.getAllStaff());
        spDataStaff = new cScrollTable(tblDataStaff, 0, 80, 1050, 400);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelDataStaff.add(labelDataStaff);
        panelDataStaff.add(spDataStaff);

        panelDataStaff.add(boxReportStaff);

        panelDataStaff.add(btnPrintStaff);

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

        tblDataStaff.getColumnModel().getColumn(1).setMinWidth(220);
        tblDataStaff.getColumnModel().getColumn(1).setMaxWidth(220);
        tblDataStaff.getColumnModel().getColumn(1).setWidth(220);

        tblDataStaff.getColumnModel().getColumn(2).setMinWidth(150);
        tblDataStaff.getColumnModel().getColumn(2).setMaxWidth(150);
        tblDataStaff.getColumnModel().getColumn(2).setWidth(150);

        tblDataStaff.getColumnModel().getColumn(3).setMinWidth(200);
        tblDataStaff.getColumnModel().getColumn(3).setMaxWidth(200);
        tblDataStaff.getColumnModel().getColumn(3).setWidth(200);

        tblDataStaff.getColumnModel().getColumn(4).setMinWidth(160);
        tblDataStaff.getColumnModel().getColumn(4).setMaxWidth(160);
        tblDataStaff.getColumnModel().getColumn(4).setWidth(160);

        tblDataStaff.getColumnModel().getColumn(5).setMinWidth(170);
        tblDataStaff.getColumnModel().getColumn(5).setMaxWidth(170);
        tblDataStaff.getColumnModel().getColumn(5).setWidth(170);

        tblDataStaff.getColumnModel().getColumn(6).setMinWidth(70);
        tblDataStaff.getColumnModel().getColumn(6).setMaxWidth(70);
        tblDataStaff.getColumnModel().getColumn(6).setWidth(70);

    }
}
