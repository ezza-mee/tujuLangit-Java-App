package com.main.database.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cInsertDataStaff {
    public static boolean dataStaff(String nameStaff, String phoneNumber, String email, String jobdesk, String address, String status) {
        boolean data = false;

        String query = "INSERT INTO tbl_staff (nameStaff, phoneNumber, email, jobdesk, address, status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = cConnectionDatabase.getConnection();
                    PreparedStatement state = conn.prepareStatement(query);) { 

                state.setString(1, nameStaff);  
                state.setString(2, phoneNumber);
                state.setString(3, email);
                state.setString(4, jobdesk);
                state.setString(5, address);
                state.setString(6, status);

                if (state.executeUpdate() > 0) {
                    data = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return data;
        }
    
}
