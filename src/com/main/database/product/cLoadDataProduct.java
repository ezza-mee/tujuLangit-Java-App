package com.main.database.product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.main.database.cConnectionDatabase;

public class cLoadDataProduct {

    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection conn = cConnectionDatabase.getConnection()) {
            if (conn != null) {
                String query = "SELECT idProduct, nameProduct, imageProduct, countProduct, priceProduct, deskripsiProduct FROM tbl_product";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    int idProduct = rs.getInt("idProduct");
                    String productName = rs.getString("nameProduct");
                    byte[] imageBytes = rs.getBytes("imageProduct");
                    int productCount = rs.getInt("countProduct");
                    int productPrice = rs.getInt("priceProduct");
                    String productDescription = rs.getString("deskripsiProduct");

                    products.add(new Product(idProduct, productName, imageBytes, productCount, productPrice,
                            productDescription));
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
        private int id;
        private String name;
        private int count;
        private int price;
        private String description;
        private byte[] imageBytes;

        public Product(int id, String name, byte[] imageBytes, int count, int price, String description) {
            this.id = id;
            this.name = name;
            this.imageBytes = imageBytes;
            this.count = count;
            this.price = price;
            this.description = description;
        }

        public int getId() {
            return id;
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

        public String getDescription() {
            return description;
        }
    }
}
