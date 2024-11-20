package com.view.adminView.dataStaffView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cDataStaffView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    // component label header Data Staff
    private cBigFont labelHeaderDataStaff = new cBigFont("Staff", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // componet panel data Staff
    private cPanelRounded panelDataStaff = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component label data Staff
    private cLabelInfo labelDataStaff = new cLabelInfo("Data Staff", 40, 30, 300, 30);

    // component button data Staff
    private cButtonRounded btnInputDataStaff = new cButtonRounded("input", 610, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataStaff = new cButtonRounded("Update", 730, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataStaff = new cButtonRounded("Delete", 850, 25, 110, 40, 10);

    public cDataStaffView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsDataStaffView();
    }

    private void initsDataStaffView() {
        setVisible(true);

        btnInputDataStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputDataStaffView();
            }
        });

        btnUpdateDataStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showUpdateDataStaffView();
            }
        });

        btnDeleteDataStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDeleteDataStaffView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        btnInputDataStaff.setFont(cFonts.FONT_SIZE_13);
        btnUpdateDataStaff.setFont(cFonts.FONT_SIZE_13);
        btnDeleteDataStaff.setFont(cFonts.FONT_SIZE_13);

        panelDataStaff.add(labelDataStaff);

        panelDataStaff.add(btnInputDataStaff);
        panelDataStaff.add(btnUpdateDataStaff);
        panelDataStaff.add(btnDeleteDataStaff);

        bgPanel.add(panelDataStaff);
        bgPanel.add(labelHeaderDataStaff);
        bgPanel.add(labelCopyright);
    }
}
