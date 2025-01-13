package com.view.staffView.reportView;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;

public class cReportTransactionView extends cPanelContentApp {

    private cContentStaffView parentPanel;

    public cReportTransactionView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsReportDataTransactionView();
    }

    private void initsReportDataTransactionView() {
        setVisible(true);
    }
}
