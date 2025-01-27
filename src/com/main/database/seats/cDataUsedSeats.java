package com.main.database.seats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.main.database.cConnectionDatabase;

public class cDataUsedSeats {
    public static DefaultTableModel getAllUsedSeats() {

        String[] dataHeader = { "ID", "Date", "Numbers", "Amount", "Description", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM vwalldatausedseats WHERE statusSeats = 'used'";
        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

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
