package com.main.database.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.main.database.cConnectionDatabase;

public class cDetailAkunStaff {

    public static Object[] getDetailAkunStaff(int idStaff) {
        Object[] rowData = new Object[8];

        String query = "SELECT * FROM tbl_staff WHERE idStaff = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, idStaff); 
            ResultSet resultData = statement.executeQuery();

            if (resultData.next()) {
                rowData[0] = resultData.getInt("idStaff");
                rowData[1] = resultData.getString("nameStaff");
                rowData[2] = resultData.getString("phoneNumber");
                rowData[3] = resultData.getString("email");
                rowData[4] = resultData.getString("password");
                rowData[5] = resultData.getString("jobdesk");
                rowData[6] = resultData.getString("address");
                rowData[7] = resultData.getString("status");
            } 

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowData;
    }
}
