package com.main.database.seats;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cInsertDataSeats {
    public static boolean dataSeats(String typeSeats, int amountSeats, String descriptionSeats, String statusSeats) {
        boolean data = false;
        
        String query = "INSERT INTO tbl_seats (typeSeats, amountSeats, descriptionSeats, statusSeats) VALUES (?, ?, ?, ?)";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);) {

            state.setString(1, typeSeats);
            state.setInt(2, amountSeats);
            state.setString(3, descriptionSeats);
            state.setString(4, statusSeats);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
