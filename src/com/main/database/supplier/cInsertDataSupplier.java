package com.main.database.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cInsertDataSupplier {
    public static boolean dataSupplier(String typeSupplier, int supplierAmount, int priceTotal, String descriptionProduct) {
        boolean data = false;

        String query = "INSERT INTO tbl_supplier (typeSupplier, supplierAmount, priceTotal, descriptionProduct) VALUES (?, ?, ?, ?)";

        try (Connection conn = cConnectionDatabase.getConnection();
                    PreparedStatement state = conn.prepareStatement(query);) { 
  
                state.setString(1, typeSupplier);
                state.setInt(2, supplierAmount);
                state.setInt(3, priceTotal);
                state.setString(4, descriptionProduct);

                if (state.executeUpdate() > 0) {
                    data = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return data;
        }

}

    