package com.view.loginView;

import com.main.resources.templates.cPanelCardLogin;
import com.view.loginView.loginAdminView.cLoginAdminView;

public class cPanelLoginView extends cPanelCardLogin {

    private cLoginAdminView componentAdminView;

    public cPanelLoginView() {
        super();
        componentAdminView = new cLoginAdminView(this);

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

}
