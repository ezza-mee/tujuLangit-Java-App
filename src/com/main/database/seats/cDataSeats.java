package com.main.database.seats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.main.database.cConnectionDatabase;

public class cDataSeats {
    public static DefaultTableModel getAllSeats() {

        String[] dataHeader = { "ID", "Type", "Amount", "Description", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM tbl_seats";
        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "SF00" + resultData.getInt("idSeats"),
                        resultData.getString("typeSeats"),
                        resultData.getString("amountSeats"),
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
