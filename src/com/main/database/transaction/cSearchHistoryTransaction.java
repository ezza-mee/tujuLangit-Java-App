package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.main.database.cConnectionDatabase;

public class cSearchHistoryTransaction {
    public static DefaultTableModel searchTransaction(String keyword) {

        String[] dataHeader = { "ID", "ID Product Transaction", "ID Product", "Date", "Number", "Customer", "Amount",
                "Price Transaction", "Description", "Product", "Amount Product", "Price Product", "ID Payment",
                "Payment", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        // Query mencakup semua kolom untuk pencarian
        String query = "SELECT * FROM vwalldatahistorytransaction WHERE " +
                "idTransaction LIKE ? OR " +
                "idProductTransaction LIKE ? OR " +
                "idProduct LIKE ? OR " +
                "dateTime LIKE ? OR " +
                "numberSeats LIKE ? OR " +
                "nameCustomer LIKE ? OR " +
                "amountTransaction LIKE ? OR " +
                "priceTransaction LIKE ? OR " +
                "description LIKE ? OR " +
                "nameProduct LIKE ? OR " +
                "amountProduct LIKE ? OR " +
                "priceProduct LIKE ? OR " +
                "idPayment LIKE ? OR " +
                "payment LIKE ? OR " +
                "status LIKE ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            // Menambahkan wildcard untuk pencarian pada setiap parameter
            for (int i = 1; i <= 15; i++) {
                state.setString(i, "%" + keyword + "%");
            }

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "T00" + resultData.getInt("idTransaction"),
                        resultData.getInt("idProductTransaction"),
                        resultData.getInt("idProduct"),
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
