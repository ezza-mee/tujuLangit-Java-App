package com.model;

import javax.swing.JPanel;

import com.main.database.product.cLoadDataProduct.Product;
import com.main.resources.templates.cPanelContentApp;
import com.view.adminView.cHomeView;
import com.view.adminView.cTransactionsView;
import com.view.adminView.dataProductView.*;
import com.view.adminView.dataStaffView.*;
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

    private cDataStaffView componentDataStaffView;
    private cInputStaffView componentInputStaffView;
    private cUpdateStaffView componentUpdateStaffView;
    private cDeleteStaffView componentDeleteStaffView;

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

        componentDataStaffView = new cDataStaffView(this);
        componentInputStaffView = new cInputStaffView(this);
        componentUpdateStaffView = new cUpdateStaffView(this);
        componentDeleteStaffView = new cDeleteStaffView(this);
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

    protected void switchPanel(JPanel panel) {
        bgPanel.removeAll();
        bgPanel.add(panel);
        bgPanel.revalidate();
        bgPanel.repaint();
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
        componentDataProductView.loadDataProducts();
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDataSupplierView() {
        refreshContent();

        bgPanel.add(componentDataSupplierView);
        componentDataSupplierView.loadDataSuppliers();
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDataStaffView() {
        refreshContent();

        bgPanel.add(componentDataStaffView);
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

    public void showUpdateDataProductView(Product product) {
        refreshContent();
        bgPanel.add(componentUpdateProductView);
        cUpdateProductView updateProductView = new cUpdateProductView(this);
        updateProductView.setProductData(product);
        switchPanel(updateProductView);
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

    public void showInputDataStaffView() {
        refreshContent();
        bgPanel.add(componentInputStaffView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showUpdateDataStaffView(int idStaff, String nameStaff, String phoneNumber, String email, String address) {
        refreshContent();
        bgPanel.add(componentUpdateStaffView);
        componentUpdateStaffView.setDataStaff(idStaff, nameStaff, phoneNumber, email, address);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDeleteDataStaffView() {
        refreshContent();
        bgPanel.add(componentDeleteStaffView);
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

    public void showUpdateDataSupplierView(int idSupplier, String typeSupplier, int supplierAmount, int priceTotal,
            String descriptionProduct) {
        refreshContent();
        bgPanel.add(componentUpdateSupplierView);
        componentUpdateSupplierView.setDataSupplier(idSupplier, typeSupplier, supplierAmount, priceTotal,
                descriptionProduct);
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
