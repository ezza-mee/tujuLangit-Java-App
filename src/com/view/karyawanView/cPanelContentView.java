package com.view.karyawanView;

import com.main.resources.templates.cPanelContentApp;
import com.partials.cColor;
import com.view.karyawanView.productView.cDataProductView;

public class cPanelContentView extends cPanelContentApp {

    private cHomeView componentHomeView = new cHomeView();
    private cDataProductView componentProductView = new cDataProductView();

    public cPanelContentView() {
        super();
    }

    private void refreshContent(){
        try{
            bgPanel.removeAll();
            bgPanel.revalidate();
            bgPanel.repaint();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showHomeView() {
        refreshContent();
        bgPanel.add(componentHomeView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showProductView() {
        refreshContent();
        bgPanel.add(componentProductView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }
}
