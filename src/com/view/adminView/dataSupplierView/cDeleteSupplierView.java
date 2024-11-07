package com.view.adminView.dataSupplierView;

import com.main.resources.templates.cPanelContentApp;
import com.view.adminView.cPanelContentView;

public class cDeleteSupplierView extends cPanelContentApp{

    private cPanelContentView parentPanel;

    public cDeleteSupplierView(cPanelContentView parentPanel){
        super();
        this.parentPanel = parentPanel;
    }

    private void initsDeleteKaryawanView(){
        setVisible(true);
    }
    
}
