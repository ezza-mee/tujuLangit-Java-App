package com.main.database.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.main.database.cConnectionDatabase;

public class cDataProduct {
    public static DefaultTableModel getAllDataProduct() {

        String[] dataHeader = { "ID", "Date", "Product", "Amount", "Description", "type", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldataproduct";
        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "SF00" + resultData.getInt("idProduct"),
                        resultData.getString("dateTime"),
                        resultData.getString("nameProduct"),
                        resultData.getInt("countProduct"),
                        resultData.getInt("priceProduct"),
                        resultData.getString("descriptionProduct"),
                        resultData.getString("typeProduct"),
                        resultData.getString("statusProduct") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }
}
