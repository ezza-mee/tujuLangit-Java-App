package com.main.database.supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.main.database.cConnectionDatabase;

public class cDataSupplier {
    public static DefaultTableModel getAllSupplier() {

        String[] dataHeader = { "Id", "Company", "Type", "Amount", "Price", "Description"};

        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);
        String query = "SELECT * FROM tbl_supplier";
        try(Connection conn = cConnectionDatabase.getConnection();
        PreparedStatement state = conn.prepareStatement(query)) {
            

            ResultSet resultData = state.executeQuery(query);

            while (resultData.next()) {
                Object[] rowData = { "SD" + resultData.getInt("idSupplier"),
                        resultData.getString("nameCompany"),
                        resultData.getString("typeSupplier"),
                        resultData.getInt("supplierAmount"),
                        resultData.getInt("priceTotal"),
                        resultData.getString("descriptionProduct")};
                tm.addRow(rowData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tm;
    }
}
