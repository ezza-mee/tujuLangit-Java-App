package com.main.database.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cUpdateDataSupplier {
    public static boolean handleUpdateSupplier(int idSupplier, String typeSupplier, int supplierAmount, int priceTotal,
            String descriptionSupplier) {
        boolean result = false;

        String query = "UPDATE tbl_supplier SET dateTime = NOW(), typeSupplier = ?, supplierAmount = ?, priceTotal = ?, descriptionProduct = ? WHERE idSupplier = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setString(1, typeSupplier);
            state.setInt(2, supplierAmount);
            state.setInt(3, priceTotal);
            state.setString(4, descriptionSupplier);
            state.setInt(5, idSupplier);

            if (state.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
