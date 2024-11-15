package com.main.database.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cKoneksiDatabase;

public class cInsertDataSupplier {
    public static boolean dataSupplier(String nameCompany, String typeSupplier, int supplierAmount, int priceTotal, String descriptionProduct) {
        boolean data = false;

        String query = "INSERT INTO tbl_supplier (nameCompany, typeSupplier, supplierAmount, priceTotal, descriptionProduct) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = cKoneksiDatabase.getConnection();
                    PreparedStatement state = conn.prepareStatement(query);) { 

                state.setString(1, nameCompany);  
                state.setString(2, typeSupplier);
                state.setInt(3, supplierAmount);
                state.setInt(4, priceTotal);
                state.setString(5, descriptionProduct);

                if (state.executeUpdate() > 0) {
                    data = true;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return data;
        }

}

    