package com.main.database.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cKoneksiDatabase;

public class cUpdateDataProduct {

    public static boolean handleUpdete(int idProduct, String nameProduct, String imageProduct, int countProduct,
            int priceProduct,
            String descriptionProduct, String typeProduct, String statusProduct) {
        boolean data = false;

        String query = "UPDATE tbl_product SET nameProduct = ?, imageProduct = ?, countProduct = ?, priceProduct = ?, descriptionProduct = ?, typeProduct = ?, statusProduct = ? WHERE idProduct = ?";

        try (Connection conn = cKoneksiDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {
            state.setString(1, nameProduct);
            state.setString(2, imageProduct);
            state.setInt(3, countProduct);
            state.setInt(4, priceProduct);
            state.setString(5, descriptionProduct);
            state.setString(6, typeProduct);
            state.setString(7, statusProduct);
            state.setInt(8, idProduct);

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
