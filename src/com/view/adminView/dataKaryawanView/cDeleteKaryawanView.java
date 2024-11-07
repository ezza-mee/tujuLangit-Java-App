package com.view.adminView.dataKaryawanView;

import com.main.resources.templates.cPanelContentApp;
import com.view.adminView.cPanelContentView;

public class cDeleteKaryawanView extends cPanelContentApp {

    private cPanelContentView parentPanel;

    public cDeleteKaryawanView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsDeleteKaryawanView();
    }

    private void initsDeleteKaryawanView() {
        setVisible(true);
    }

}
