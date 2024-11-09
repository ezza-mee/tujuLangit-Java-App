package com.model;

import com.main.resources.templates.cPanelContentApp;
import com.view.adminView.cHomeView;
import com.view.adminView.cTransactionsView;
import com.view.adminView.dataKaryawanView.*;
import com.view.adminView.dataProductView.*;
import com.view.adminView.dataSupplierView.*;

public class cContentAdminView extends cPanelContentApp {

    private cHomeView componentHomeView = new cHomeView();

    private cDataProductView componentDataProductView;
    private cInputProductView componentInputProductView;
    private cUpdateProductView componentUpdateProductView;
    private cDeleteProductView componentDeleteProductView;

    private cDataSupplierView componentDataSupplierView;
    private cInputSupplierView componentInputSupplierView;
    private cUpdateSupplierView componentUpdateSupplierView;
    private cDeleteSupplierView componentDeleteSupplierView;

    private cDataKaryawanView componentDataKaryawanView;
    private cInputKaryawanView componentInputKaryawanView;
    private cUpdateKaryawanView componentUpdateKaryawanView;
    private cDeleteKaryawanView componentDeleteKaryawanView;

    private cTransactionsView componentTransactionsView = new cTransactionsView();

    public cContentAdminView() {
        super();

        componentDataProductView = new cDataProductView(this);
        componentInputProductView = new cInputProductView(this);
        componentUpdateProductView = new cUpdateProductView(this);
        componentDeleteProductView = new cDeleteProductView(this);

        componentDataSupplierView = new cDataSupplierView(this);
        componentInputSupplierView = new cInputSupplierView(this);
        componentUpdateSupplierView = new cUpdateSupplierView(this);
        componentDeleteSupplierView = new cDeleteSupplierView(this);

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

        bgPanel.add(componentDataSupplierView);
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
        bgPanel.add(componentTransactionsView);
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

    public void showInputDataSupplierView() {
        refreshContent();
        bgPanel.add(componentInputSupplierView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showUpdateDataSupplierView() {
        refreshContent();
        bgPanel.add(componentUpdateSupplierView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDeleteDataSupplierView() {
        refreshContent();
        bgPanel.add(componentDeleteSupplierView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

}
