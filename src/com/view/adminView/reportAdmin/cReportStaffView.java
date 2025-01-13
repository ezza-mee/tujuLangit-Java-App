package com.view.adminView.reportAdmin;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;

public class cReportStaffView extends cPanelContentApp {

    private cContentAdminView parentPanel;

    public cReportStaffView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        
        initsReportDataStaffView();
    }

    private void initsReportDataStaffView() {
        setVisible(true);
    }
}
