package com.main.database.seats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cUpdateDataSeats {
    public static boolean handleUpdateSeats(int idSeats, String typeSeats, int amountSeats, String descriptionSeats,
            String statusSeats) {
        boolean result = false;

        String query = "UPDATE tbl_seats SET typeSeats = ?, amountSeats = ?, descriptionSeats = ?, statusSeats = ? WHERE idSeats = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, typeSeats);
            state.setInt(2, amountSeats);
            state.setString(3, descriptionSeats);
            state.setString(4, statusSeats);
            state.setInt(5, idSeats);

            if (state.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
