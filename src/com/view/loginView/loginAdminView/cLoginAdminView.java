package com.view.loginView.loginAdminView;

import com.main.resources.templates.cPanelCardLogin;
import com.partials.*;
import com.view.loginView.cPanelLoginView;

public class cLoginAdminView extends cPanelCardLogin {

    private cPanelLoginView parentPanel;

    // component panel login admin
    private cPanelRounded panelShapeLogin = new cPanelRounded(0, 0, 530, 700, 0, 340);
    private cPanelRounded panelCardLogin = new cPanelRounded(560, 100, 500, 500, 10, 10);

    // component of login admin
    private cFormLabel labelUsernameAdmin = new cFormLabel("Username", 100, 150, 200);
    private cTextField fieldUsernameAdmin = new cTextField(100, 180, 300);
    private cFormLabel labelPasswordAdmin = new cFormLabel("Password", 100, 230, 300);
    private cPasswordField fieldPasswordAdmin = new cPasswordField(100, 260, 300);
    private cButtonRounded btnLoginAdmin = new cButtonRounded("Login", 100, 330, 300, 40, 10);
    private cErrorLabel errorLabelAdmin = new cErrorLabel("Error", 155, 295, 300);
    private cErrorLabel errorLabelPassAdmin = new cErrorLabel("Error", 155, 375, 300);

    public cLoginAdminView(cPanelLoginView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsLoginAdminView();
    }

    private void initsLoginAdminView() {
        setVisible(true);
        titleLogout.setForeground(cColor.GREEN);
        bgPanel.setBackground(cColor.WHITE);

        panelShapeLogin.setBackground(cColor.GREEN);

        panelCardLogin.add(labelUsernameAdmin);
        panelCardLogin.add(fieldUsernameAdmin);
        panelCardLogin.add(labelPasswordAdmin);
        panelCardLogin.add(fieldPasswordAdmin);
        panelCardLogin.add(btnLoginAdmin);

        bgPanel.add(panelCardLogin);
        bgPanel.add(panelShapeLogin);
    }

}
