package com.view.loginView.loginStaffView;

import com.main.controller.Controller;
import com.main.database.staff.cVerifyAkunStaff;
import com.main.resources.templates.cPanelCardLogin;
import com.model.cContentLoginView;
import com.partials.*;

public class cLoginStaffView extends cPanelCardLogin {

    private cContentLoginView parentPanel;

    private cBigFont labelHeaderTujuLangit = new cBigFont("TujuLangit", 70, 250);
    private cBigFont labelHeaderForestpark = new cBigFont("Forestpark", 270, 320);

    private cImage imgBrand = new cImage("src/com/main/resources/images/brandIcon.png", 90, 340, 160, 160);

    // component panel login admin
    private cPanelRounded panelShapeLogin = new cPanelRounded(0, 0, 530, 700, 0, 340);
    private cPanelRounded panelCardLogin = new cPanelRounded(560, 90, 500, 580, 10, 10);
    private cPanelRounded panelListLogin = new cPanelRounded(195, 70, 100, 7, 5, 5);

    // component Label Header
    private cLabelInfo labelHeaderLogin = new cLabelInfo("Sign In", 200, 20, 300, 60);

    // component of login admin
    private cFormLabel labelEmailStaff = new cFormLabel("Email", 100, 150, 200);
    private cTextField txtEmailStaff = new cTextField(100, 180, 300);
    private cFormLabel labelPasswordStaff = new cFormLabel("Password", 100, 240, 300);
    private cPasswordField txtPasswordStaff = new cPasswordField(100, 270, 300);
    private cButtonRounded btnLoginStaff = new cButtonRounded("Login", 100, 350, 300, 40, 10);
    private cErrorLabel errorLabelEmail = new cErrorLabel("Email is Incorret!", 100, 205, 300);
    private cErrorLabel errorLabelPassword = new cErrorLabel("Password is Incorret!", 100, 295, 300);

    private cLabelLink labelLoginAdmin = new cLabelLink("Admin Login", 480);

    public cLoginStaffView(cContentLoginView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsLoginStaffView();
    }

    private void initsLoginStaffView() {
        setVisible(true);

        labelLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                parentPanel.showLoginAdminView();
            }
        });

        btnLoginStaff.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String email = txtEmailStaff.getText();
                String password = String.valueOf(txtPasswordStaff.getPassword());

                if (email.equals("") || password.equals("")) {
                    parentPanel.showLoginStaffView();
                    if (email.equals("")) {
                        panelCardLogin.add(errorLabelEmail);
                    }
                    if (password.equals("")) {
                        panelCardLogin.add(errorLabelPassword);
                    }
                } else {
                    // Verifikasi login
                    boolean isValidLogin = cVerifyAkunStaff.verifyAkunStaff(email, password);

                    if (isValidLogin) {
                        // Dapatkan ID staff yang login
                        int staffId = cVerifyAkunStaff.getStaffId(email, password);

                        // Reset field input login
                        txtEmailStaff.setText(null);
                        txtPasswordStaff.setText(null);

                        // Sembunyikan frame login dan tampilkan dashboard
                        Controller.hiddenFrameLogin();
                        Controller.showDashboardStaffView(staffId);
                    } else {
                        panelCardLogin.add(errorLabelEmail);
                        panelCardLogin.add(errorLabelPassword);
                        panelCardLogin.revalidate();
                        panelCardLogin.repaint();
                    }
                }
            }
        });

        titleLogout.setForeground(cColor.GREEN);
        bgPanel.setBackground(cColor.WHITE);

        labelHeaderLogin.setFont(cFonts.FONT_SIZE_18);
        labelLoginAdmin.setForeground(cColor.GREEN);

        labelHeaderTujuLangit.setFont(cFonts.FONT_SIZE_40);
        labelHeaderForestpark.setFont(cFonts.FONT_SIZE_20);
        labelHeaderTujuLangit.setForeground(cColor.WHITE);
        labelHeaderForestpark.setForeground(cColor.WHITE);

        panelShapeLogin.add(labelHeaderTujuLangit);
        panelShapeLogin.add(labelHeaderForestpark);
        panelShapeLogin.add(imgBrand);

        panelShapeLogin.setBackground(cColor.GREEN);
        panelListLogin.setBackground(cColor.GREEN);

        panelCardLogin.add(labelHeaderLogin);
        panelCardLogin.add(panelListLogin);
        panelCardLogin.add(labelEmailStaff);
        panelCardLogin.add(txtEmailStaff);
        panelCardLogin.add(labelPasswordStaff);
        panelCardLogin.add(txtPasswordStaff);
        panelCardLogin.add(btnLoginStaff);
        panelCardLogin.add(labelLoginAdmin);

        bgPanel.add(panelCardLogin);
        bgPanel.add(panelShapeLogin);
    }

}
