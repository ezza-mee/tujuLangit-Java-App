package com.view.adminView;

import javax.swing.JLabel;

import com.main.resources.templates.cPanelContentApp;
import com.partials.*;

public class cHistoryTransactionView extends cPanelContentApp {

    // component label header Data Transactions
    private cBigFont labelHeaderDataTransactions = new cBigFont("History Transactions", 40, 5);

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    // componet panel data Transactions
    private cPanelRounded panelDataTransactions = new cPanelRounded(40, 80, 1050, 560, 10, 10);

    // component label data Transactions
    private cLabelInfo labelDataTransactions = new cLabelInfo("Data Transactions", 40, 30, 300, 30);

    public cHistoryTransactionView() {
        super();
        initsTrancationView();
    }

    private void initsTrancationView() {
        setVisible(true);

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        panelDataTransactions.add(labelDataTransactions);

        bgPanel.add(panelDataTransactions);
        bgPanel.add(labelHeaderDataTransactions);
        bgPanel.add(labelCopyright);

    }
}
