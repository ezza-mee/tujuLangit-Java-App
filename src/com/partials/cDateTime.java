package com.partials;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class cDateTime extends JLabel {
    public cDateTime(int x, int y, int width) {
        super();
        setBounds(x, y, width, 50);
        setHorizontalAlignment(JLabel.CENTER);
        setFont(cFonts.FONT_SIZE_14);
        setOpaque(true);
        setBackground(cColor.GREEN);
        setForeground(cColor.WHITE);
        updateTime(); // Memanggil metode untuk memperbarui waktu saat inisialisasi
        startClock(); // Memulai pembaruan waktu secara berkala
    }

    // Metode untuk memperbarui waktu
    private void updateTime() {
        LocalDateTime now = LocalDateTime.now(); // Mendapatkan waktu saat ini
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy | HH:mm:ss"); // Format waktu
        String dateTime = formatter.format(now); // Mengonversi waktu ke string
        setText(dateTime); // Menetapkan teks label ke waktu yang diperbarui
    }

    // Metode untuk memulai timer yang memperbarui waktu setiap detik
    private void startClock() {
        Timer timer = new Timer(1000, e -> updateTime()); // Timer dengan delay 1000 ms (1 detik)
        timer.start(); // Memulai timer
    }
}
