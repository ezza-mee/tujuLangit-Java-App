package com.main.database.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cDeleteDataSupplier {
    
    public static boolean handleDeleteDataSupplier(int idSupplier) {
        boolean data = false;

        String query = "DELETE FROM tbl_supplier WHERE idSupplier = " + idSupplier;

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
