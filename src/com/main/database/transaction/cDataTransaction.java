package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.main.database.cConnectionDatabase;

public class cDataTransaction {
    public static DefaultTableModel getAllTransaction() {

        String[] dataHeader = { "ID", "ID", "ID", "ID", "Staff", "Date", "Number", "Customer", "Amount", "Price", "Description",
                "Product", "Amount", "price", "ID", "Pyament", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalltransaction";
        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "T00" + resultData.getInt("idTransaction"),
                        resultData.getInt("idProductTransaction"),
                        resultData.getInt("idProduct"),
                        resultData.getInt("idStaff"),
                        resultData.getString("nameStaff"),
                        resultData.getString("dateTime"),
                        resultData.getInt("numberSeats"),
                        resultData.getString("nameCustomer"),
                        resultData.getInt("amountTransaction"),
                        "Rp. " + resultData.getInt("priceTransaction"),
                        resultData.getString("description"),
                        resultData.getString("nameProduct"),
                        resultData.getInt("amountProduct"),
                        "Rp. " + resultData.getInt("priceProduct"),
                        resultData.getInt("idPayment"),
                        resultData.getString("payment"),
                        resultData.getString("status")
                };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }
}
