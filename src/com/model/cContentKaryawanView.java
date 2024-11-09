package com.model;

import com.main.resources.templates.cPanelContentApp;
import com.view.karyawanView.cHistoryTransaksiView;
import com.view.karyawanView.cHomeView;
import com.view.karyawanView.productView.*;
import com.view.karyawanView.seatsView.*;
import com.view.karyawanView.transaksiView.*;

public class cContentKaryawanView extends cPanelContentApp {

    private cHomeView componentHomeView = new cHomeView();
    private cDataProductView componentProductView;
    private cDataSeatsView componentSeatsView;
    private cDataTransaksiView componentTransaksiView;
    private cHistoryTransaksiView componentHistoryTransaksiView = new cHistoryTransaksiView();

    private cInputProductView componentInputProductView;
    private cUpdateProductView componentUpdateProductView;
    private cDeleteProductView componentDeleteProductView;

    private cInputSeatsView componentInputSeatsView;
    private cUpdateSeatsView componentUpdateSeatsView;
    private cDeleteSeatsView componentDeleteSeatsView;

    private cInputTransaksiView componentInputTransaksiView;
    private cUpdateTransaksiView componentUpdateTransaksiView;
    private cDeleteTransaksiView componentDeleteTransaksiView;

    public cContentKaryawanView() {
        super();
        componentProductView = new cDataProductView(this);
        componentInputProductView = new cInputProductView(this);
        componentUpdateProductView = new cUpdateProductView(this);
        componentDeleteProductView = new cDeleteProductView(this);

        componentSeatsView = new cDataSeatsView(this);
        componentInputSeatsView = new cInputSeatsView(this);
        componentUpdateSeatsView = new cUpdateSeatsView(this);
        componentDeleteSeatsView = new cDeleteSeatsView(this);

        componentTransaksiView = new cDataTransaksiView(this);
        componentInputTransaksiView = new cInputTransaksiView(this);
        componentUpdateTransaksiView = new cUpdateTransaksiView(this);
        componentDeleteTransaksiView = new cDeleteTransaksiView(this);
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

    public void showProductView() {
        refreshContent();
        bgPanel.add(componentProductView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showSeatsView() {
        refreshContent();
        bgPanel.add(componentSeatsView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDataTransaksiView() {
        refreshContent();
        bgPanel.add(componentTransaksiView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showHistoryTransaksiView() {
        refreshContent();
        bgPanel.add(componentHistoryTransaksiView);
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

    public void showInputDataSeatsView() {
        refreshContent();
        bgPanel.add(componentInputSeatsView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showUpdateDataSeatsView() {
        refreshContent();
        bgPanel.add(componentUpdateSeatsView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDeleteDataSeatsView() {
        refreshContent();
        bgPanel.add(componentDeleteSeatsView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showInputTransaksiView() {
        refreshContent();
        bgPanel.add(componentInputTransaksiView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showUpdateTransaksiView() {
        refreshContent();
        bgPanel.add(componentUpdateTransaksiView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDeleteTransaksiView() {
        refreshContent();
        bgPanel.add(componentDeleteTransaksiView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }
}
