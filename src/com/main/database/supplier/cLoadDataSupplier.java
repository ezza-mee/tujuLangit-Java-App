package com.main.database.supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.main.database.cConnectionDatabase;

public class cLoadDataSupplier {
    public List<Supplier> loadSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();

        try (Connection conn = cConnectionDatabase.getConnection()) {
            if (conn != null) {
                String query = "SELECT ID, typeSupplier, countSupplier, descriptionSupplier FROM tbl_supplier";
                Statement state = conn.createStatement();
                ResultSet result = state.executeQuery(query);

                while (result.next()) {
                    int id = result.getInt("ID");
                    String typeSupplier = result.getString("typeSupplier");
                    int countSupplier = result.getInt("countSupplier");
                    String descriptionSupplier = result.getString("descritionSupplier");

                    suppliers.add(new Supplier(id, typeSupplier, countSupplier, descriptionSupplier));
                }
            } else {
                System.out.println("Koneksi Gagal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }

    public Supplier loadSupplierById(int supplierId) {
        Supplier supplier = null;
        try (Connection conn = cConnectionDatabase.getConnection()) {
            if (conn != null) {
                String query = "SELECT ID, typeSupplier, countSupplier, descriptionSupplier FROM tbl_supplier WHERE ID = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setInt(1, supplierId);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    supplier = new Supplier(
                            rs.getInt("ID"),
                            rs.getString("typeSupplier"),
                            rs.getInt("countSupplier"),
                            rs.getString("descriptionSupplier"));
                }
            } else {
                System.out.println("Koneksi gagal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplier;
    }

    public static class Supplier {
        private int id;
        private String type;
        private int count;
        private String description;

        public Supplier(int id, String type, int count, String description) {
            this.id = id;
            this.type = type;
            this.count = count;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getType() {
            return type;
        }

        public int getCount() {
            return count;
        }

        public String getDescription() {
            return description;
        }
    }
}
