package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.main.database.cConnectionDatabase;

public class cUpdateDataTransaction {
    public static boolean handleUpdateTransaction(int idTransaction, int numberSeats, String nameCustomer,
            int amountTransaction, int priceTransaction, String description) {
        boolean data = false;

        String query = "UPDATE tbl_transaction SET numberSeats = ?, nameCustomer = ?, amountTransaction = ?,  priceTransaction = ?, description = ? WHERE idTransaction = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, numberSeats);
            state.setString(2, nameCustomer);
            state.setInt(3, amountTransaction);
            state.setInt(4, priceTransaction);
            state.setString(5, description);
            state.setInt(6, idTransaction);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
