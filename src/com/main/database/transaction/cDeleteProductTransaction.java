package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cDeleteProductTransaction {
    public static boolean handleDeleteDataProductTransaction(int idProductTransaction) {
        boolean data = false;

        String query = "DELETE FROM tbl_transaction_product WHERE idProductTransaction = " + idProductTransaction;

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

