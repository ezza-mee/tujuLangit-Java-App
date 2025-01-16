package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cInsertPaymentTransaction {
    public static boolean handlePayment(int idTransaction, String payment) {
        String query = "INSERT INTO tbl_payment_transaction (idTransaction, payment) VALUES (?, ?)";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idTransaction);
            state.setString(2, payment);

            int affectedRows = state.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
