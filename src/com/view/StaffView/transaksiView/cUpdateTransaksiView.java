package com.view.StaffView.transaksiView;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.util.ArrayList;
import com.main.database.transaction.cDataSeatsTransaction;
import com.main.database.transaction.cDeleteProductTransaction;
import com.main.database.transaction.cInsertProductTransaction;
import com.main.database.transaction.cUpdateDataTransaction;
import com.main.database.transaction.cUpdateProductTransaction;
import com.main.database.transaction.cUpdateStockProduct;
import com.main.resources.templates.cPanelContentApp;
import com.model.cContentStaffView;
import com.partials.*;
import com.view.StaffView.cDashboardStaffView;

public class cUpdateTransaksiView extends cPanelContentApp {

    private cContentStaffView parentPanel;
    private cBigFont labelHeaderTransaksi = new cBigFont("Transaksi", 40, 5);
    private cBigFont labelUpdateTransaksi = new cBigFont("Update Data Transaksi", 40, 20);
    private cBigFont labelListOrderTransaksi = new cBigFont("List Order", 40, 20);
    private cLabelInfo labelCopyright = new cLabelInfo("CopyRight 2024. TujuLangit ForestPark", 0, 650, 1126, 40);

    private cPanelRounded panelUpdateTransaksi = new cPanelRounded(40, 80, 600, 560, 10, 10);
    private cPanelRounded panelListOrderTransaksi = new cPanelRounded(660, 80, 430, 560, 10, 10);
    private cPanelRounded panelListCardOrder = new cPanelRounded(0, 80, 430, 400, 0, 0);

    private cButtonRounded btnAddTransaksi = new cButtonRounded("Add Product", 40, 140, 220, 40, 10);
    private cButtonRounded btnCheckout = new cButtonRounded("Checkout", 450, 490, 110, 40, 10);
    private cButtonRounded btnBackToHome = new cButtonRounded("Back", 40, 490, 110, 40, 10);

    private cLabelInfo labelAddProduct = new cLabelInfo("Product", 40, 110, 300, 30);
    private cLabelInfo labelAddSeats = new cLabelInfo("Seats", 330, 110, 300, 30);
    private cLabelInfo labelAmountProduct = new cLabelInfo("Nama Pembeli", 40, 210, 300, 30);
    private cLabelInfo labelDeskripsiProduct = new cLabelInfo("Deskripsi", 40, 290, 300, 30);

    private cComboBox boxSeatsTransaksi;

    private cTextField txtNameTransaksi = new cTextField(40, 240, 520);
    private cTextArea txtDeskripsiTransaksi = new cTextArea(40, 320, 520, 100, true);

    private ArrayList<CartItem> cartItems;

    private cLabelInfo labelNumberSeats = new cLabelInfo("Number Seats : ", 230, 45, 300, 30);
    private cLabelInfo valueNumberSeats = new cLabelInfo("", 370, 45, 300, 30);

    private cLabelInfo labelTotalTransaction = new cLabelInfo("Total Transaction : ", 40, 510, 300, 30);
    private cLabelInfo valueTotalTransaction = new cLabelInfo("", 280, 510, 300, 30);

    private int idTransaction;
    private int idProductTransaction;
    private int idUnitProduct;

    public cUpdateTransaksiView(cContentStaffView parentPanel) {
        super();
        this.parentPanel = parentPanel;
        cartItems = new ArrayList<CartItem>();
        initsUpdateTransaksiView();
    }

    public void setDataTransaction(int idTransaction, int idProduct, int idProductTransaction, String numberSeats,
            String nameCustomer,
            int amountTransaction, int priceTransaction, String description,
            String nameProduct, int amountProduct, int priceProduct) {
        this.idTransaction = idTransaction;
        this.idProductTransaction = idProductTransaction;
        this.idUnitProduct = idProduct;
        txtNameTransaksi.setText(nameCustomer);
        txtDeskripsiTransaksi.setText(description);
        valueNumberSeats.setText(numberSeats);
        valueTotalTransaction.setText("Rp. " + priceTransaction);

        addOrUpdateProductToCart(idTransaction, nameProduct, priceProduct, amountProduct);
    }

    public void addProductToCart(int idProduct, String nameProduct, int price) {
        boolean productExists = false;
        for (CartItem item : cartItems) {
            if (item.getIdProduct() == idProduct) {
                item.setCount(item.getCount() + 1);
                item.setPrice(item.getCount() * item.getUnitPrice());
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            cartItems.add(new CartItem(idProduct, price, nameProduct, 1, price));
        }

        updateCartDisplay();
    }

    public void addOrUpdateProductToCart(int idProductTransaction, String nameProduct, int price, int quantity) {
        boolean productExists = false;

        for (CartItem item : cartItems) {
            if (item.getIdProductTransaction() == idProductTransaction && item.getNameProduct().equals(nameProduct)) {
                item.setCount(item.getCount() + quantity);
                item.setPrice(item.getCount() * item.getUnitPrice());
                System.out.println(item.getIdProduct());
                productExists = true;
                break;
            }
        }

        if (!productExists) {
            cartItems.add(new CartItem(idProductTransaction, quantity, nameProduct, quantity, price));
        }

        updateCartDisplay();
    }

    private void updateCartDisplay() {
        panelListCardOrder.removeAll();
        JPanel cardContainer = new JPanel();
        cardContainer.setLayout(new BoxLayout(cardContainer, BoxLayout.Y_AXIS));
        cardContainer.setBackground(cColor.WHITE);

        int totalTransaction = 0;

        for (CartItem item : cartItems) {
            JPanel cardPanel = new JPanel();
            cardPanel.setLayout(null);
            cardPanel.setPreferredSize(new Dimension(400, 100));
            cardPanel.setBorder(BorderFactory.createLineBorder(cColor.GREY, 1));
            cardPanel.setBackground(cColor.WHITE);

            JLabel productLabel = new JLabel(item.getNameProduct());
            productLabel.setFont(cFonts.FONT_SIZE_15);
            productLabel.setBounds(20, 10, 200, 30);

            JLabel priceLabel = new JLabel("Rp. " + item.getPrice());
            priceLabel.setFont(cFonts.FONT_SIZE_15);
            priceLabel.setBounds(240, 10, 100, 30);

            JLabel countLabel = new JLabel(String.valueOf(item.getCount()));
            countLabel.setFont(cFonts.FONT_SIZE_20);
            countLabel.setBounds(190, 50, 40, 30);
            countLabel.setHorizontalAlignment(SwingConstants.CENTER);

            cImage iconMinus = new cImage("src/com/main/resources/images/minus.png", 0, 0, 20, 20);
            cButtonRounded minusButton = new cButtonRounded("", 140, 50, 40, 30, 10);
            minusButton.setIcon(iconMinus);
            minusButton.addActionListener(e -> {
                if (item.getCount() > 1) {
                    item.setCount(item.getCount() - 1);
                    item.setPrice(item.getCount() * item.getUnitPrice());
                    updateCartDisplay();
                }
            });

            cImage iconTambah = new cImage("src/com/main/resources/images/tambah.png", 0, 0, 20, 20);
            cButtonRounded addButton = new cButtonRounded("", 240, 50, 40, 30, 10);
            addButton.setIcon(iconTambah);
            addButton.addActionListener(e -> {
                item.setCount(item.getCount() + 1);
                item.setPrice(item.getCount() * item.getUnitPrice());
                updateCartDisplay();
            });

            cImage iconDelete = new cImage("src/com/main/resources/images/delete.png", 0, 0, 20, 20);
            cButtonRounded deleteButton = new cButtonRounded("", 300, 50, 60, 30, 10);
            deleteButton.setIcon(iconDelete);
            deleteButton.addActionListener(e -> {
                int idDeleteCart = item.getIdProduct(); // ID produk yang ada di cart

                // Menghapus produk dari database berdasarkan idProductTransaction
                boolean deleteSuccess = cDeleteProductTransaction
                        .handleDeleteDataProductTransaction(idProductTransaction);

                System.out.println("ID Produk: " + idDeleteCart);

                // Cek apakah penghapusan produk dari database berhasil
                if (deleteSuccess) {
                    // Hapus item dari cartItems jika penghapusan berhasil
                    cartItems.remove(item);
                    updateCartDisplay();
                } else {
                    // Jika produk tidak terhapus dari database, cek apakah produk ada di cart
                    if (cartItems.contains(item) && idDeleteCart == item.getIdProduct()) {
                        cartItems.remove(item);
                        updateCartDisplay();
                        System.out.println("Produk berhasil dihapus dari cart.");
                    } else {
                        System.out.println("Produk tidak ditemukan di cart atau ID tidak cocok.");
                    }
                }
            });

            cardPanel.add(productLabel);
            cardPanel.add(priceLabel);
            cardPanel.add(countLabel);
            cardPanel.add(minusButton);
            cardPanel.add(addButton);
            cardPanel.add(deleteButton);

            cardContainer.add(cardPanel);
            cardContainer.add(Box.createRigidArea(new Dimension(0, 10)));

            totalTransaction += item.getPrice();
        }

        valueTotalTransaction.setText("Rp. " + totalTransaction);

        cScrollPane scrollPane = new cScrollPane(cardContainer, 0, 0, 430, 400);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);
        scrollPane.setBorder(null);

        panelListCardOrder.add(scrollPane);
        panelListCardOrder.revalidate();
        panelListCardOrder.repaint();
    }

    class CartItem {
        private int idProduct;
        private int idProductTransaction;
        private String nameProduct;
        private int count;
        private int price;
        private int unitPrice;

        public CartItem(int idProduct, int idProductTransaction, String nameProduct, int count, int unitPrice) {
            this.idProduct = idProduct;
            this.idProductTransaction = idProductTransaction;
            this.nameProduct = nameProduct;
            this.count = count;
            this.unitPrice = unitPrice;
            this.price = count * unitPrice;
        }

        public int getIdProduct() {
            return idProduct;
        }

        public int getIdProductTransaction() {
            return idProductTransaction;
        }

        public String getNameProduct() {
            return nameProduct;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
            this.price = this.unitPrice * count;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getUnitPrice() {
            return unitPrice;
        }
    }

    private void initializeTransaction() {
        ArrayList<String> numberSeats = cDataSeatsTransaction.getNumberSeats();
        numberSeats.add(0, "-");
        boxSeatsTransaksi = new cComboBox(numberSeats.toArray(new String[0]), 330, 140, 220, 40);
    }

    public void initsUpdateTransaksiView() {
        setVisible(true);
        setVisible(true);

        initializeTransaction();

        boxSeatsTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String selectedSeat = (String) boxSeatsTransaksi.getSelectedItem();

                if (selectedSeat != null) {
                    valueNumberSeats.setText(selectedSeat);
                }
            }
        });

        btnAddTransaksi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                parentPanel.showUpdateProductTransaksiView();
            }
        });

        btnBackToHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                parentPanel.showDataTransaksiView();
            }
        });

        btnCheckout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                handleUpdateTransaction(idTransaction);
            }
        });

        labelCopyright.setHorizontalAlignment(JLabel.CENTER);
        labelCopyright.setFont(cFonts.FONT_SIZE_10);

        labelUpdateTransaksi.setFont(cFonts.FONT_SIZE_20);
        labelListOrderTransaksi.setFont(cFonts.FONT_SIZE_20);

        btnAddTransaksi.setFont(cFonts.FONT_SIZE_13);
        btnCheckout.setFont(cFonts.FONT_SIZE_13);
        btnBackToHome.setFont(cFonts.FONT_SIZE_13);

        panelUpdateTransaksi.add(labelUpdateTransaksi);
        panelUpdateTransaksi.add(btnCheckout);
        panelUpdateTransaksi.add(btnBackToHome);
        panelUpdateTransaksi.add(btnAddTransaksi);

        panelUpdateTransaksi.add(labelAddProduct);
        panelUpdateTransaksi.add(labelAddSeats);
        panelUpdateTransaksi.add(labelAmountProduct);
        panelUpdateTransaksi.add(labelDeskripsiProduct);

        panelUpdateTransaksi.add(boxSeatsTransaksi);

        panelUpdateTransaksi.add(txtNameTransaksi);
        panelUpdateTransaksi.add(txtDeskripsiTransaksi);

        panelListOrderTransaksi.add(labelListOrderTransaksi);
        panelListOrderTransaksi.add(panelListCardOrder);
        panelListOrderTransaksi.add(labelNumberSeats);
        panelListOrderTransaksi.add(valueNumberSeats);
        panelListOrderTransaksi.add(labelTotalTransaction);
        panelListOrderTransaksi.add(valueTotalTransaction);

        bgPanel.add(panelUpdateTransaksi);
        bgPanel.add(panelListOrderTransaksi);
        bgPanel.add(labelHeaderTransaksi);
        bgPanel.add(labelCopyright);
    }

    private void handleUpdateTransaction(int idTransaction) {
        try {
            String nameCustomer = txtNameTransaksi.getText().trim();
            String description = txtDeskripsiTransaksi.getText().trim();
            String selectedSeat = boxSeatsTransaksi.getSelectedItem().toString();

            if (nameCustomer.isEmpty() || description.isEmpty() || selectedSeat.equals("-")) {
                JOptionPane.showMessageDialog(null,
                        "Semua field harus diisi dengan benar!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            cDashboardStaffView dashboardStaffView = new cDashboardStaffView();
            String nameStaff = dashboardStaffView.getStaffName();
            int idStaff = dashboardStaffView.getIdStaff();

            dashboardStaffView.setVisible(false);

            // Update transaction data
            boolean isTransactionUpdated = cUpdateDataTransaction.handleUpdateTransaction(
                    idTransaction,
                    idStaff,
                    nameStaff,
                    Integer.parseInt(selectedSeat),
                    nameCustomer,
                    cartItems.size(),
                    calculateTotalPrice(),
                    description);

            if (!isTransactionUpdated) {
                JOptionPane.showMessageDialog(null,
                        "Gagal menyimpan transaksi utama!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Update or insert products for the transaction
            for (CartItem item : cartItems) {
                // Cek apakah produk sudah ada dalam transaksi
                boolean isProductExist = cUpdateProductTransaction.isProductExistInTransaction(idProductTransaction,
                        idUnitProduct);

                boolean isProductUpdated = false;
                if (isProductExist) {
                    // Jika produk sudah ada, lakukan update
                    isProductUpdated = cUpdateProductTransaction.handleUpdateProductTransaction(
                            idProductTransaction, // ID transaksi produk
                            idUnitProduct, // ID produk yang sudah ada
                            idTransaction, // ID transaksi
                            item.getNameProduct(),
                            item.getCount(),
                            item.getUnitPrice());
                }

                boolean isProductInserted = false;
                if (isProductExist) {
                    // Jika produk tidak ada, lakukan insert
                    isProductInserted = cInsertProductTransaction.insertProductTransaction(
                            item.getIdProduct(), // ID produk baru
                            idTransaction, // ID transaksi
                            item.getNameProduct(),
                            item.getCount(),
                            item.getUnitPrice());
                }

                if (!isProductInserted && !isProductUpdated) {
                    JOptionPane.showMessageDialog(null,
                            "Gagal menyimpan produk baru: " + item.getNameProduct(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Update stock if product is updated or inserted
                int amountSold = item.getCount();
                boolean isStockUpdated = cUpdateStockProduct.updateProductStock(idUnitProduct,amountSold);
                boolean isStockInsert = cUpdateStockProduct.updateProductStock(item.getIdProduct(), amountSold);

                if (!isStockUpdated && !isStockInsert) {
                    JOptionPane.showMessageDialog(null,
                            "Gagal mengupdate stok produk: " + item.getNameProduct(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    "Transaksi berhasil disimpan!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            // Reset form and cart
            txtNameTransaksi.setText("");
            txtDeskripsiTransaksi.setText("");
            boxSeatsTransaksi.setSelectedIndex(0);
            cartItems.clear();
            updateCartDisplay();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Format data tidak valid, periksa kembali input Anda!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Terjadi kesalahan: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private int calculateTotalPrice() {
        int total = 0;
        for (CartItem item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }

}
