package com.view.loginView.loginAdminView;

import com.main.resources.templates.cPanelCardLogin;
import com.partials.*;
import com.view.loginView.cPanelLoginView;

public class cLoginAdminView extends cPanelCardLogin {

    private cPanelLoginView parentPanel;

    // component Label Header
    private cLabelInfo labelHeaderLogin = new cLabelInfo("Sign In", 200, 60, 300, 60);
    private cBigFont labelHeaderTujuLangit = new cBigFont("TujuLangit", 70, 250);
    private cBigFont labelHeaderForestpark = new cBigFont("Forestpark", 270, 320);

    private cImage imgBrand = new cImage("src/com/main/resources/images/brandIcon.png", 90, 340, 160, 160);

    // component panel login admin
    private cPanelRounded panelShapeLogin = new cPanelRounded(0, 0, 530, 700, 0, 340);
    private cPanelRounded panelCardLogin = new cPanelRounded(560, 70, 500, 600, 10, 10);
    private cPanelRounded panelListLogin = new cPanelRounded(195, 110, 100, 7, 5, 5);

    

    // component of login admin
    private cFormLabel labelUsernameAdmin = new cFormLabel("Username", 100, 150, 200);
    private cTextField fieldUsernameAdmin = new cTextField(100, 180, 300);
    private cFormLabel labelPasswordAdmin = new cFormLabel("Password", 100, 240, 300);
    private cPasswordField fieldPasswordAdmin = new cPasswordField(100, 270, 300);
    private cButtonRounded btnLoginAdmin = new cButtonRounded("Login", 100, 350, 300, 40, 10);
    private cErrorLabel errorLabelUsername = new cErrorLabel("Username is Incorret!", 100, 205, 300);
    private cErrorLabel errorLabelPassword = new cErrorLabel("Password is Incorret!", 100, 295, 300);

    private cLabelLink labelLoginStaff = new cLabelLink("Staff Login", 480);

    public cLoginAdminView(cPanelLoginView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsLoginAdminView();
    }

    public void initsLoginAdminView() {
        setVisible(true);

        labelLoginStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                parentPanel.showLoginKaryawanView();
            }
        });

        titleLogout.setForeground(cColor.GREEN);
        bgPanel.setBackground(cColor.WHITE);

        labelHeaderLogin.setFont(cFonts.BIG_FONT);
        labelLoginStaff.setForeground(cColor.GREEN);

        labelHeaderTujuLangit.setFont(cFonts.TITLE_START_FONT);
        labelHeaderForestpark.setFont(cFonts.TITLE_FONT);
        labelHeaderTujuLangit.setForeground(cColor.WHITE);
        labelHeaderForestpark.setForeground(cColor.WHITE);

        panelShapeLogin.setBackground(cColor.GREEN);
        panelListLogin.setBackground(cColor.GREEN);

        panelShapeLogin.add(labelHeaderTujuLangit);
        panelShapeLogin.add(labelHeaderForestpark);
        panelShapeLogin.add(imgBrand);

        panelCardLogin.add(labelHeaderLogin);
        panelCardLogin.add(panelListLogin);
        panelCardLogin.add(labelUsernameAdmin);
        panelCardLogin.add(fieldUsernameAdmin);
        panelCardLogin.add(labelPasswordAdmin);
        panelCardLogin.add(fieldPasswordAdmin);
        panelCardLogin.add(errorLabelUsername);
        panelCardLogin.add(errorLabelPassword);
        panelCardLogin.add(btnLoginAdmin);
        panelCardLogin.add(labelLoginStaff);

        bgPanel.add(panelCardLogin);
        bgPanel.add(panelShapeLogin);
    }

}
