package com.view.adminView.dataKaryawanView;

import com.main.resources.templates.cPanelContentApp;
import com.view.adminView.cPanelContentView;

public class cUpdateKaryawanView extends cPanelContentApp {

    private cPanelContentView parentPanel;

    public cUpdateKaryawanView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        initsUpdateKaryawanView();
    }

    private void initsUpdateKaryawanView() {
        setVisible(true);
    }

}
