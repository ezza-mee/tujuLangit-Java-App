package com.main.database.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cUpdateDataProduct {

    public static boolean handleUpdate(int idProduct, String nameProduct, String imageProduct, int countProduct,
            int priceProduct, String descriptionProduct, String typeProduct, String statusProduct) {
        boolean data = false;

        String query = "UPDATE tbl_product SET nameProduct = ?, imageProduct = ?, countProduct = ?, priceProduct = ?, descriptionProduct = ?, typeProduct = ?, statusProduct = ? WHERE idProduct = ?";

        File imageFile = new File(imageProduct);
        if (!imageFile.exists()) {
            System.out.println("Image file does not exist: " + imageProduct);
            return false;
        }

        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query);
                FileInputStream fis = new FileInputStream(imageFile)) {

            state.setInt(1, idProduct);
            state.setString(2, nameProduct);
            state.setBinaryStream(3, fis, (int) imageFile.length());
            state.setInt(4, countProduct);
            state.setInt(5, priceProduct);
            state.setString(6, descriptionProduct);
            state.setString(7, typeProduct);
            state.setString(8, statusProduct);

            int rowsAffected = state.executeUpdate();

            if (rowsAffected > 0) {
                data = true;
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
