package com.partials;

import javax.swing.JLabel;

public class cSidebarMenu extends JLabel {

    public java.awt.event.MouseAdapter sidebarAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            setBackground(cColor.WHITE);
            setForeground(cColor.GREEN);
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setBackground(cColor.WHITE);
            setForeground(cColor.GREEN);
        }
    };

    public java.awt.event.MouseAdapter sidebarNonAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            setBackground(cColor.WHITE);
            setForeground(cColor.GREEN);
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setBackground(cColor.GREEN);
            setForeground(cColor.WHITE);
        }
    };

    public cSidebarMenu(String text, int y) {
        super();
        setText("" + text);
        setBounds(0, y, 240, 50);
        setOpaque(true);
        setFont(cFonts.SIDEBAR_FONT);
        setForeground(cColor.WHITE);
        setBackground(cColor.GREEN);
        setVerticalAlignment(JLabel.CENTER);
        setHorizontalAlignment(JLabel.CENTER);
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });
        setSidebarNonAktif();
    }

    public void setSidebarAktif() {
        try {
            removeMouseListener(sidebarNonAktif);
        } catch (Exception e) {
            // TODO: handle exception
        }
        addMouseListener(sidebarAktif);
    }

    public void setSidebarNonAktif() {
        try {
            removeMouseListener(sidebarAktif);
        } catch (Exception e) {
            // TODO: handle exception
        }
        addMouseListener(sidebarNonAktif);
    }
}
