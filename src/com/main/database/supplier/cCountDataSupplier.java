package com.main.database.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.main.database.cConnectionDatabase;

public class cCountDataSupplier {
    public static int getTotalSupplierCount() {
    String query = "SELECT COUNT(*) FROM tbl_supplier";
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
