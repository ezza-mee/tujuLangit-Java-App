package com.view.StaffView.seatsView;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.main.database.seats.cInsertDataSeats;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.*;

public class cInputSeatsView extends cPanelContentApp {

    private cContentStaffView parentPanel;

    // component header data Seats
    private cBigFont labelHeaderDataSeats = new cBigFont("Seats", 40, 5);
    private cBigFont labelInputDataSeats = new cBigFont("Input Data Seats", 40, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelInputSeats = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // add label input Seats
    private cLabelInfo labelTypeSeats = new cLabelInfo("Type Seats", 180, 195, 300, 30);
    private cLabelInfo labelAmountSeats = new cLabelInfo("Amount Seats", 180, 270, 300, 30);
    private cLabelInfo labelDeskripsiSeats = new cLabelInfo("Deskripsi Seats", 580, 120, 300, 30);
    private cLabelInfo labelStatusSeats = new cLabelInfo("Status Seats", 180, 345, 300, 30);

    // add textfield input Seats
    private cTextField txtTypeSeats = new cTextField(180, 220, 300);
    private cTextField txtAmountSeats = new cTextField(180, 295, 300);

    private cTextArea txtDeskripsiSeats = new cTextArea(580, 145, 300, 200, true);

    // add radion button input Seats
    private cRadioButton statusReadySeats = new cRadioButton("Ready", "Active", 180, 375, 100);
    private cRadioButton statusSoldSeats = new cRadioButton("Used", "Inactive", 320, 375, 100);

    // component button Input Seats
    private cButtonRounded btnSaveSeats = new cButtonRounded("Save", 540, 460, 110, 40, 10);
    private cButtonRounded btnResetSeats = new cButtonRounded("Reset", 660, 460, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 780, 460, 110, 40, 10);

    public cInputSeatsView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        showInputSeatsView();
    }

    public void showInputSeatsView() {
        setVisible(true);

        btnSaveSeats.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                handleInsertSeats();
            }
        });

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showSeatsView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelInputSeats.add(labelInputDataSeats);
        panelInputSeats.add(labelTypeSeats);
        panelInputSeats.add(labelAmountSeats);
        panelInputSeats.add(labelDeskripsiSeats);
        panelInputSeats.add(labelStatusSeats);

        panelInputSeats.add(txtTypeSeats);
        panelInputSeats.add(txtAmountSeats);
        panelInputSeats.add(txtDeskripsiSeats);

        ButtonGroup groupButton = new ButtonGroup();
        groupButton.add(statusReadySeats);
        groupButton.add(statusSoldSeats);

        panelInputSeats.add(statusReadySeats);
        panelInputSeats.add(statusSoldSeats);

        panelInputSeats.add(btnSaveSeats);
        panelInputSeats.add(btnResetSeats);
        panelInputSeats.add(btnBackToHome);

        bgPanel.add(panelInputSeats);
        bgPanel.add(labelHeaderDataSeats);
        bgPanel.add(labelCopyright);
    }

    private void handleInsertSeats() {
        try {
            String typeSeats = txtTypeSeats.getText().trim();
            String amountSeatsText = txtAmountSeats.getText().trim();
            String deskripsiSeats = txtDeskripsiSeats.getText().trim();
            String statusSeats = null;

            int amountSeats = 0;
            amountSeats = Integer.parseInt(amountSeatsText);

            if (statusReadySeats.isSelected()) {
                statusSeats = "Ready";
            } else if (statusSoldSeats.isSelected()) {
                statusSeats = "Used";
            }

            boolean saveData = cInsertDataSeats.dataSeats(typeSeats, amountSeats, deskripsiSeats, statusSeats);
            if (saveData) {
                txtTypeSeats.setText(null);
                txtAmountSeats.setText(null);
                txtDeskripsiSeats.setText(null);
                
                JOptionPane.showMessageDialog(this, "Seats successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save seats.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
