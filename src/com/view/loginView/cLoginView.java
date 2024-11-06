package com.view.loginView;

import com.main.resources.templates.cFrameLoginApp;

public class cLoginView extends cFrameLoginApp {

    private cPanelLoginView bgPanelLoginView = new cPanelLoginView();

    public cLoginView() {
        super();

        initsLoginView();

    }

    public void initsLoginView() {
        setVisible(true);

        bgFrame.add(bgPanelLoginView);

    }
}
