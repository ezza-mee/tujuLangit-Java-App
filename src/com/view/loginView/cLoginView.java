package com.view.loginView;

import com.main.resources.templates.cFrameLoginApp;
import com.model.cContentLoginView;

public class cLoginView extends cFrameLoginApp {

    private cContentLoginView bgPanelLoginView = new cContentLoginView();

    public cLoginView() {
        super();

        initsLoginView();

    }

    public void initsLoginView() {
        setVisible(true);

        bgFrame.add(bgPanelLoginView);

    }
}
