package com.view.staffView.seatsView;

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
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2025. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelInputSeats = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // add label Input Seats
    private cLabelInfo labelNumberSeats = new cLabelInfo("Number Seats", 180, 120, 300, 30);
    private cLabelInfo labelAmountSeats = new cLabelInfo("Amount Seats", 180, 195, 300, 30);
    private cLabelInfo labelDescriptionSeats = new cLabelInfo("Description Seats", 580, 120, 300, 30);
    private cLabelInfo labelStatusSeats = new cLabelInfo("Status Seats", 180, 270, 300, 30);

    // add textfield Input Seats
    private cTextField txtNumberSeats = new cTextField(180, 145, 300);
    private cTextField txtAmountSeats = new cTextField(180, 220, 300);

    private cTextArea txtDescriptionSeats = new cTextArea(580, 145, 300, 200, true);

    // add radion button Input Seats
    private ButtonGroup groupStatusSeats = new ButtonGroup();
    private cRadioButton statusReadySeats = new cRadioButton("Ready", "Active", 180, 305, 100);
    private cRadioButton statusUsedSeats = new cRadioButton("Used", "Inactive", 320, 305, 100);

    // component button Input Seats
    private cButtonRounded btnSaveSeats = new cButtonRounded("Save", 780, 480, 110, 40, 10);
    private cButtonRounded btnResetSeats = new cButtonRounded("Reset", 660, 480, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 180, 480, 110, 40, 10);

    // component error label Input Seats
    private cErrorLabel errorNumberSeats = new cErrorLabel("Number is Empty", 180, 170, 300);
    private cErrorLabel errorAmountSeats = new cErrorLabel("Amount is Empty", 180, 245, 300);
    private cErrorLabel errorDescriptionSeats = new cErrorLabel("Description is Empty", 580, 340, 300);
    private cErrorLabel errorStatusSeats = new cErrorLabel("Status is Empty", 180, 330, 300);

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

        btnResetSeats.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                txtNumberSeats.setText(null);
                txtAmountSeats.setText(null);
                txtDescriptionSeats.setText(null);
                groupStatusSeats.clearSelection();
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
        panelInputSeats.add(labelNumberSeats);
        panelInputSeats.add(labelAmountSeats);
        panelInputSeats.add(labelDescriptionSeats);
        panelInputSeats.add(labelStatusSeats);

        panelInputSeats.add(txtNumberSeats);
        panelInputSeats.add(txtAmountSeats);
        panelInputSeats.add(txtDescriptionSeats);

        groupStatusSeats.add(statusReadySeats);
        groupStatusSeats.add(statusUsedSeats);

        panelInputSeats.add(statusReadySeats);
        panelInputSeats.add(statusUsedSeats);

        panelInputSeats.add(btnSaveSeats);
        panelInputSeats.add(btnResetSeats);
        panelInputSeats.add(btnBackToHome);

        bgPanel.add(panelInputSeats);
        bgPanel.add(labelHeaderDataSeats);
        bgPanel.add(labelCopyright);
    }

    private void handleInsertSeats() {
        try {
            String numberSeatsText = txtNumberSeats.getText().trim();
            String amountSeatsText = txtAmountSeats.getText().trim();
            String descriptionSeats = txtDescriptionSeats.getText().trim();
            String statusSeats = null;

            if (numberSeatsText.isEmpty() || amountSeatsText.isEmpty() || descriptionSeats.isEmpty() ||
                    (!statusReadySeats.isSelected() && !statusUsedSeats.isSelected())) {
                if (numberSeatsText.isEmpty()) {
                    panelInputSeats.add(errorNumberSeats);
                } else {
                    panelInputSeats.remove(errorNumberSeats);
                }
                if (amountSeatsText.isEmpty()) {
                    panelInputSeats.add(errorAmountSeats);
                } else {
                    panelInputSeats.remove(errorAmountSeats);
                }
                if (descriptionSeats.isEmpty()) {
                    panelInputSeats.add(errorDescriptionSeats);
                } else {
                    panelInputSeats.remove(errorDescriptionSeats);
                }
                if (!statusReadySeats.isSelected() && !statusUsedSeats.isSelected()) {
                    panelInputSeats.add(errorStatusSeats);
                } else {
                    panelInputSeats.remove(errorStatusSeats);
                }

                panelInputSeats.revalidate();
                panelInputSeats.repaint();

                return;
            }

            int numberSeats = Integer.parseInt(numberSeatsText);
            int amountSeats = Integer.parseInt(amountSeatsText);

            if (statusReadySeats.isSelected()) {
                statusSeats = "Ready";
            } else if (statusUsedSeats.isSelected()) {
                statusSeats = "Used";
            }

            boolean saveData = cInsertDataSeats.dataSeats(numberSeats, amountSeats, descriptionSeats, statusSeats);
            if (saveData) {
                txtNumberSeats.setText(null);
                txtAmountSeats.setText(null);
                txtDescriptionSeats.setText(null);
                groupStatusSeats.clearSelection();

                JOptionPane.showMessageDialog(this, "Seats successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save seats.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
