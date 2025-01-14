package com.view.adminView.reportAdmin;

import javax.swing.JLabel;

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


public class cReportProductView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    // component label header Data Product
    private cBigFont labelHeaderDataProduct = new cBigFont("Report", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component label data Product
    private cLabelInfo labelDataProduct = new cLabelInfo("Data Product", 40, 30, 300, 30);

    // component button Cetak Product
    private cButtonRounded btnPrintProduct = new cButtonRounded("Print", 410, 25, 110, 40, 10);

    // componet panel data Product
    private cPanelRounded panelDataProduct = new cPanelRounded(40, 80, 1050, 560, 10, 10);
    private cPanelRounded panelTableProduct = new cPanelRounded(0, 80, 1050, 560, 10, 10);

    // add combobox jobdesk Product
    private cComboBox boxReportProduct = new cComboBox(
            new String[] { "Product", "Staff", "Supplier" }, 180, 30,
            200, 30);

    // component tabel data supplier
    private cTable tblDataProduct;
    private cScrollTable spDataProduct;

    public cReportProductView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsReportDataProductView();

        spDataProduct = new cScrollTable(tblDataProduct, 0, 80, 1050, 400);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelDataProduct.add(labelDataProduct);
        panelDataProduct.add(spDataProduct);

        panelDataProduct.add(boxReportProduct);

        panelDataProduct.add(btnPrintProduct);

        bgPanel.add(panelDataProduct);
        bgPanel.add(labelHeaderDataProduct);
        bgPanel.add(labelCopyright);
    }

    private void initsReportDataProductView() {
        setVisible(true);
    }
}
