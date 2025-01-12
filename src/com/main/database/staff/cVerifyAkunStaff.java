package com.main.database.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.main.database.cConnectionDatabase;

public class cVerifyAkunStaff {

    // Metode untuk memverifikasi akun staff
    public static boolean verifyAkunStaff(String userName, String password) {
        boolean isValidLogin = false;

        String query = "SELECT COUNT(*) AS total FROM vwalldatastaff WHERE email = ? AND password = ?";
        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement statement = conn.prepareStatement(query)) {

            // Set parameter untuk query
            statement.setString(1, userName);
            statement.setString(2, password);

            // Eksekusi query
            ResultSet rs = statement.executeQuery();

            // Periksa apakah ada hasil
            if (rs.next()) {
                int total = rs.getInt("total");
                isValidLogin = total > 0; // Login valid jika ditemukan data
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValidLogin;
    }

    // Metode untuk mendapatkan ID staff berdasarkan email dan password
    public static int getStaffId(String userName, String password) {
        int staffId = -1; // Default ID jika tidak ditemukan

        String query = "SELECT idStaff FROM vwalldatastaff WHERE email = ? AND password = ?";
        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement statement = conn.prepareStatement(query)) {

            // Set parameter untuk query
            statement.setString(1, userName);
            statement.setString(2, password);

            // Eksekusi query
            ResultSet rs = statement.executeQuery();

            // Ambil ID staff jika ditemukan
            if (rs.next()) {
                staffId = rs.getInt("idStaff");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffId;
    }
}
