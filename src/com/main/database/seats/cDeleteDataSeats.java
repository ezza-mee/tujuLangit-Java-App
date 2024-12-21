package com.main.database.seats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cDeleteDataSeats {
    public static boolean handleDeleteDataSeats(int idSeats) {
        boolean data = false;

        String query = "DELETE FROM tbl_seats WHERE idSeats = " + idSeats;

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            int rowsAffected = state.executeUpdate();

            if (rowsAffected > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
