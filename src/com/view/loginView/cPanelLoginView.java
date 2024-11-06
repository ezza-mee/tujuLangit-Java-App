package com.view.loginView;

import com.main.resources.templates.cPanelCardLogin;
import com.view.loginView.loginAdminView.cLoginAdminView;
import com.view.loginView.loginKaryawanView.cLoginKaryawanView;

public class cPanelLoginView extends cPanelCardLogin {

    private cLoginAdminView componentAdminView;
    private cLoginKaryawanView componentKaryawanView;

    public cPanelLoginView() {
        super();
        componentAdminView = new cLoginAdminView(this);
        componentKaryawanView = new cLoginKaryawanView(this);

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

    public void showLoginKaryawanView() {
        refreshContent();

        bgPanel.add(componentKaryawanView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

}
