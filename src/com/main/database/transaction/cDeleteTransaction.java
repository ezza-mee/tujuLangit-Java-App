package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cDeleteTransaction {
    public static boolean handleDeleteDataTransaction(int idTransaction) {
        boolean data = false;

        String query = "DELETE FROM tbl_transaction WHERE idTransaction = " + idTransaction;

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
