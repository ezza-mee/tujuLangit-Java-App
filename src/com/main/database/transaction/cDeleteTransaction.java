package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.main.database.cConnectionDatabase;

public class cDeleteTransaction {
    public static boolean handleDeleteDataTransaction(int idTransaction) {
        boolean data = false;

        String deleteChildQuery = "DELETE FROM tbl_transaction_product WHERE idTransaction = ?";
        String deleteParentQuery = "DELETE FROM tbl_transaction WHERE idTransaction = ?";

        try (Connection conn = cConnectionDatabase.getConnection()) {
            conn.setAutoCommit(false); // Memulai transaksi

            try (PreparedStatement deleteChildStmt = conn.prepareStatement(deleteChildQuery);
                    PreparedStatement deleteParentStmt = conn.prepareStatement(deleteParentQuery)) {

                // Hapus data dari tabel anak
                deleteChildStmt.setInt(1, idTransaction);
                deleteChildStmt.executeUpdate();

                // Hapus data dari tabel induk
                deleteParentStmt.setInt(1, idTransaction);
                int rowsAffected = deleteParentStmt.executeUpdate();

                if (rowsAffected > 0) {
                    data = true;
                }

                conn.commit(); // Commit transaksi jika berhasil
            } catch (SQLException e) {
                conn.rollback(); // Rollback jika terjadi kesalahan
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

}
