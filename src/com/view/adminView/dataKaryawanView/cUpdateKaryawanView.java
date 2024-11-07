package com.view.adminView.dataKaryawanView;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;
import com.view.adminView.cPanelContentView;

public class cUpdateKaryawanView extends cPanelContentApp {

    private cPanelContentView parentPanel;

    // component label header Data Karyawan
    private cBigFont labelHeaderDataKaryawan = new cBigFont("Staff", 40, 5);
    private cBigFont labelInputDataKaryawan = new cBigFont("Input Data karyawan", 180, 20);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component panel Data karyawan
    private cPanelRounded panelInputKaryawan = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component label Data Karyawan
    private cLabelInfo labelNameKaryawan = new cLabelInfo("Name", 180, 120, 300, 30);
    private cLabelInfo labelAgeKaryawan = new cLabelInfo("Age", 180, 195, 300, 30);
    private cLabelInfo labelEmailKaryawan = new cLabelInfo("Email", 180, 270, 300, 30);
    private cLabelInfo labelNomorHpKaryawan = new cLabelInfo("Nomor Hp", 180, 345, 300, 30);
    private cLabelInfo labelJobdeskKaryawan = new cLabelInfo("Jobdesk", 580, 120, 300, 30);
    private cLabelInfo labelLocationKaryawan = new cLabelInfo("Location", 580, 195, 300, 30);
    private cLabelInfo labelStatusKaryaawn = new cLabelInfo("Status", 580, 345, 300, 30);

    // add textfield update Karyawan
    private cTextField txtNameKaryawan = new cTextField(180, 145, 300);
    private cTextField txtAgeKaryawan = new cTextField(180, 220, 300);
    private cTextField txtEmailKaryawan = new cTextField(180, 295, 300);
    private cTextField txtNomorHpKaryawan = new cTextField(180, 370, 300);

    private cTextArea txtLocationKaryawan = new cTextArea(580, 220, 300, 100, true);

    // add combobox jobdesk karyawan
    private cComboBox boxJobdeskKaryawan = new cComboBox(
            new String[] { "Jodesk", "Cashier", "Barista", "Manajer", "Waiter", "Cleaning staff", "Owner" }, 580, 145,
            300, 30);

    // add radion button status Karyawan
    private cRadioButton statusAktif = new cRadioButton("Aktif", "Active", 580, 375, 100);
    private cRadioButton statusInAktif = new cRadioButton("Inaktif", "Inactive", 700, 375, 100);

    // component button Update Karyawan
    private cButtonRounded btnSaveKaryawan = new cButtonRounded("Save", 540, 460, 110, 40, 10);
    private cButtonRounded btnResetKaryawan = new cButtonRounded("Reset", 660, 460, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 780, 460, 110, 40, 10);

    public cUpdateKaryawanView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsUpdateKaryawanView();
    }

    private void initsUpdateKaryawanView() {
        setVisible(true);

        btnBackToHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                parentPanel.showDataKaryawanView();
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.COPYRIGHT_FONT);

        panelInputKaryawan.add(labelInputDataKaryawan);
        panelInputKaryawan.add(labelNameKaryawan);
        panelInputKaryawan.add(labelAgeKaryawan);
        panelInputKaryawan.add(labelEmailKaryawan);
        panelInputKaryawan.add(labelNomorHpKaryawan);
        panelInputKaryawan.add(labelJobdeskKaryawan);
        panelInputKaryawan.add(labelLocationKaryawan);
        panelInputKaryawan.add(labelStatusKaryaawn);

        panelInputKaryawan.add(txtNameKaryawan);
        panelInputKaryawan.add(txtAgeKaryawan);
        panelInputKaryawan.add(txtEmailKaryawan);
        panelInputKaryawan.add(txtNomorHpKaryawan);
        panelInputKaryawan.add(txtLocationKaryawan);

        panelInputKaryawan.add(boxJobdeskKaryawan);

        ButtonGroup groupButton = new ButtonGroup();
        groupButton.add(statusAktif);
        groupButton.add(statusInAktif);

        panelInputKaryawan.add(statusAktif);
        panelInputKaryawan.add(statusInAktif);

        panelInputKaryawan.add(btnSaveKaryawan);
        panelInputKaryawan.add(btnResetKaryawan);
        panelInputKaryawan.add(btnBackToHome);

        bgPanel.add(panelInputKaryawan);
        bgPanel.add(labelHeaderDataKaryawan);
        bgPanel.add(labelCopyright);
    }

}
