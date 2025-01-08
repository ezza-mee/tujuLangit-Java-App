package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cUpdateDataTransaction {

    // Update data pada tabel transaksi (tbl_transaction)
    public static boolean handleUpdateTransaction(int idTransaction, int numberSeats, String nameCustomer,
            int amountTransaction, int priceTransaction, String description) {
        boolean result = false;

        String query = "UPDATE tbl_transaction SET numberSeats = ?, nameCustomer = ?, amountTransaction = ?, "
                + "priceTransaction = ?, description = ? WHERE idTransaction = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            // Set the values for the query
            state.setInt(1, numberSeats);
            state.setString(2, nameCustomer);
            state.setInt(3, amountTransaction);
            state.setInt(4, priceTransaction);
            state.setString(5, description);
            state.setInt(6, idTransaction);

            // Execute the update query
            if (state.executeUpdate() > 0) {
                result = true; // If one or more rows are updated, return true
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Update data pada tabel produk transaksi (tbl_transaction_product)
    public static boolean handleUpdateTransactionProduct(int idTransaction, int idProductTransaction,
            String nameProduct,
            int amountProduct, int priceProduct) {
        boolean result = false;

        String query = "UPDATE tbl_transaction_product SET nameProduct = ?, amountProduct = ?, priceProduct = ? "
                + "WHERE idTransaction = ? AND idProductTransaction = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            // Set the values for the query
            state.setString(1, nameProduct);
            state.setInt(2, amountProduct);
            state.setInt(3, priceProduct);
            state.setInt(4, idTransaction);
            state.setInt(5, idProductTransaction);

            // Execute the update query
            if (state.executeUpdate() > 0) {
                result = true; // If one or more rows are updated, return true
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
