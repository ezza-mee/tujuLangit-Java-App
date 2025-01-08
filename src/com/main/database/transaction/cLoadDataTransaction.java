package com.main.database.transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.main.database.cConnectionDatabase;

public class cLoadDataTransaction {

    public List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        try (Connection conn = cConnectionDatabase.getConnection()) {
            if (conn != null) {
                String query = "SELECT t.idTransaction, t.numberSeats, t.nameCustomer, t.amountTransaction, "
                        + "t.priceTransaction, t.description, tp.nameProduct, tp.amountProduct, tp.priceProduct "
                        + "FROM tbl_transaction t "
                        + "JOIN tbl_transaction_product tp ON t.idTransaction = tp.idTransaction";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    int idTransaction = rs.getInt("idTransaction");
                    int numberSeats = rs.getInt("numberSeats");
                    String nameCustomer = rs.getString("nameCustomer");
                    int amountTransaction = rs.getInt("amountTransaction");
                    int priceTransaction = rs.getInt("priceTransaction");
                    String description = rs.getString("description");
                    String nameProduct = rs.getString("nameProduct");
                    int amountProduct = rs.getInt("amountProduct");
                    int priceProduct = rs.getInt("priceProduct");

                    transactions.add(new Transaction(idTransaction, numberSeats, nameCustomer, amountTransaction,
                            priceTransaction, description, nameProduct, amountProduct, priceProduct));
                }
            } else {
                System.out.println("Koneksi gagal");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactions;
    }

    public static class Transaction {
        private int idTransaction;
        private int numberSeats;
        private String nameCustomer;
        private int amountTransaction;
        private int priceTransaction;
        private String description;
        private String nameProduct;
        private int amountProduct;
        private int priceProduct;

        public Transaction(int idTransaction, int numberSeats, String nameCustomer, int amountTransaction,
                int priceTransaction, String description, String nameProduct, int amountProduct, int priceProduct) {
            this.idTransaction = idTransaction;
            this.numberSeats = numberSeats;
            this.nameCustomer = nameCustomer;
            this.amountTransaction = amountTransaction;
            this.priceTransaction = priceTransaction;
            this.description = description;
            this.nameProduct = nameProduct;
            this.amountProduct = amountProduct;
            this.priceProduct = priceProduct;
        }

        // Getters
        public int getIdTransaction() {
            return idTransaction;
        }

        public int getNumberSeats() {
            return numberSeats;
        }

        public String getNameCustomer() {
            return nameCustomer;
        }

        public int getAmountTransaction() {
            return amountTransaction;
        }

        public int getPriceTransaction() {
            return priceTransaction;
        }

        public String getDescription() {
            return description;
        }

        public String getNameProduct() {
            return nameProduct;
        }

        public int getAmountProduct() {
            return amountProduct;
        }

        public int getPriceProduct() {
            return priceProduct;
        }
    }
}
