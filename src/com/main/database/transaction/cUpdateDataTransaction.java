package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.main.database.cConnectionDatabase;

public class cUpdateDataTransaction {
    public static boolean handleUpdateTransaction(int idTransaction, int numberSeats, String nameCustomer,
            int amountTransaction, int priceTransaction, String description) {
        boolean isUpdated = false;

        String query = "UPDATE tbl_transaction SET numberSeats = ?, nameCustomer = ?, amountTransaction = ?, "
                + "priceTransaction = ?, description = ? WHERE idTransaction = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, numberSeats);
            state.setString(2, nameCustomer);
            state.setInt(3, amountTransaction);
            state.setInt(4, priceTransaction);
            state.setString(5, description);
            state.setInt(6, idTransaction);

            int affectedRows = state.executeUpdate();

            if (affectedRows > 0) {
                isUpdated = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isUpdated;
    }

    public static boolean handleUpdateTransactionProduct(int idTransaction, String nameProduct, int count,
            int unitPrice) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdateTransactionProduct'");
    }
}
