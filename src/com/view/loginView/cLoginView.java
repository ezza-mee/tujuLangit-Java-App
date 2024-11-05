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
        titleFrom.setFont(cFonts.TITLE_START_FONT);

        this.setTitle("TujuLangit");
        titleLogin.setText("TujuLangit");

        bgFrame.add(bgPanelLoginView);

    }
}
