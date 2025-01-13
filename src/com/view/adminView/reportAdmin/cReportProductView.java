package com.view.adminView.reportAdmin;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;

public class cReportProductView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    public cReportProductView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsReportDataProductView();
    }

    private void initsReportDataProductView() {
        setVisible(true);
    }
}
