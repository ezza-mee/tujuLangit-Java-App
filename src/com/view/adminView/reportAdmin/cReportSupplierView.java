package com.view.adminView.reportAdmin;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentAdminView;

public class cReportSupplierView extends cPanelContentApp {
    private cContentAdminView parentPanel;

    public cReportSupplierView(cContentAdminView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsReportDataSupplierView();
    }

    private void initsReportDataSupplierView() {
        setVisible(true);
    }
}
