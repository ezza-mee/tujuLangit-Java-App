package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.main.database.cConnectionDatabase;

public class cUpdateProductTransaction {
    public static boolean updateProductTransaction(int idTransaction, String nameProduct, int amountProduct,
            int priceProduct) {
        boolean data = false;

        String query = "UPDATE tbl_transaction_product SET amountProduct = ?, priceProduct = ? "
                + "WHERE idTransaction = ? AND nameProduct = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, amountProduct); // Set new amount
            state.setInt(2, priceProduct); // Set new price
            state.setInt(3, idTransaction); // Set the transaction ID to update
            state.setString(4, nameProduct); // Set the product name to identify the record

            if (state.executeUpdate() > 0) {
                data = true; // Update success
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
