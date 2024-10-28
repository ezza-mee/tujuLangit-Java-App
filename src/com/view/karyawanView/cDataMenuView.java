package com.view.karyawanView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;

public class cDataMenuView extends cPanelContentApp {

    // component label header Data menu
    private cBigFont labelHeaderDataMenu = new cBigFont("Menu Data", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component Data Menu
    private cPanelRounded panelListMenu = new cPanelRounded(40, 80, 600, 560, 10, 10);
    private cPanelRounded panelListSold = new cPanelRounded(660, 80, 430, 560, 10, 10);

    // component label data Menu
    private cLabelInfo labelListDataMenu = new cLabelInfo("List Data Menu", 30, 30, 580, 30);
    private cLabelInfo labelListUsed = new cLabelInfo("Menu Sold", 30, 30, 400, 30);

    // component button data Menu
    private cButtonLogin btnInputDataMenu = new cButtonLogin("input", 210, 25, 110, 40, 10);
    private cButtonLogin btnUpdateDataMenu = new cButtonLogin("Update", 330, 25, 110, 40, 10);
    private cButtonLogin btnDeleteDataMenu = new cButtonLogin("Delete", 450, 25, 110, 40, 10);

    public cDataMenuView() {
        super();
        initsDataMenuView();
    }

    public void initsDataMenuView() {
        setVisible(true);

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
