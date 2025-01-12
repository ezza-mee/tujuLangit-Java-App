package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.main.database.cConnectionDatabase;

public class cInsertDataTransaction {
    public static int handleTransaction(int idStaff, String nameStaff, int numberSeats, String nameCustomer,
            int amountTransaction, int priceTransaction, String description) {
        int idTransaction = -1;

        String query = "INSERT INTO tbl_transaction (idStaff, nameStaff, numberSeats, nameCustomer, amountTransaction, priceTransaction, description, status) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, 'Process')";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            state.setInt(1, idStaff);
            state.setString(2, nameStaff);
            state.setInt(3, numberSeats);
            state.setString(4, nameCustomer);
            state.setInt(5, amountTransaction);
            state.setInt(6, priceTransaction);
            state.setString(7, description);

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
