package com.main.database.product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.main.database.cKoneksiDatabase;

public class cLoadDataProduct {

    public List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection conn = cKoneksiDatabase.getConnection()) {
            if (conn != null) {
                String query = "SELECT idProduct, nameProduct, imageProduct, countProduct, priceProduct, descriptionProduct, typeProduct, statusProduct FROM tbl_product";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    int idProduct = rs.getInt("idProduct");
                    String productName = rs.getString("nameProduct");
                    byte[] imageBytes = rs.getBytes("imageProduct");
                    int productCount = rs.getInt("countProduct");
                    int productPrice = rs.getInt("priceProduct");
                    String productDescription = rs.getString("descriptionProduct");
                    String productType = rs.getString("typeProduct");
                    String productStatus = rs.getString("statusProduct");

                    products.add(new Product(idProduct, productName, imageBytes, productCount, productPrice,
                            productDescription, productType, productStatus));
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
        private byte[] imageBytes;
        private int count;
        private int price;
        private String description;
        private String type;
        private String status;

        public Product(int id, String name, byte[] imageBytes, int count, int price, String description, String type,
                String status) {
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

        public String getType() {
            return type;
        }

        public String getStatus() {
            return status;
        }
    }
}
