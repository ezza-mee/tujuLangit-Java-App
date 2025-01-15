package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.main.database.cConnectionDatabase;

public class cUpdateDataTransaction {
    public static boolean handleUpdateTransaction(int idTransaction, int idStaff, String nameStaff, int numberSeats,
            String nameCustomer,
            int amountTransaction, int priceTransaction, String description) {
        boolean data = false;

        String updateQuery = "UPDATE tbl_transaction SET idStaff = ?, dateTime = NOW(), nameStaff = ?, numberSeats = ?, "
                + "nameCustomer = ?, amountTransaction = ?, priceTransaction = ?, description = ?, status = 'Process' "
                + "WHERE idTransaction = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(updateQuery)) {

            state.setInt(1, idStaff);
            state.setString(2, nameStaff);
            state.setInt(3, numberSeats);
            state.setString(4, nameCustomer);
            state.setInt(5, amountTransaction);
            state.setInt(6, priceTransaction);
            state.setString(7, description);
            state.setInt(8, idTransaction);

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
