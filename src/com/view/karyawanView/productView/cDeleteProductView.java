package com.view.karyawanView.productView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentKaryawanView;
import com.partials.*;

public class cDeleteProductView extends cPanelContentApp {

    private cContentKaryawanView parentPanel;

    // add label header
    private cBigFont labelHeaderDataProduct = new cBigFont("Product", 40, 5);
    private cBigFont labelDeleteDataProduct = new cBigFont("Delete Data Product", 40, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelDataProduct = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component button delete Product
    private cButtonRounded btnDeleteProduct = new cButtonRounded("Delete", 660, 460, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 780, 460, 110, 40, 10);

    public cDeleteProductView(cContentKaryawanView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsDeleteProductView();
    }

    private void initsDeleteProductView() {
        setVisible(true);

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showProductView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelDataProduct.add(labelDeleteDataProduct);

        panelDataProduct.add(btnDeleteProduct);
        panelDataProduct.add(btnBackToHome);

        bgPanel.add(labelHeaderDataProduct);
        bgPanel.add(labelCopyright);
        bgPanel.add(panelDataProduct);
    }
}
