package com.view.StaffView.productView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.*;

public class cDataProductView extends cPanelContentApp {

    private cContentStaffView parentPanel;

    // component label header Data menu
    private cBigFont labelHeaderDataMenu = new cBigFont("Product", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component Data Menu
    private cPanelRounded panelListMenu = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component label data Menu
    private cLabelInfo labelListDataMenu = new cLabelInfo("List Data Menu", 30, 30, 580, 30);

    // component button data Menu

    public cDataProductView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsDataMenuView();
    }

    public void initsDataMenuView() {
        setVisible(true);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelListMenu.add(labelListDataMenu);

        bgPanel.add(labelHeaderDataMenu);

        bgPanel.add(panelListMenu);
        bgPanel.add(labelCopyright);
    }

}
