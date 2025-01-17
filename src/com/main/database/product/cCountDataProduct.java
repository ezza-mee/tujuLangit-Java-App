package com.main.database.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.main.database.cConnectionDatabase;

public class cCountDataProduct {
    public static int getTotalProductCount() {
        String query = "SELECT COUNT(*) FROM vwalldataproduct";
        int count = 0;

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);
                ResultSet resultData = state.executeQuery()) {

            if (resultData.next()) {
                count = resultData.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

}
