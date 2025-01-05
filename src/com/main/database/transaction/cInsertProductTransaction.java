package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cInsertProductTransaction {
    public static boolean insertProductTransaction(int idTransaction, String nameProduct) {
        boolean data = false;

        String query = "INSERT INTO tbl_transaction_product (idTransaction, nameProduct) VALUES (?, ?)";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            state.setInt(1, idTransaction); 
            state.setString(2, nameProduct); 

            if (state.executeUpdate() > 0) {
                data = true; 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

}
