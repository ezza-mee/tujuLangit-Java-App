package com.view.karyawanView;

import com.main.resources.templates.cPanelContentApp;
import com.view.karyawanView.productView.*;
import com.view.karyawanView.seatsView.*;
import com.view.karyawanView.transaksiView.*;

public class cPanelContentView extends cPanelContentApp {

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

    public cPanelContentView() {
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
}
