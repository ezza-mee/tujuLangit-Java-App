package com.view.adminView.dataStaffView;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.main.database.staff.cUpdateDataStaff;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;
import com.partials.*;

public class cUpdateStaffView extends cPanelContentApp {

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
    private cLabelInfo labelEmailStaff = new cLabelInfo("Email", 180, 195, 300, 30);
    private cLabelInfo labelNomorHpStaff = new cLabelInfo("Nomor Hp", 180, 270, 300, 30);
    private cLabelInfo labelJobdeskStaff = new cLabelInfo("Jobdesk", 580, 120, 300, 30);
    private cLabelInfo labelLocationStaff = new cLabelInfo("Address", 580, 195, 300, 30);
    private cLabelInfo labelStatusStaff = new cLabelInfo("Status", 580, 345, 300, 30);

    // add textfield update Staff
    private cTextField txtNameStaff = new cTextField(180, 145, 300);
    private cTextField txtEmailStaff = new cTextField(180, 220, 300);
    private cTextField txtNomorHpStaff = new cTextField(180, 295, 300);

    private cTextArea txtLocationStaff = new cTextArea(580, 220, 300, 100, true);

    // add combobox jobdesk Staff
    private cComboBox boxJobdeskStaff = new cComboBox(
            new String[] { "Jodesk", "Cashier", "Barista", "Manajer", "Waiter", "Cleaning staff", "Owner" }, 580, 145,
            300, 30);

    // add radion button status Staff
    private cRadioButton statusAktif = new cRadioButton("Active", "Active", 580, 375, 100);
    private cRadioButton statusInAktif = new cRadioButton("Inactive", "Inactive", 700, 375, 100);

    // component button Update Staff
    private cButtonRounded btnSaveStaff = new cButtonRounded("Save", 780, 480, 110, 40, 10);
    private cButtonRounded btnResetStaff = new cButtonRounded("Reset", 660, 480, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 180, 480, 110, 40, 10);

    // component label error Staff
    private cErrorLabel errornameStaff = new cErrorLabel("Name Staff is Empty", 180, 170, 300);
    private cErrorLabel errorphonenumber = new cErrorLabel("Phone Number is Empty", 180, 245, 300);
    private cErrorLabel erroremail = new cErrorLabel("Email is Empty", 580, 170, 300);
    private cErrorLabel erroraddress = new cErrorLabel("Address Supplier is Empty", 580, 315, 300);

    private int idStaff;

    public cUpdateStaffView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsUpdateStaffView();
    }
    
    public void setDataStaff(int idStaff, String nameStaff, String phoneNumber, String email, String address) {
        this.idStaff = idStaff;

        txtNameStaff.setText(nameStaff);
        txtNomorHpStaff.setText(phoneNumber);
        txtEmailStaff.setText(email);
        txtLocationStaff.setText(address);
    }

    private void initsUpdateStaffView() {
        setVisible(true);

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataStaffView();
            }
        });

        btnSaveStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                handleUpdateStaff(idStaff);
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelInputStaff.add(labelInputDataStaff);
        panelInputStaff.add(labelNameStaff);
        panelInputStaff.add(labelEmailStaff);
        panelInputStaff.add(labelNomorHpStaff);
        panelInputStaff.add(labelJobdeskStaff);
        panelInputStaff.add(labelLocationStaff);
        panelInputStaff.add(labelStatusStaff);

        panelInputStaff.add(txtNameStaff);
        panelInputStaff.add(txtEmailStaff);
        panelInputStaff.add(txtNomorHpStaff);
        panelInputStaff.add(txtLocationStaff);

        panelInputStaff.add(boxJobdeskStaff);

        ButtonGroup groupButton = new ButtonGroup();
        groupButton.add(statusAktif);
        groupButton.add(statusInAktif);

        panelInputStaff.add(statusAktif);
        panelInputStaff.add(statusInAktif);

        panelInputStaff.add(btnSaveStaff);
        panelInputStaff.add(btnResetStaff);
        panelInputStaff.add(btnBackToHome);

        bgPanel.add(panelInputStaff);
        bgPanel.add(labelHeaderDataStaff);
        bgPanel.add(labelCopyright);
    }
    private void handleUpdateStaff(int idStaff) {
        String nameStaff = txtNameStaff.getText();
        String phonenumber = txtNomorHpStaff.getText();
        String email = txtEmailStaff.getText();
        String address = txtLocationStaff.getText();

        if (nameStaff.isEmpty() || phonenumber.isEmpty() || email.isEmpty() ||
                address.isEmpty()) {

            if (nameStaff.isEmpty()) {
                panelInputStaff.add(errornameStaff);
            } else {
                panelInputStaff.remove(errornameStaff);
            }

            if (phonenumber.isEmpty()) {
                panelInputStaff.add(errorphonenumber);
            } else {
                panelInputStaff.remove(errorphonenumber);
            }

            if (email.isEmpty()) {
                panelInputStaff.add(erroremail);
            } else {
                panelInputStaff.remove(erroremail);
            }

            if (address.isEmpty()) {
                panelInputStaff.add(erroraddress);
            } else {
                panelInputStaff.remove(erroraddress);
            }

            panelInputStaff.revalidate();
            panelInputStaff.repaint();

            return;
        }

        boolean saveData = cUpdateDataStaff.handleUpdateStaff(idStaff, nameStaff, phonenumber,
        email, address);
        if (saveData) {
            txtNameStaff.setText(null);
            txtNomorHpStaff.setText(null);
            txtEmailStaff.setText(null);
            txtLocationStaff.setText(null);
            JOptionPane.showMessageDialog(this, "Saved Staff successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to save Staff.");
        }
    }
}
