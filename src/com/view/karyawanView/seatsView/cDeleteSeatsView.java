package com.view.karyawanView.seatsView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;
import com.view.karyawanView.cPanelContentView;

public class cDeleteSeatsView extends cPanelContentApp {

    private cPanelContentView parentPanel;

    // add label header
    private cBigFont labelHeaderDataSeats = new cBigFont("Seats", 40, 5);
    private cBigFont labelDeleteDataSeats = new cBigFont("Delete Data Seats", 40, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelDataSeats = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component button delete Seats
    private cButtonRounded btnDeleteSeats = new cButtonRounded("Delete", 660, 460, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 780, 460, 110, 40, 10);

    public cDeleteSeatsView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsDeleteSeatsView();

    }

    private void initsDeleteSeatsView() {
        setVisible(true);

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showProductView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        panelDataSeats.add(labelDeleteDataSeats);

        panelDataSeats.add(btnDeleteSeats);
        panelDataSeats.add(btnBackToHome);

        bgPanel.add(labelHeaderDataSeats);
        bgPanel.add(labelCopyright);
        bgPanel.add(panelDataSeats);
    }

}
