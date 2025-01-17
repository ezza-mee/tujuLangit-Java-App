package com.main.database.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import com.main.database.cConnectionDatabase;

public class cSearchDataStaff {
    public static DefaultTableModel searchStaff(String keyword) {

        String[] dataHeader = { "ID", "Date", "Name", "Phone number", "Email", "Jobdesk", "Address", "Status" };
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        // Query pencarian (pastikan nama kolom sesuai dengan database)
        String query = "SELECT * FROM tbl_staff WHERE idStaff LIKE ? OR nameStaff LIKE ? OR phoneNumber LIKE ? OR email LIKE ? OR password LIKE ? OR jobdesk LIKE ? OR address LIKE ? OR status LIKE ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            for (int i = 1; i <= 8; i++) {
                state.setString(i, "%" + keyword + "%");
            }

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = {
                        "NS00" + resultData.getInt("idStaff"),
                        resultData.getString("dateTime"),
                        resultData.getString("nameStaff"),
                        resultData.getString("phoneNumber"),
                        resultData.getString("email"),
                        resultData.getString("jobdesk"),
                        resultData.getString("address"),
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
