package com.view.karyawanView.seatsView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;
import com.view.karyawanView.cPanelContentView;

public class cDataSeatsView extends cPanelContentApp {

    private cPanelContentView parentPanel;

    // component header data Seats
    private cBigFont labelHeaderDataSeats = new cBigFont("Seats", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component Data Seats
    private cPanelRounded panelListSeats = new cPanelRounded(40, 80, 600, 560, 10, 10);
    private cPanelRounded panelListUsed = new cPanelRounded(660, 80, 430, 560, 10, 10);

    // component label data Seats
    private cLabelInfo labelListDataSeats = new cLabelInfo("List Data Seats", 30, 30, 580, 30);
    private cLabelInfo labelListUsed = new cLabelInfo("Seats Used", 30, 30, 400, 30);

    // component button data Seats
    private cButtonRounded btnInputDataSeats = new cButtonRounded("input", 210, 25, 110, 40, 10);
    private cButtonRounded btnUpdateDataSeats = new cButtonRounded("Update", 330, 25, 110, 40, 10);
    private cButtonRounded btnDeleteDataSeats = new cButtonRounded("Delete", 450, 25, 110, 40, 10);

    public cDataSeatsView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsDataSeatsView();
    }

    public void initsDataSeatsView() {
        setVisible(true);

        btnInputDataSeats.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showInputDataSeatsView();
            }
        });

        btnUpdateDataSeats.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showUpdateDataSeatsView();
            }
        });

        btnDeleteDataSeats.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDeleteDataSeatsView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        btnInputDataSeats.setFont(cFonts.BUTTON_INPUT_FONT);
        btnUpdateDataSeats.setFont(cFonts.BUTTON_INPUT_FONT);
        btnDeleteDataSeats.setFont(cFonts.BUTTON_INPUT_FONT);

        panelListSeats.add(labelListDataSeats);
        panelListSeats.add(btnInputDataSeats);
        panelListSeats.add(btnUpdateDataSeats);
        panelListSeats.add(btnDeleteDataSeats);
        panelListUsed.add(labelListUsed);

        bgPanel.add(labelHeaderDataSeats);

        bgPanel.add(panelListSeats);
        bgPanel.add(panelListUsed);
        bgPanel.add(labelCopyright);
    }

}
