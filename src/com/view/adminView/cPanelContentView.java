package com.view.adminView;

import com.main.resources.templates.cPanelContentApp;
import com.view.adminView.dataKaryawanView.*;
import com.view.adminView.dataProductView.*;

public class cPanelContentView extends cPanelContentApp {

    private cHomeView componentHomeView;

    private cDataProductView componentDataProductView;
    private cInputProductView componentInputProductView;
    private cUpdateProductView componentUpdateProductView;
    private cDeleteProductView componentDeleteProductView;

    private cDataKaryawanView componentDataKaryawanView;
    private cInputKaryawanView componentInputKaryawanView;
    private cUpdateKaryawanView componentUpdateKaryawanView;
    private cDeleteKaryawanView componentDeleteKaryawanView;

    public cPanelContentView() {
        super();

        componentHomeView = new cHomeView(this);

        componentDataProductView = new cDataProductView(this);
        componentInputProductView = new cInputProductView(this);
        componentUpdateProductView = new cUpdateProductView(this);
        componentDeleteProductView = new cDeleteProductView(this);

        componentDataKaryawanView = new cDataKaryawanView(this);
        componentInputKaryawanView = new cInputKaryawanView(this);
        componentUpdateKaryawanView = new cUpdateKaryawanView(this);
        componentDeleteKaryawanView = new cDeleteKaryawanView(this);
    }

    private void refreshContent() {
        try {
            bgPanel.removeAll();
            bgPanel.revalidate();
            bgPanel.repaint();
        } catch (Exception e) {
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

    public void showDataProductView() {
        refreshContent();
        bgPanel.add(componentDataProductView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDataSupplierView() {
        refreshContent();

        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDataKaryawanView() {
        refreshContent();

        bgPanel.add(componentDataKaryawanView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showTransactionsView() {
        refreshContent();

        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showInputDataProductView() {
        refreshContent();
        bgPanel.add(componentInputProductView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showUpdateDataProductView() {
        refreshContent();
        bgPanel.add(componentUpdateProductView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDeleteDataProductView() {
        refreshContent();
        bgPanel.add(componentDeleteProductView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showInputDataKaryawanView() {
        refreshContent();
        bgPanel.add(componentInputKaryawanView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showUpdateDataKaryawanView() {
        refreshContent();
        bgPanel.add(componentUpdateKaryawanView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDeleteDataKaryawanView() {
        refreshContent();
        bgPanel.add(componentDeleteKaryawanView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

}
