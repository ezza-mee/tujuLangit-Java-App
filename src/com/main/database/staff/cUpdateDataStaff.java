package com.main.database.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cUpdateDataStaff {
    public static boolean handleUpdateStaff(int idStaff, String nameStaff, String phoneNumber, String email,
            String jobdesk, String address, String status) {
        boolean result = false;

        String query = "UPDATE tbl_Staff SET nameStaff = ?, phoneNumber = ?, email = ?, jobdesk = ?, address = ?, status = ? WHERE idStaff = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, nameStaff);
            state.setString(2, phoneNumber);
            state.setString(3, email);
            state.setString(4, jobdesk);
            state.setString(5, address);
            state.setString(6, status);
            state.setInt(7, idStaff);

            if (state.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
