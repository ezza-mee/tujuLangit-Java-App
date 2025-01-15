package com.main.database.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cInsertDataProduct {

    public static boolean dataProduct(String nameProduct, String imageProduct, int countProduct, int priceProduct,
            String descriptionProduct, String typeProduct, String statusProduct) {
        boolean data = false;

        String query = "INSERT INTO tbl_product (dateTime, nameProduct, imageProduct, countProduct, priceProduct, descriptionProduct, typeProduct, statusProduct) VALUES (NOW(), ?, ?, ?, ?, ?, ?, ?)";

        File imageFile = new File(imageProduct);
        if (!imageFile.exists()) {
            System.out.println("Image file does not exist: " + imageProduct);
            return false;
        }

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);
                FileInputStream fis = new FileInputStream(imageFile)) {

            state.setString(1, nameProduct);
            state.setBinaryStream(2, fis, (int) imageFile.length());
            state.setInt(3, countProduct);
            state.setInt(4, priceProduct);
            state.setString(5, descriptionProduct);
            state.setString(6, typeProduct);
            state.setString(7, statusProduct);

            if (state.executeUpdate() > 0) {
                data = true;
                System.out.println("Product with image inserted successfully.");
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
