package com.view.adminView.dataProductView;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;
import com.view.adminView.cPanelContentView;

public class cUpdateProductView extends cPanelContentApp {

    // add object cPanelContentView
    private cPanelContentView parentPanel;

    // add label header
    private cBigFont labelHeaderDataProduct = new cBigFont("Product", 40, 5);
    private cBigFont labelInputDataProduct = new cBigFont("Update Data Product", 40, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // add panel Input
    private cPanelRounded panelInputDataProduct = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // add label input
    private cLabelInfo labelNameProduct = new cLabelInfo("Name Product", 180, 120, 300, 30);
    private cLabelInfo labelCountProduct = new cLabelInfo("Count Product", 180, 195, 300, 30);
    private cLabelInfo labelPriceProduct = new cLabelInfo("Price Product", 180, 270, 300, 30);
    private cLabelInfo labelDeskripsiProduct = new cLabelInfo("Deskripsi Product", 580, 120, 300, 30);
    private cLabelInfo labelStatusProduct = new cLabelInfo("Status Product", 180, 345, 300, 30);

    // add textfield input
    private cTextField txtNameProduct = new cTextField(180, 145, 300);
    private cTextField txtCountProduct = new cTextField(180, 220, 300);
    private cTextField txtPriceProduct = new cTextField(180, 295, 300);

    private cTextArea txtDeskripsiProduct = new cTextArea(580, 145, 300, 200, true);

    // add radion button input
    private cRadioButton statusReadyProduct = new cRadioButton("Ready", "Active", 180, 375, 100);
    private cRadioButton statusSoldProduct = new cRadioButton("Sold", "Inactive", 320, 375, 100);

    // component button Input Product
    private cButtonRounded btnSaveProduct = new cButtonRounded("Save", 540, 460, 110, 40, 10);
    private cButtonRounded btnResetProduct = new cButtonRounded("Reset", 660, 460, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 780, 460, 110, 40, 10);

    public cUpdateProductView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        showUpdateProductView();
    }

    private void showUpdateProductView() {
        setVisible(true);

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataProductView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        panelInputDataProduct.add(labelInputDataProduct);

        panelInputDataProduct.add(labelNameProduct);
        panelInputDataProduct.add(labelCountProduct);
        panelInputDataProduct.add(labelPriceProduct);
        panelInputDataProduct.add(labelStatusProduct);
        panelInputDataProduct.add(labelDeskripsiProduct);

        panelInputDataProduct.add(txtNameProduct);
        panelInputDataProduct.add(txtCountProduct);
        panelInputDataProduct.add(txtPriceProduct);

        panelInputDataProduct.add(txtDeskripsiProduct);

        ButtonGroup groupButton = new ButtonGroup();
        groupButton.add(statusReadyProduct);
        groupButton.add(statusSoldProduct);

        panelInputDataProduct.add(statusReadyProduct);
        panelInputDataProduct.add(statusSoldProduct);

        panelInputDataProduct.add(btnSaveProduct);
        panelInputDataProduct.add(btnResetProduct);
        panelInputDataProduct.add(btnBackToHome);

        bgPanel.add(panelInputDataProduct);
        bgPanel.add(labelHeaderDataProduct);
        bgPanel.add(labelCopyright);

    }

}
