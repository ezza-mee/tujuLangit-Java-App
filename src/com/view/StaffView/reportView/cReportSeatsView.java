package com.view.staffView.reportView;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.main.database.seats.cDataSeats;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.cBigFont;
import com.partials.cFonts;
import com.partials.cLabelInfo;
import com.partials.cPanelRounded;
import com.partials.cScrollTable;
import com.partials.cTable;

public class cReportSeatsView extends cPanelContentApp {

    private cContentStaffView parentPanel;

    // component header data Seats
    private cBigFont labelHeaderDataSeats = new cBigFont("Seats", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelListSeats = new cPanelRounded(40, 80, 1050, 560, 10, 10);
    private cPanelRounded panelTableReadySeats = new cPanelRounded(0, 80, 1050, 400, 0, 0);

    // component label data Seats
    private cLabelInfo labelListDataSeats = new cLabelInfo("List Data Seats", 30, 30, 580, 30);

    private cTable tblDataSeats;
    private cScrollTable spDataSeats;

    public cReportSeatsView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;

        initsReportDataSeatsView();
    }

    public void refreshContent() {
        try {
            panelTableReadySeats.removeAll();
            panelTableReadySeats.revalidate();
            panelTableReadySeats.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initsReportDataSeatsView() {
        refreshContent();

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        tblDataSeats = new cTable(cDataSeats.getAllSeats());
        spDataSeats = new cScrollTable(tblDataSeats, 0, 0, 1050, 400);

        panelTableReadySeats.add(spDataSeats);
        panelListSeats.add(panelTableReadySeats);

        panelListSeats.add(labelListDataSeats);

        bgPanel.add(labelHeaderDataSeats);

        bgPanel.add(panelListSeats);
        bgPanel.add(labelCopyright);

        loadDataSeats();

        setVisible(true);
    }

    public void loadDataSeats() {
        DefaultTableModel modelTableReadySeats = cDataSeats.getAllSeats();

        tblDataSeats.setModel(modelTableReadySeats);

        panelListSeats.revalidate();
        panelListSeats.repaint();

        tblDataSeats.getColumnModel().getColumn(0).setMinWidth(65);
        tblDataSeats.getColumnModel().getColumn(0).setMaxWidth(65);
        tblDataSeats.getColumnModel().getColumn(0).setWidth(65);

        tblDataSeats.getColumnModel().getColumn(1).setMinWidth(120);
        tblDataSeats.getColumnModel().getColumn(1).setMaxWidth(120);
        tblDataSeats.getColumnModel().getColumn(1).setWidth(120);

        tblDataSeats.getColumnModel().getColumn(2).setMinWidth(75);
        tblDataSeats.getColumnModel().getColumn(2).setMaxWidth(75);
        tblDataSeats.getColumnModel().getColumn(2).setWidth(75);

        tblDataSeats.getColumnModel().getColumn(3).setMinWidth(250);
        tblDataSeats.getColumnModel().getColumn(3).setMaxWidth(250);
        tblDataSeats.getColumnModel().getColumn(3).setWidth(250);

        tblDataSeats.getColumnModel().getColumn(4).setMinWidth(90);
        tblDataSeats.getColumnModel().getColumn(4).setMaxWidth(90);
        tblDataSeats.getColumnModel().getColumn(4).setWidth(90);

    }
}
