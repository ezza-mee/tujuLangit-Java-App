package com.view.loginView;

import com.main.resources.templates.cFrameLoginApp;
import com.partials.cColor;
import com.partials.cFonts;

public class cLoginView extends cFrameLoginApp {

    private cPanelLoginView bgPanelLoginView = new cPanelLoginView();

    public cLoginView() {
        super();

        initsLoginView();

    }

    public void initsLoginView() {
        setVisible(true);

        this.setTitle("TujuLangit");
        titleLogin.setText("TujuLangit");
        titleFrom.setText("Forestpark");

        bgFrame.add(bgPanelLoginView);

    }
}
