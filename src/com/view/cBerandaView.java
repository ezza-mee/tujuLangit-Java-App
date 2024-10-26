package com.view;

import com.partials.*;
import com.main.resources.templates.cFrameContentApp;

public class cBerandaView extends cFrameContentApp {

    // ini adalah component beranda
    private cPanelRounded dataMenu = new cPanelRounded(20, 20, 200, 80, 10, 10);

    public cBerandaView() {
        super();
        initsBeranda();
    }

    public void initsBeranda() {
        setVisible(true);
        bgFrame.add(dataMenu);
    }
}
