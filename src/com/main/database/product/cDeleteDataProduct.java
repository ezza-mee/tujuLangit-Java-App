package com.main.database.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cDeleteDataProduct {

    public static boolean handleDeleteDataProduct(int idProduct) {
        boolean data = false;

        String query = "DELETE FROM tbl_product WHERE idProduct = " + idProduct;

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
