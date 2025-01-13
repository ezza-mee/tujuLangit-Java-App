package com.view.staffView.reportView;

import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;

public class cReportSeatsView extends cPanelContentApp {

    private cContentStaffView parentPanel;

    public cReportSeatsView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsReportDataSeatsView();
    }

    private void initsReportDataSeatsView() {
        setVisible(true);
    }
}
