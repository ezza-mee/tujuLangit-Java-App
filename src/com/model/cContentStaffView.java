package com.model;

import com.main.resources.templates.cPanelContentApp;
import com.view.staffView.cHistoryTransaksiView;
import com.view.staffView.cHomeView;
import com.view.staffView.productView.*;
import com.view.staffView.reportView.cDataReportStaffView;
import com.view.staffView.seatsView.*;
import com.view.staffView.transaksiView.*;

public class cContentStaffView extends cPanelContentApp {

    private cHomeView componentHomeView = new cHomeView();
    private cDataProductView componentProductView;
    private cDataSeatsView componentSeatsView;
    private cDataTransaksiView componentTransaksiView;
    private cHistoryTransaksiView componentHistoryTransaksiView = new cHistoryTransaksiView();

    private cInputSeatsView componentInputSeatsView;
    private cUpdateSeatsView componentUpdateSeatsView;

    private cInputTransaksiView componentInputTransaksiView;
    private cUpdateTransaksiView componentUpdateTransaksiView;
    private cInsertProductTransaksiView componentInsertProductTransaksiView;
    private cUpdateProductTransaksiView componentUpdateProductTransaksiView;

    private cDataReportStaffView componentReportSeatsView;

    public cContentStaffView() {
        super();
        componentProductView = new cDataProductView(this);

        componentSeatsView = new cDataSeatsView(this);
        componentInputSeatsView = new cInputSeatsView(this);
        componentUpdateSeatsView = new cUpdateSeatsView(this);

        componentTransaksiView = new cDataTransaksiView(this);
        componentInputTransaksiView = new cInputTransaksiView(this);
        componentUpdateTransaksiView = new cUpdateTransaksiView(this);
        componentInsertProductTransaksiView = new cInsertProductTransaksiView(this, componentInputTransaksiView);
        componentUpdateProductTransaksiView = new cUpdateProductTransaksiView(this, componentUpdateTransaksiView);

        componentReportSeatsView = new cDataReportStaffView(this);

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
        componentHomeView.loadData();
        bgPanel.add(componentHomeView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDataProductView() {
        refreshContent();
        bgPanel.add(componentProductView);
        componentProductView.loadDataProducts();
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showSeatsView() {
        refreshContent();
        bgPanel.add(componentSeatsView);
        componentSeatsView.loadDataSeats();
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDataTransaksiView() {
        refreshContent();
        bgPanel.add(componentTransaksiView);
        componentTransaksiView.loadDataTransaction();
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showHistoryTransaksiView() {
        refreshContent();
        componentHistoryTransaksiView.loadDataTransaction();
        bgPanel.add(componentHistoryTransaksiView);
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

    public void showUpdateDataSeatsView(int idSeats, String typeSeats, int amountSeats, String descriptionSeats,
            String statusSeats) {
        refreshContent();
        bgPanel.add(componentUpdateSeatsView);
        componentUpdateSeatsView.setDataSeats(idSeats, typeSeats, amountSeats, descriptionSeats, statusSeats);
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

    public void showUpdateTransaksiView(int idTransaction, int idProduct, int idProductTransaction, String numberSeats,
            String nameCustomer,
            int amountTransaction, int priceTransaction, String description,
            String nameProduct, int amountProduct, int priceProduct) {
        refreshContent();
        bgPanel.add(componentUpdateTransaksiView);
        componentUpdateTransaksiView.setDataTransaction(idTransaction, idProduct, idProductTransaction, numberSeats,
                nameCustomer, amountTransaction, priceTransaction, description,
                nameProduct, amountProduct, priceProduct);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showTransaksiUpdateView() {
        refreshContent();
        bgPanel.add(componentUpdateTransaksiView);
        bgPanel.revalidate();
        bgPanel.repaint();
        setVisible(true);
    }

    public void showInsertProductTransaksiView() {
        refreshContent();
        bgPanel.add(componentInsertProductTransaksiView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showUpdateProductTransaksiView() {
        refreshContent();
        bgPanel.add(componentUpdateProductTransaksiView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showReportDataSeatsView() {
        refreshContent();
        bgPanel.add(componentReportSeatsView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }
}
