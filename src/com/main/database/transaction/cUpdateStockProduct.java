package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cUpdateStockProduct {
    public static boolean updateProductStock(int idProduct, int amountSold) {
        String queryUpdateStock = "UPDATE tbl_product SET countProduct = countProduct - ? WHERE idProduct = ?";
        String queryUpdateStatus = "UPDATE tbl_product SET statusProduct = 'Sold' WHERE idProduct = ?";

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement stateUpdateStock = conn.prepareStatement(queryUpdateStock);
                PreparedStatement stateUpdateStatus = conn.prepareStatement(queryUpdateStatus)) {

            System.out.println("Memulai update stok...");
            System.out.println("idProduct: " + idProduct);
            System.out.println("amountSold: " + amountSold);

            // Periksa stok sebelum pengurangan
            String queryCheckStock = "SELECT countProduct FROM tbl_product WHERE idProduct = ?";
            try (PreparedStatement stateCheckStock = conn.prepareStatement(queryCheckStock)) {
                stateCheckStock.setInt(1, idProduct);
                ResultSet rs = stateCheckStock.executeQuery();
                if (rs.next()) {
                    int currentStock = rs.getInt("countProduct");
                    System.out.println("Stok saat ini: " + currentStock);
                    if (currentStock < amountSold) {
                        System.out.println("Error: Stok tidak mencukupi.");
                        return false;
                    }
                } else {
                    System.out.println("Error: Produk tidak ditemukan.");
                    return false;
                }
            }

            // Update stock
            stateUpdateStock.setInt(1, amountSold);
            stateUpdateStock.setInt(2, idProduct);
            int affectedRows = stateUpdateStock.executeUpdate();
            System.out.println("Affected Rows (Update Stock): " + affectedRows);

            if (affectedRows > 0) {
                // Periksa jika stok menjadi nol
                try (PreparedStatement stateCheckStockAfter = conn.prepareStatement(queryCheckStock)) {
                    stateCheckStockAfter.setInt(1, idProduct);
                    ResultSet rs = stateCheckStockAfter.executeQuery();
                    if (rs.next()) {
                        int countProduct = rs.getInt("countProduct");
                        System.out.println("Stok setelah update: " + countProduct);

                        if (countProduct == 0) {
                            stateUpdateStatus.setInt(1, idProduct);
                            stateUpdateStatus.executeUpdate();
                            System.out.println("Status produk diubah menjadi 'Sold'.");
                        }
                    }
                }
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
