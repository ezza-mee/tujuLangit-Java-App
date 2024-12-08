package com.main.database.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.main.database.cConnectionDatabase;

public class cDataStaff {
    public static DefaultTableModel getAllStaff() {

        String[] dataHeader = { "ID", "Name", "Phone number", "Email", "Jobdesk", "Address", "Status" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM tbl_staff";
        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "SF00" + resultData.getInt("idStaff"),
                        resultData.getString("nameStaff"),
                        resultData.getString("phoneNumber"),
                        resultData.getString("email"),
                        resultData.getString("jobdesk"),
                        resultData.getString("address"),
                        resultData.getString("status") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }
}
