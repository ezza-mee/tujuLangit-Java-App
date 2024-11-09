package com.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cLoadDataProduct {

    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection conn = cKoneksiDatabase.getConnection()) {
            if (conn != null) {
                String query = "SELECT nameProduct, imageProduct FROM tbl_product"; // Query untuk ambil data produk
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    String productName = rs.getString("nameProduct");
                    byte[] imageBytes = rs.getBytes("imageProduct"); // Mengambil gambar sebagai byte array
                    products.add(new Product(productName, imageBytes)); // Menambahkan produk ke list
                }

            } else {
                System.out.println("Koneksi gagal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public class Product {
        private String name;
        private byte[] imageBytes; 

        public Product(String name, byte[] imageBytes) {
            this.name = name;
            this.imageBytes = imageBytes;
        }

        public String getName() {
            return name;
        }

        public byte[] getImageBytes() {
            return imageBytes;
        }
    }

}
