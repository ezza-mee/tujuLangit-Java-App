package com.database.product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.database.cKoneksiDatabase;

public class cLoadDataProduct {

    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection conn = cKoneksiDatabase.getConnection()) {
            if (conn != null) {
                String query = "SELECT nameProduct, imageProduct, countProduct, priceProduct, statusProduct FROM tbl_product";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    String productName = rs.getString("nameProduct");
                    byte[] imageBytes = rs.getBytes("imageProduct");
                    int productCount = rs.getInt("countProduct");
                    int productPrice = rs.getInt("priceProduct");
                    String productStatus = rs.getString("statusProduct");

                    products.add(new Product(productName, imageBytes, productCount, productPrice, productStatus));
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
        private int count;
        private int price;
        private String status;
        private byte[] imageBytes;

        public Product(String name, byte[] imageBytes, int count, int price, String status) {
            this.name = name;
            this.imageBytes = imageBytes;
            this.count = count;
            this.price = price;
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public byte[] getImageBytes() {
            return imageBytes;
        }

        public int getCount() {
            return count;
        }

        public int getPrice() {
            return price;
        }

        public String getStatus() {
            return status;
        }
    }
}
