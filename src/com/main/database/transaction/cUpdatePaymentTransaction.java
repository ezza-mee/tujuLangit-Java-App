package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cUpdatePaymentTransaction {
    public static boolean updatePayment(int idTransaction, String newPayment) {
        String query = "UPDATE tbl_payment_transaction SET payment = ? WHERE idTransaction = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, newPayment);
            state.setInt(2, idTransaction);

            int affectedRows = state.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
