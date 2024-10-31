package com.view.karyawanView;

import com.main.resources.templates.cPanelContentApp;
import com.view.karyawanView.productView.cDataProductView;
import com.view.karyawanView.productView.cDeleteProductView;
import com.view.karyawanView.productView.cInputMenuProductView;
import com.view.karyawanView.productView.cUpadateProductView;
import com.view.karyawanView.seatsView.cDataSeatsView;
import com.view.karyawanView.transaksiView.cDataTransaksiView;

public class cPanelContentView extends cPanelContentApp {

    private cHomeView componentHomeView = new cHomeView();
    private cDataProductView componentProductView;
    private cDataSeatsView componentSeatsView = new cDataSeatsView();
    private cDataTransaksiView componentTransaksiView = new cDataTransaksiView();
    private cHistoryTransaksiView componentHistoryTransaksiView = new cHistoryTransaksiView();

    private cInputMenuProductView componentInputProductView;
    private cUpadateProductView componentUpdateProductView = new cUpadateProductView();
    private cDeleteProductView componentDeleteProductView = new cDeleteProductView();

    public cPanelContentView() {
        super();
        componentProductView = new cDataProductView(this);
        componentInputProductView = new cInputMenuProductView(this);
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

    public void showTransaksiView() {
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
}
