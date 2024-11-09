package com.partials;

import javax.swing.*;

import com.main.controller.Controller;

public class cLogout extends JLabel {
    public cLogout(int x) {
        setBounds(x, 0, 82, 70);
        setText("Logout");
        setFont(cFonts.LINK_EXIT_FONT);
        setForeground(cColor.GREEN);
        addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }

            public void mouseClicked(java.awt.event.MouseEvent e) {
                Object[] options = { "IYA", "KEMBALI" };
                int konfirmasi = JOptionPane.showOptionDialog(null, "Yakin ingin keluar aplikasi", "Konfirmasi Keluar",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (konfirmasi == 0) {
                    Controller.hiddenDashboardAdmin();
                    // Controller.showLoginAdmin();
                }
            }
        });
    }
}