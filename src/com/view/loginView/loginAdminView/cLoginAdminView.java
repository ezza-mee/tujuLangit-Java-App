package com.view.loginView.loginAdminView;

import javax.swing.JOptionPane;

import com.main.controller.Controller;
import com.main.resources.templates.cPanelCardLogin;
import com.model.cContentLoginView;
import com.partials.*;

public class cLoginAdminView extends cPanelCardLogin {

    private cContentLoginView parentPanel;

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
    private cTextField txtUsernameAdmin = new cTextField(100, 180, 300);
    private cFormLabel labelPasswordAdmin = new cFormLabel("Password", 100, 240, 300);
    private cPasswordField txtPasswordAdmin = new cPasswordField(100, 270, 300);

    // component of button login admin
    private cButtonRounded btnLoginAdmin = new cButtonRounded("Login", 100, 350, 300, 40, 10);

    // component of error label admin

    private cErrorLabel incorrectLabelUsername = new cErrorLabel("Username is Incorrect and Empty!", 100, 205, 300);
    private cErrorLabel incorrectLabelPassword = new cErrorLabel("Password is Incorrect and Empty!", 100, 295, 300);

    private cLabelLink labelLoginStaff = new cLabelLink("Staff Login", 480);

    public cLoginAdminView(cContentLoginView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsLoginAdminView();
    }

    public void initsLoginAdminView() {
        setVisible(true);

        panelCardLogin.remove(incorrectLabelUsername);
        panelCardLogin.remove(incorrectLabelPassword);

        btnLoginAdmin.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent ae) {
                String userName = txtUsernameAdmin.getText();
                String password = String.valueOf(txtPasswordAdmin.getPassword());

                if (txtUsernameAdmin.getText().equalsIgnoreCase("")
                        || String.valueOf(txtPasswordAdmin.getPassword()).equalsIgnoreCase("")) {
                    parentPanel.showLoginAdminView();
                    if (txtUsernameAdmin.getText().equals("")) {
                        panelCardLogin.add(incorrectLabelUsername);
                    }
                    if (String.valueOf(txtPasswordAdmin.getPassword()).equalsIgnoreCase("")) {
                        panelCardLogin.add(incorrectLabelPassword);
                    }
                }
                if (userName.equals("admin") && password.equals("admin")) {
                    txtUsernameAdmin.setText(null);
                    txtPasswordAdmin.setText(null);
                    // Controller.hiddenFrameLogin();
                    Controller.showDashboardAdmin();
                } else {
                    panelCardLogin.add(incorrectLabelUsername);
                    panelCardLogin.add(incorrectLabelPassword);
                    panelCardLogin.revalidate();
                    panelCardLogin.repaint();
                }
            }
        });

        labelLoginStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent me) {
                parentPanel.showLoginKaryawanView();
            }
        });

        titleLogout.setForeground(cColor.GREEN);
        bgPanel.setBackground(cColor.WHITE);

        labelHeaderLogin.setFont(cFonts.FONT_SIZE_18);
        labelLoginStaff.setForeground(cColor.GREEN);

        labelHeaderTujuLangit.setFont(cFonts.FONT_SIZE_40);
        labelHeaderForestpark.setFont(cFonts.FONT_SIZE_20);
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
        panelCardLogin.add(txtUsernameAdmin);
        panelCardLogin.add(labelPasswordAdmin);
        panelCardLogin.add(txtPasswordAdmin);
        panelCardLogin.add(btnLoginAdmin);
        panelCardLogin.add(labelLoginStaff);

        bgPanel.add(panelCardLogin);
        bgPanel.add(panelShapeLogin);
    }

}
