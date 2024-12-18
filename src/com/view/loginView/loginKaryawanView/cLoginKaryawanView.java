package com.view.loginView.loginKaryawanView;

import com.main.resources.templates.cPanelCardLogin;
import com.model.cContentLoginView;
import com.partials.*;

public class cLoginKaryawanView extends cPanelCardLogin {

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
    private cFormLabel labelUsernameKaryawan = new cFormLabel("Username", 100, 150, 200);
    private cTextField fieldUsernameKaryawan = new cTextField(100, 180, 300);
    private cFormLabel labelPasswordKaryawan = new cFormLabel("Password", 100, 240, 300);
    private cPasswordField fieldPasswordKaryawan = new cPasswordField(100, 270, 300);
    private cButtonRounded btnLoginKaryawan = new cButtonRounded("Login", 100, 350, 300, 40, 10);
    private cErrorLabel errorLabelUsername = new cErrorLabel("Username is Incorret!", 100, 205, 300);
    private cErrorLabel errorLabelPassword = new cErrorLabel("Password is Incorret!", 100, 295, 300);

    private cLabelLink labelLoginAdmin = new cLabelLink("Admin Login", 480);

    public cLoginKaryawanView(cContentLoginView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsLoginKaryawanView();
    }

    private void initsLoginKaryawanView() {
        setVisible(true);

        labelLoginAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                parentPanel.showLoginAdminView();
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
        panelCardLogin.add(labelUsernameKaryawan);
        panelCardLogin.add(fieldUsernameKaryawan);
        panelCardLogin.add(labelPasswordKaryawan);
        panelCardLogin.add(fieldPasswordKaryawan);
        panelCardLogin.add(errorLabelUsername);
        panelCardLogin.add(errorLabelPassword);
        panelCardLogin.add(btnLoginKaryawan);
        panelCardLogin.add(labelLoginAdmin);

        bgPanel.add(panelCardLogin);
        bgPanel.add(panelShapeLogin);
    }

}
