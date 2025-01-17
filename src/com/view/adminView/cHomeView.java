package com.view.adminView;

import javax.swing.JLabel;

import com.main.database.product.cCountDataProduct;
import com.main.database.staff.cCountDataStaff;
import com.main.database.supplier.cCountDataSupplier;
import com.main.database.transaction.cCountDataTransaction;
import com.main.resources.templates.cPanelContentApp;

import com.partials.*;

public class cHomeView extends cPanelContentApp {

    // component copyright
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2025. TujuLangit ForestPark", 0, 650, 1126, 40);

    // component beranda
    private cPanelRounded panelDataProduct = new cPanelRounded(40, 40, 240, 130, 10, 10);
    private cPanelRounded panelDataStaff = new cPanelRounded(310, 40, 240, 130, 10, 10);
    private cPanelRounded panelDataSupplier = new cPanelRounded(580, 40, 240, 130, 10, 10);
    private cPanelRounded panelDataHistory = new cPanelRounded(850, 40, 240, 130, 10, 10);
    private cPanelRounded panelListSupplier = new cPanelRounded(40, 210, 1050, 430, 10, 10);

    // component label beranda
    private cLabelInfo labelDataProduct = new cLabelInfo("Data Product", 0, 10, 240, 40);
    private cLabelInfo labelDataStaff = new cLabelInfo("Data Staff", 0, 10, 240, 40);
    private cLabelInfo labelDataSupplier = new cLabelInfo("Data Supplier", 0, 10, 240, 40);
    private cLabelInfo labelDataHistory = new cLabelInfo("Data History", 0, 10, 240, 40);
    private cLabelInfo labelListSupplier = new cLabelInfo("List Supplier", 30, 20, 580, 40);

    // component value data beranda
    private cLabelInfo valueDataProduct = new cLabelInfo("0", 0, 60, 240, 40);
    private cLabelInfo valueDataStaff = new cLabelInfo("0", 0, 60, 240, 40);
    private cLabelInfo valueDataSupplier = new cLabelInfo("0", 0, 60, 240, 40);
    private cLabelInfo valueDataHistory = new cLabelInfo("0", 0, 60, 240, 40);

    // component gambar data beranda
    private cImage imgDataProduct = new cImage("src/com/main/resources/images/menu(green).png", 20, 50, 55, 50);
    private cImage imgDataStaff = new cImage("src/com/main/resources/images/datakursi(green).png", 20, 50, 55, 50);
    private cImage imgDataSupplier = new cImage("src/com/main/resources/images/dataSupplier(green).png", 20, 50, 55,
            50);
    private cImage imgDataHistory = new cImage("src/com/main/resources/images/history(green).png", 20, 50, 55, 50);

    // component button data beranda
    private cButtonRounded btnListSupplier = new cButtonRounded("see all", 900, 20, 110, 40, 10);

    public cHomeView() {
        super();
        initsShowHomeView();
    }

    public void refreshContent() {
        try {
            valueDataProduct.removeAll();
            valueDataProduct.revalidate();
            valueDataProduct.repaint();

            valueDataStaff.removeAll();
            valueDataStaff.revalidate();
            valueDataStaff.repaint();

            valueDataSupplier.removeAll();
            valueDataSupplier.revalidate();
            valueDataSupplier.repaint();

            valueDataHistory.removeAll();
            valueDataHistory.revalidate();
            valueDataHistory.repaint();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initsShowHomeView() {
        refreshContent();

        valueDataProduct.setText(String.valueOf(cCountDataProduct.getTotalProductCount()));
        valueDataStaff.setText(String.valueOf(cCountDataStaff.getTotalStaffCount()));
        valueDataSupplier.setText(String.valueOf(cCountDataSupplier.getTotalSupplierCount()));
        valueDataHistory.setText(String.valueOf(cCountDataTransaction.getTotalTransacitonCount()));

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        labelDataProduct.setHorizontalAlignment(JLabel.CENTER);
        labelDataStaff.setHorizontalAlignment(JLabel.CENTER);
        labelDataSupplier.setHorizontalAlignment(JLabel.CENTER);
        labelDataHistory.setHorizontalAlignment(JLabel.CENTER);

        valueDataProduct.setHorizontalAlignment(JLabel.CENTER);
        valueDataStaff.setHorizontalAlignment(JLabel.CENTER);
        valueDataSupplier.setHorizontalAlignment(JLabel.CENTER);
        valueDataHistory.setHorizontalAlignment(JLabel.CENTER);

        panelDataProduct.add(labelDataProduct);
        panelDataProduct.add(imgDataProduct);

        panelDataStaff.add(labelDataStaff);
        panelDataStaff.add(imgDataStaff);

        panelDataSupplier.add(labelDataSupplier);
        panelDataSupplier.add(imgDataSupplier);

        panelDataHistory.add(labelDataHistory);
        panelDataHistory.add(imgDataHistory);

        panelDataProduct.add(valueDataProduct);
        panelDataStaff.add(valueDataStaff);
        panelDataSupplier.add(valueDataSupplier);
        panelDataHistory.add(valueDataHistory);

        panelListSupplier.add(labelListSupplier);
        panelListSupplier.add(btnListSupplier);

        bgPanel.add(panelDataProduct);
        bgPanel.add(panelDataStaff);
        bgPanel.add(panelDataSupplier);
        bgPanel.add(panelDataHistory);
        bgPanel.add(panelListSupplier);
        bgPanel.add(labelCopyright);

        loadData();

        setVisible(true);
    }

    public void loadData() {
        refreshContent();
        try {
            valueDataProduct.setText(String.valueOf(cCountDataProduct.getTotalProductCount()));
            valueDataStaff.setText(String.valueOf(cCountDataStaff.getTotalStaffCount()));
            valueDataSupplier.setText(String.valueOf(cCountDataSupplier.getTotalSupplierCount()));
            valueDataHistory.setText(String.valueOf(cCountDataTransaction.getTotalTransacitonCount()));

            valueDataProduct.revalidate();
            valueDataProduct.repaint();
            valueDataStaff.revalidate();
            valueDataStaff.repaint();
            valueDataSupplier.revalidate();
            valueDataSupplier.repaint();
            valueDataHistory.revalidate();
            valueDataHistory.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
