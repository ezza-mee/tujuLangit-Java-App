package com.view.karyawanView.productView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;
import com.view.karyawanView.cPanelContentView;

public class cDataProductView extends cPanelContentApp {

    private cPanelContentView parentPanel;

    // component label header Data menu
    private cBigFont labelHeaderDataMenu = new cBigFont("Product", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component Data Menu
    private cPanelRounded panelListMenu = new cPanelRounded(40, 80, 600, 560, 10, 10);
    private cPanelRounded panelListSold = new cPanelRounded(660, 80, 430, 560, 10, 10);

    // component label data Menu
    private cLabelInfo labelListDataMenu = new cLabelInfo("List Data Menu", 30, 30, 580, 30);
    private cLabelInfo labelListUsed = new cLabelInfo("Menu Sold", 30, 30, 400, 30);

    // component button data Menu
    private cButtonRounded btnInputDataMenu = new cButtonRounded("input", 210, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataMenu = new cButtonRounded("Update", 330, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataMenu = new cButtonRounded("Delete", 450, 25, 110, 40, 10);

    public cDataProductView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsDataMenuView();
    }

    public void initsDataMenuView() {
        setVisible(true);

        btnInputDataMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputDataProductView();
            }
        });

        btnUpdateDataMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showUpdateDataProductView();
            }
        });

        btnDeleteDataMenu.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDeleteDataProductView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        btnInputDataMenu.setFont(cFonts.BUTTON_INPUT_FONT);
        btnUpdateDataMenu.setFont(cFonts.BUTTON_INPUT_FONT);
        btnDeleteDataMenu.setFont(cFonts.BUTTON_INPUT_FONT);

        panelListMenu.add(labelListDataMenu);
        panelListMenu.add(btnInputDataMenu);
        panelListMenu.add(btnUpdateDataMenu);
        panelListMenu.add(btnDeleteDataMenu);
        panelListSold.add(labelListUsed);

        bgPanel.add(labelHeaderDataMenu);

        bgPanel.add(panelListMenu);
        bgPanel.add(panelListSold);
        bgPanel.add(labelCopyright);
    }

}
