package com.view.adminView;

import com.main.resources.templates.cPanelContentApp;

public class cPanelContentView extends cPanelContentApp {

    public cPanelContentView() {
        super();
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

        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showDataKaryawanView() {
        refreshContent();

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

    public void showHistoryTransaksiView() {
        refreshContent();

        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

    public void showHistorySupplierView() {
        refreshContent();

        bgPanel.revalidate();
        bgPanel.repaint();

        setVisible(true);
    }

}
