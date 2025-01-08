package com.model;

import com.main.resources.templates.cPanelContentApp;
import com.view.StaffView.cHistoryTransaksiView;
import com.view.StaffView.cHomeView;
import com.view.StaffView.productView.*;
import com.view.StaffView.seatsView.*;
import com.view.StaffView.transaksiView.*;

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
    private cDataProductTransaksiView componentDataProductTransaksiView;

    public cContentStaffView() {
        super();
        componentProductView = new cDataProductView(this);

        componentSeatsView = new cDataSeatsView(this);
        componentInputSeatsView = new cInputSeatsView(this);
        componentUpdateSeatsView = new cUpdateSeatsView(this);

        componentTransaksiView = new cDataTransaksiView(this);
        componentInputTransaksiView = new cInputTransaksiView(this);
        componentUpdateTransaksiView = new cUpdateTransaksiView(this);
        componentDataProductTransaksiView = new cDataProductTransaksiView(this, componentInputTransaksiView);

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

    public void showUpdateTransaksiView(int idTransaction, String numberSeats, String nameCustomer,
            int amountTransaction, int priceTransaction, String description,
            String nameProduct, int amountProduct, int priceProduct) {
        refreshContent();
        bgPanel.add(componentUpdateTransaksiView);
        componentUpdateTransaksiView.setDataTransaction(idTransaction, numberSeats,
                nameCustomer, amountTransaction, priceTransaction, description,
                nameProduct, amountProduct, priceProduct);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDataProductTransaksiView() {
        refreshContent();
        bgPanel.add(componentDataProductTransaksiView);
        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }
}
