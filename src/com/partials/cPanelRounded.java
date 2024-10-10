package com.partials;

import javax.swing.*;
import java.awt.*;

public class cPanelRounded extends JPanel {

        // Variabel untuk radius pada sisi kiri dan kanan
        private int leftRadius;
        private int rightRadius;

        // Konstruktor untuk mengatur posisi, ukuran panel, dan radius pada sisi kiri
        // serta kanan
        public cPanelRounded(int x, int y, int width, int height, int leftRadius, int rightRadius) {
                super();
                this.leftRadius = leftRadius;
                this.rightRadius = rightRadius;
                setBounds(x, y, width, height);
                setBackground(cColor.WHITE);
                setOpaque(false);
                setLayout(null);
        }

        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());

                // Menggambar bagian tengah persegi panjang (tanpa sudut melengkung)
                g2.fillRect(leftRadius, 0, getWidth() - leftRadius - rightRadius, getHeight());

                // Menggambar bagian kiri dengan sudut melengkung
                g2.fillRoundRect(0, 0, leftRadius * 2, getHeight(), leftRadius * 2, leftRadius * 2);

                // Menggambar bagian kanan dengan sudut melengkung
                g2.fillRoundRect(getWidth() - rightRadius * 2, 0, rightRadius * 2, getHeight(), rightRadius * 2,
                                rightRadius * 2);
        }
}
