package com.view.adminView;

import com.main.resources.templates.cFrameDashboardApp;

public class cDashboardAdmin extends cFrameDashboardApp {

    private cHomeView componentHomeView = new cHomeView();

    public cDashboardAdmin(){
        super();
        initsViewDashboardAdmin();
    }
    public void initsViewDashboardAdmin(){
        setVisible(true);
        componentHomeView.setBounds(240, 70, 1126, 698);

        bgFrame.add(componentHomeView);
        
    }
}
