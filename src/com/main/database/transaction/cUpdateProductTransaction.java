package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.main.database.cConnectionDatabase;

public class cUpdateProductTransaction {
    public static boolean handleUpdateProductTransaction(int idTransaction, String nameProduct, int amountProduct,
            int priceProduct) {
        boolean data = false;

        String query = "UPDATE tbl_transaction_product SET nameProduct = ?, amountProduct = ?, priceProduct = ? "
                + "WHERE idTransaction = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, nameProduct);
            state.setInt(2, amountProduct);
            state.setInt(3, priceProduct);
            state.setInt(4, idTransaction);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}
