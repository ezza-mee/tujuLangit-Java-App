package com.main.database.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.main.database.cConnectionDatabase;

public class cVerifyAkunStaff {

    public static boolean verifyAkunStaff(String email, String password) {
        boolean available = false;

        String query = "SELECT COUNT(*) FROM vwalldatastaff WHERE email = ? AND password = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setString(1, email);
            statement.setString(2, password);

            ResultSet resultData = statement.executeQuery();

            if (resultData.next() && resultData.getInt(1) == 1) {
                available = true; 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return available; 
    }
}
