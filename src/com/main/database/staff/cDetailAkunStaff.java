package com.main.database.staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.main.database.cConnectionDatabase;

public class cDetailAkunStaff {

    public static Object[] getDetailAkunStaff(int idStaff) {
        Object[] rowData = new Object[9];

        String query = "SELECT * FROM vwalldatastaff WHERE idStaff = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, idStaff);
            ResultSet resultData = statement.executeQuery();

            if (resultData.next()) {
                rowData[0] = resultData.getInt("idStaff");
                rowData[1] = resultData.getString("dateTime");
                rowData[2] = resultData.getString("nameStaff");
                rowData[3] = resultData.getString("phoneNumber");
                rowData[4] = resultData.getString("email");
                rowData[5] = resultData.getString("password");
                rowData[6] = resultData.getString("jobdesk");
                rowData[7] = resultData.getString("address");
                rowData[8] = resultData.getString("status");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowData;
    }
}
