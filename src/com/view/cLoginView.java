package com.view;

import com.main.resources.templates.cFrameLoginApp;
import com.partials.cButtonLogin;
import com.partials.cErrorLabel;
import com.partials.cFormLabel;
import com.partials.cPasswordField;
import com.partials.cTextField;

public class cLoginView extends cFrameLoginApp {

    // component of login admin
    private cFormLabel labelUsernameAdmin = new cFormLabel("Username", 150, 240, 200);
    private cTextField fieldUsernameAdmin = new cTextField(155, 270, 300);
    private cFormLabel labelPasswordAdmin = new cFormLabel("Password", 150, 320, 300);
    private cPasswordField fieldPasswordAdmin = new cPasswordField(155, 350, 300);
    private cButtonLogin buttonLoginAdmin = new cButtonLogin("Login", 155, 430, 300, 40, 10);
    private cErrorLabel errorLabelAdmin = new cErrorLabel("Error", 155, 295, 300);
    private cErrorLabel errorLabelPassAdmin = new cErrorLabel("Error Woi Anjing", 155, 375, 300);

    public cLoginView() {
        super();
    }

    public void initsLoginAdmin() {
        setVisible(true);
        this.setTitle("Sign In");
        titleLogin.setText("Sign In");
        titleFrom.setText("TujuLangit");

        cardLogin.add(labelUsernameAdmin);
        cardLogin.add(fieldUsernameAdmin);
        cardLogin.add(labelPasswordAdmin);
        cardLogin.add(fieldPasswordAdmin);
        cardLogin.add(buttonLoginAdmin);
        cardLogin.add(errorLabelAdmin);
        cardLogin.add(errorLabelPassAdmin);
    }
}
