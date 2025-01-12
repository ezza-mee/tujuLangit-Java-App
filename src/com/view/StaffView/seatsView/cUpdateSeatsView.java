package com.view.StaffView.seatsView;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.main.database.seats.cUpdateDataSeats;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.*;

public class cUpdateSeatsView extends cPanelContentApp {

    private cContentStaffView parentPanel;

    // component header data Seats
    private cBigFont labelHeaderDataSeats = new cBigFont("Seats", 40, 5);
    private cBigFont labelUpdateDataSeats = new cBigFont("Update Data Seats", 40, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelUpdateSeats = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // add label Update Seats
    private cLabelInfo labelNumberSeats = new cLabelInfo("Number Seats", 180, 120, 300, 30);
    private cLabelInfo labelAmountSeats = new cLabelInfo("Amount Seats", 180, 195, 300, 30);
    private cLabelInfo labelDescriptionSeats = new cLabelInfo("Description Seats", 580, 120, 300, 30);
    private cLabelInfo labelStatusSeats = new cLabelInfo("Status Seats", 180, 270, 300, 30);

    // add textfield Update Seats
    private cTextField txtNumberSeats = new cTextField(180, 145, 300);
    private cTextField txtAmountSeats = new cTextField(180, 220, 300);

    private cTextArea txtDescriptionSeats = new cTextArea(580, 145, 300, 200, true);

    // add radion button Update Seats
    private ButtonGroup groupStatusSeats = new ButtonGroup();
    private cRadioButton statusReadySeats = new cRadioButton("Ready", "Active", 180, 305, 100);
    private cRadioButton statusUsedSeats = new cRadioButton("Used", "Inactive", 320, 305, 100);

    // component button Update Seats
    private cButtonRounded btnSaveSeats = new cButtonRounded("Save", 780, 480, 110, 40, 10);
    private cButtonRounded btnResetSeats = new cButtonRounded("Reset", 660, 480, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 180, 480, 110, 40, 10);

    // component error label Update Seats
    private cErrorLabel errorNumberSeats = new cErrorLabel("Number is Empty", 180, 170, 300);
    private cErrorLabel errorAmountSeats = new cErrorLabel("Amount is Empty", 180, 245, 300);
    private cErrorLabel errorDescriptionSeats = new cErrorLabel("Description is Empty", 580, 340, 300);
    private cErrorLabel errorStatusSeats = new cErrorLabel("Status is Empty", 180, 330, 300);

    private int idSeats;

    public cUpdateSeatsView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsUpdateSeatsView();
    }

    public void setDataSeats(int idSeats, String NumberSeats, int amountSeats, String descriptionSeats,
            String statusSeats) {
        this.idSeats = idSeats;

        txtNumberSeats.setText(NumberSeats);
        txtAmountSeats.setText(String.valueOf(amountSeats));
        txtDescriptionSeats.setText(descriptionSeats);

        if (statusSeats.equalsIgnoreCase("Ready")) {
            statusReadySeats.setSelected(true);
            statusUsedSeats.setSelected(false);
        } else {
            statusReadySeats.setSelected(false);
            statusUsedSeats.setSelected(true);
        }

    }

    private void initsUpdateSeatsView() {

        btnSaveSeats.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                handleUpdateSeats(idSeats);
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

        panelUpdateSeats.add(labelUpdateDataSeats);
        panelUpdateSeats.add(labelNumberSeats);
        panelUpdateSeats.add(labelAmountSeats);
        panelUpdateSeats.add(labelDescriptionSeats);
        panelUpdateSeats.add(labelStatusSeats);

        panelUpdateSeats.add(txtNumberSeats);
        panelUpdateSeats.add(txtAmountSeats);
        panelUpdateSeats.add(txtDescriptionSeats);

        groupStatusSeats.add(statusReadySeats);
        groupStatusSeats.add(statusUsedSeats);

        panelUpdateSeats.add(statusReadySeats);
        panelUpdateSeats.add(statusUsedSeats);

        panelUpdateSeats.add(btnSaveSeats);
        panelUpdateSeats.add(btnResetSeats);
        panelUpdateSeats.add(btnBackToHome);

        bgPanel.add(panelUpdateSeats);
        bgPanel.add(labelHeaderDataSeats);
        bgPanel.add(labelCopyright);

        setVisible(true);

    }

    private void handleUpdateSeats(int idSeats) {
        try {
            String numberSeatsText = txtNumberSeats.getText().trim();
            String amountSeatsText = txtAmountSeats.getText().trim();
            String descriptionSeats = txtDescriptionSeats.getText().trim();
            String statusSeats = null;

            if (numberSeatsText.isEmpty() || amountSeatsText.isEmpty() || descriptionSeats.isEmpty() ||
                    (!statusReadySeats.isSelected() && !statusUsedSeats.isSelected())) {
                if (numberSeatsText.isEmpty()) {
                    panelUpdateSeats.add(errorNumberSeats);
                } else {
                    panelUpdateSeats.remove(errorNumberSeats);
                }
                if (amountSeatsText.isEmpty()) {
                    panelUpdateSeats.add(errorAmountSeats);
                } else {
                    panelUpdateSeats.remove(errorAmountSeats);
                }
                if (descriptionSeats.isEmpty()) {
                    panelUpdateSeats.add(errorDescriptionSeats);
                } else {
                    panelUpdateSeats.remove(errorDescriptionSeats);
                }
                if (!statusReadySeats.isSelected() && !statusUsedSeats.isSelected()) {
                    panelUpdateSeats.add(errorStatusSeats);
                } else {
                    panelUpdateSeats.remove(errorStatusSeats);
                }

                panelUpdateSeats.revalidate();
                panelUpdateSeats.repaint();

                return;
            }

            int numberSeats = Integer.parseInt(numberSeatsText);
            int amountSeats = Integer.parseInt(amountSeatsText);

            if (statusReadySeats.isSelected()) {
                statusSeats = "Ready";
            } else if (statusUsedSeats.isSelected()) {
                statusSeats = "Used";
            }

            boolean saveData = cUpdateDataSeats.handleUpdateSeats(idSeats, numberSeats, amountSeats, descriptionSeats,
                    statusSeats);
            if (saveData) {
                txtNumberSeats.setText(null);
                txtAmountSeats.setText(null);
                txtDescriptionSeats.setText(null);
                groupStatusSeats.clearSelection();

                JOptionPane.showMessageDialog(this, "Update Data successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Update Data.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
