package com.model;

import com.main.resources.templates.cPanelCardLogin;
import com.view.loginView.loginAdminView.cLoginAdminView;
import com.view.loginView.loginStaffView.cLoginStaffView;

public class cContentLoginView extends cPanelCardLogin {

    private cLoginAdminView componentAdminView;
    private cLoginStaffView componentStaffView;

    public cContentLoginView() {
        super();
        componentAdminView = new cLoginAdminView(this);
        componentStaffView = new cLoginStaffView(this);

        showLoginAdminView();
    }

    private void refreshContent() {
        try {
            bgPanel.removeAll();
            bgPanel.revalidate();
            bgPanel.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showLoginAdminView() {
        refreshContent();

        bgPanel.add(componentAdminView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showLoginStaffView() {
        refreshContent();

        bgPanel.add(componentStaffView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

}
