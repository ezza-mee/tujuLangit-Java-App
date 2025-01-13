package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cInsertProductTransaction {
    public static boolean insertProductTransaction(int idProduct, int idTransaction, String nameProduct,
            int amountProduct, int priceProduct) {
        boolean data = false;

        String query = "INSERT INTO tbl_transaction_product (idProduct, idTransaction, nameProduct, amountProduct, priceProduct) VALUES (?, ?, ?, ?,?)";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idProduct);
            state.setInt(2, idTransaction);
            state.setString(3, nameProduct);
            state.setInt(4, amountProduct);
            state.setInt(5, priceProduct);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

}
