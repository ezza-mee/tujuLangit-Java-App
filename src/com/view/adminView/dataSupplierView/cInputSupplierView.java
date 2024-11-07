package com.view.adminView.dataSupplierView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;
import com.view.adminView.cPanelContentView;

public class cInputSupplierView extends cPanelContentApp {

    private cPanelContentView parentPanel;

    // component label header Input Supplier
    private cBigFont labelHeaderInputSupplier = new cBigFont("Input Data", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelInputSupplier = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component Input Supplier
    private cLabelInfo labelNameCompany = new cLabelInfo("Name Company", 180, 120, 300, 30);
    private cLabelInfo labelTypeSupplier = new cLabelInfo("Type Supplier", 180, 195, 300, 30);
    private cLabelInfo labelSupplierAmount = new cLabelInfo("Supplier Amount", 180, 270, 300, 30);
    private cLabelInfo labelPriceTotal = new cLabelInfo("Price Total", 580, 120, 300, 30);
    private cLabelInfo labelDescriptionProduct = new cLabelInfo("Description Product", 580, 195, 300, 30);

    // add textfield input product
    private cTextField txtNameCompany = new cTextField(180, 145, 300);
    private cTextField txtTypeSupplier = new cTextField(180, 220, 300);
    private cTextField txtSupplierAmount = new cTextField(180, 295, 300);
    private cTextField txtPriceTotal = new cTextField(580, 145, 300);
    private cTextArea txtDescriptionProduct = new cTextArea(580, 220, 300, 100, true);

    // component button Input Product
    private cButtonRounded btnSaveSupplier = new cButtonRounded("Save", 540, 460, 110, 40, 10);
    private cButtonRounded btnResetSupplier = new cButtonRounded("Reset", 660, 460, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 780, 460, 110, 40, 10);

    public cInputSupplierView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsInputSupplierView();
    }

    private void initsInputSupplierView() {
        setVisible(true);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        panelInputSupplier.add(labelNameCompany);
        panelInputSupplier.add(labelTypeSupplier);
        panelInputSupplier.add(labelSupplierAmount);
        panelInputSupplier.add(labelPriceTotal);
        panelInputSupplier.add(labelDescriptionProduct);

        panelInputSupplier.add(txtNameCompany);
        panelInputSupplier.add(txtTypeSupplier);
        panelInputSupplier.add(txtSupplierAmount);
        panelInputSupplier.add(txtPriceTotal);
        panelInputSupplier.add(txtDescriptionProduct);

        panelInputSupplier.add(btnSaveSupplier);
        panelInputSupplier.add(btnResetSupplier);
        panelInputSupplier.add(btnBackToHome);

        bgPanel.add(panelInputSupplier);
        bgPanel.add(labelHeaderInputSupplier);
        bgPanel.add(labelCopyright);
    }

}
