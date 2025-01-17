package com.main.database.seats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.main.database.cConnectionDatabase;

public class cSearchDataSeats {
    public static DefaultTableModel searchSeats(String keyword) {

    String[] dataHeader = { "ID", "Date", "Number", "Amount", "Description", "Status" };

    DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
    String query = "SELECT * FROM tbl_seats WHERE descriptionSeats LIKE ?";
    try (Connection conn = cConnectionDatabase.getConnection();
            PreparedStatement state = conn.prepareStatement(query)) {

        // Menambahkan wildcard untuk pencarian
        state.setString(1, "%" + keyword + "%");

        ResultSet resultData = state.executeQuery();

        while (resultData.next()) {
            Object[] rowData = { "SF00" + resultData.getInt("idSeats"),
                    resultData.getString("dateTime"),
                    resultData.getInt("numberSeats"),
                    resultData.getInt("amountSeats"),
                    resultData.getString("descriptionSeats"),
                    resultData.getString("statusSeats") };
            tm.addRow(rowData);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return tm;
}

}
