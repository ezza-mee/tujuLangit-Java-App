package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.main.database.cConnectionDatabase;

public class cInsertTransaction {
    public static int handleTransaction(int numberSeats, String nameCustomer, int amountTransaction,
            int priceTransaction, String description) {
        int idTransaction = -1;

        String query = "INSERT INTO tbl_transaction (numberSeats, nameCustomer, amountTransaction, priceTransaction, description) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            state.setInt(1, numberSeats);
            state.setString(2, nameCustomer);
            state.setInt(3, amountTransaction);
            state.setInt(4, priceTransaction);
            state.setString(5, description);

            int affectedRows = state.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = state.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        idTransaction = generatedKeys.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return idTransaction;
    }
}
