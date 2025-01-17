package com.main.database.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.main.database.cConnectionDatabase;

public class cSearchDataSupplier {
    public static DefaultTableModel searchSupplier(String keyword) {

        String[] dataHeader = { "ID", "Stock", "Amount", "Price", "Description" };

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM tbl_supplier WHERE idSupplier LIKE ? OR typeSupplier LIKE ? OR supplierAmount LIKE ? OR priceTotal LIKE ? OR descriptionProduct LIKE ?";
        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            for (int i = 1; i <= 5; i++) {
                state.setString(i, "%" + keyword + "%");
            }

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                Object[] rowData = { "S00" + resultData.getInt("idSupplier"),
                        resultData.getString("typeSupplier"),
                        resultData.getInt("supplierAmount"),
                        "Rp. " + resultData.getInt("priceTotal"),
                        resultData.getString("descriptionProduct") };
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }

}
