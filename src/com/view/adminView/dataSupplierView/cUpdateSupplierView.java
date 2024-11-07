package com.view.adminView.dataSupplierView;

import com.main.resources.templates.cPanelContentApp;
import com.view.adminView.cPanelContentView;

public class cUpdateSupplierView extends cPanelContentApp {
    
    private cPanelContentView parentPanel;

    public cUpdateSupplierView(cPanelContentView parentPanel) {
        super();
        this.parentPanel = parentPanel;
    }

    private void initsUpdateSupplierView() {
        setVisible(true);
    }
}
