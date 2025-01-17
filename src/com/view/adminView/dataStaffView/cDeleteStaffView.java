package com.view.adminView.dataStaffView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cDeleteStaffView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    // add label header Staff
    private cBigFont labelHeaderStaff = new cBigFont("Data Staff", 40, 5);
    private cBigFont labelDeleteStaff = new cBigFont("Delete Data Staff", 40, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2025. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component panel Data Staff
    private cPanelRounded panelDataStaff = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component button delete Staff
    private cButtonRounded btnDeleteStaff = new cButtonRounded("Delete", 660, 460, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 780, 460, 110, 40, 10);

    public cDeleteStaffView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsDeleteStaffView();
    }

    private void initsDeleteStaffView() {
        setVisible(true);

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataStaffView();
            }
        });

        btnDeleteStaff.setFont(cFonts.FONT_SIZE_13);
        btnBackToHome.setFont(cFonts.FONT_SIZE_13);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelDataStaff.add(labelDeleteStaff);

        panelDataStaff.add(btnDeleteStaff);
        panelDataStaff.add(btnBackToHome);

        bgPanel.add(panelDataStaff);
        bgPanel.add(labelHeaderStaff);
        bgPanel.add(labelCopyright);
    }

}
