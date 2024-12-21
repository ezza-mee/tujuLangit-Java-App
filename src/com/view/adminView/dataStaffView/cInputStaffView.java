package com.view.adminView.dataStaffView;

import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.main.database.staff.cInsertDataStaff;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cInputStaffView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    // component label header Data Staff
    private cBigFont labelHeaderDataStaff = new cBigFont("Staff", 40, 5);
    private cBigFont labelInputDataStaff = new cBigFont("Input Data Staff", 180, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component panel Data Staff
    private cPanelRounded panelInputStaff = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component label Data Staff
    private cLabelInfo labelNameStaff = new cLabelInfo("Name", 180, 120, 300, 30);
    private cLabelInfo labelNomorHpStaff = new cLabelInfo("Nomor Hp", 180, 195, 300, 30);
    private cLabelInfo labelEmailStaff = new cLabelInfo("Email", 180, 270, 300, 30);
    private cLabelInfo labelJobdeskStaff = new cLabelInfo("Jobdesk", 580, 120, 300, 30);
    private cLabelInfo labelAddressStaff = new cLabelInfo("Address", 580, 195, 300, 30);
    private cLabelInfo labelStatusStaff = new cLabelInfo("Status", 580, 345, 300, 30);

    // add textfield input Staff
    private cTextField txtNameStaff = new cTextField(180, 145, 300);
    private cTextField txtPhoneNumberStaff = new cTextField(180, 220, 300);
    private cTextField txtEmailStaff = new cTextField(180, 295, 300);

    private cTextArea txtAddressStaff = new cTextArea(580, 220, 300, 100, true);

    // add combobox jobdesk Staff
    private cComboBox boxJobdeskStaff = new cComboBox(
            new String[] { "Jodesk", "Cashier", "Barista", "Manager", "Waiter", "Cleaning staff", "Owner" }, 580, 145,
            300, 30);

    // add radion button status Staff
    private ButtonGroup groupStatusStaff = new ButtonGroup();
    private cRadioButton statusAktif = new cRadioButton("Active", "Active", 580, 375, 100);
    private cRadioButton statusInAktif = new cRadioButton("Inactive", "Inactive", 700, 375, 100);

    // component button Input Staff
    private cButtonRounded btnSaveStaff = new cButtonRounded("Save", 780, 480, 110, 40, 10);
    private cButtonRounded btnResetStaff = new cButtonRounded("Reset", 660, 480, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 180, 480, 110, 40, 10);

    // component error label input product
    private cErrorLabel errorNameStaff = new cErrorLabel("Name is Empty", 180, 175, 300);
    private cErrorLabel errorEmailStaff = new cErrorLabel("Email is Empty", 180, 260, 300);
    private cErrorLabel errorPhoneNumberStaff = new cErrorLabel("Phone number is Empty", 180, 345, 300);
    private cErrorLabel errorJobdeskStaff = new cErrorLabel("Jobdesk is Empty", 180, 430, 300);
    private cErrorLabel errorAddressStaff = new cErrorLabel("address is Empty", 580, 175, 300);
    private cErrorLabel errorlabelStatusStaff = new cErrorLabel("Status is Empty", 580, 345, 300);

    public cInputStaffView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsInputStaff();
    }

    private void initsInputStaff() {
        setVisible(true);

        btnSaveStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                handleInsertStaff();
            }
        });

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataStaffView();
            }
        });

        groupStatusStaff.add(statusAktif);
        groupStatusStaff.add(statusInAktif);

        btnResetStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                txtNameStaff.setText(null);
                txtPhoneNumberStaff.setText(null);
                txtEmailStaff.setText(null);
                txtAddressStaff.setText(null);
                groupStatusStaff.clearSelection();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelInputStaff.add(labelInputDataStaff);
        panelInputStaff.add(labelNameStaff);
        panelInputStaff.add(labelEmailStaff);
        panelInputStaff.add(labelNomorHpStaff);
        panelInputStaff.add(labelJobdeskStaff);
        panelInputStaff.add(labelAddressStaff);
        panelInputStaff.add(labelStatusStaff);

        panelInputStaff.add(txtNameStaff);
        panelInputStaff.add(txtEmailStaff);
        panelInputStaff.add(txtPhoneNumberStaff);
        panelInputStaff.add(txtAddressStaff);

        panelInputStaff.add(boxJobdeskStaff);

        groupStatusStaff.add(statusAktif);
        groupStatusStaff.add(statusInAktif);

        panelInputStaff.add(statusAktif);
        panelInputStaff.add(statusInAktif);

        panelInputStaff.add(btnSaveStaff);
        panelInputStaff.add(btnResetStaff);
        panelInputStaff.add(btnBackToHome);

        bgPanel.add(panelInputStaff);
        bgPanel.add(labelHeaderDataStaff);
        bgPanel.add(labelCopyright);
    }

    private void handleInsertStaff() {

        try {
            String nameStaff = txtNameStaff.getText().trim();
            String phoneNumber = txtPhoneNumberStaff.getText().trim();
            String email = txtEmailStaff.getText().trim();
            String jobdesk = (String) boxJobdeskStaff.getSelectedItem();
            String address = txtAddressStaff.getText().trim();
            String status = null;

            if (nameStaff.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() ||
                    jobdesk.isEmpty() || address.isEmpty() ||
                    (!statusAktif.isSelected() && !statusInAktif.isSelected())) {
                if (nameStaff.isEmpty()) {
                    panelInputStaff.add(errorNameStaff);
                } else {
                    panelInputStaff.remove(errorNameStaff);
                }
                if (phoneNumber.isEmpty()) {
                    panelInputStaff.add(errorPhoneNumberStaff);
                } else {
                    panelInputStaff.remove(errorPhoneNumberStaff);
                }

                if (email.isEmpty()) {
                    panelInputStaff.add(errorEmailStaff);
                } else {
                    panelInputStaff.remove(errorEmailStaff);
                }

                if (jobdesk.isEmpty()) {
                    panelInputStaff.add(errorJobdeskStaff);
                } else {
                    panelInputStaff.remove(errorJobdeskStaff);
                }

                panelInputStaff.revalidate();
                panelInputStaff.repaint();

                return;
            }

            if (statusAktif.isSelected()) {
                status = "Active";
            } else if (statusInAktif.isSelected()) {
                status = "Inactive";
            }

            boolean saveData = cInsertDataStaff.dataStaff(nameStaff, phoneNumber, email, jobdesk, address, status);
            if (saveData) {
                txtNameStaff.setText(null);
                txtPhoneNumberStaff.setText(null);
                txtEmailStaff.setText(null);
                txtAddressStaff.setText(null);
                groupStatusStaff.clearSelection();

                JOptionPane.showMessageDialog(this, "Input Data successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Input Data.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
