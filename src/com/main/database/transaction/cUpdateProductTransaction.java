package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.main.database.cConnectionDatabase;

public class cUpdateProductTransaction {
    public static boolean handleUpdateProductTransaction(int idProductTransaction, int idProduct, int idTransaction,
            String nameProduct, int amountProduct,
            int priceProduct) {
        boolean data = false;

        String query = "UPDATE tbl_transaction_product SET idProduct = ?, nameProduct = ?, amountProduct = ?, priceProduct = ? "
                + "WHERE idTransaction = ? AND idProductTransaction = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idProduct);
            state.setString(2, nameProduct);
            state.setInt(3, amountProduct);
            state.setInt(4, priceProduct);
            state.setInt(5, idTransaction);
            state.setInt(6, idProductTransaction);

            if (state.executeUpdate() > 0) {
                data = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static boolean isProductExistInTransaction(int idProductTransaction, int idProduct) {
        boolean exists = false;
        String query = "SELECT 1 FROM tbl_transaction_product WHERE idProductTransaction = ? AND idProduct = ? LIMIT 1";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idProductTransaction);
            stmt.setInt(2, idProduct);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }

}
