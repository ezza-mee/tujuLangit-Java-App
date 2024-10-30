package com.partials;

import javax.swing.*;
import com.partials.*;

public class cSidebarMenu extends JPanel {

    private JLabel label;
    private cImage iconLabel;
    private cImage defaultIcon;
    private cImage hoverIcon;

    public java.awt.event.MouseAdapter sidebarAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            setBackground(cColor.WHITE);
            label.setForeground(cColor.GREEN);
            iconLabel.setIcon(defaultIcon.getIcon());
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setBackground(cColor.WHITE);
            label.setForeground(cColor.GREEN);
            iconLabel.setIcon(hoverIcon.getIcon());
        }
    };

    public java.awt.event.MouseAdapter sidebarInAktif = new java.awt.event.MouseAdapter() {
        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {
            setBackground(cColor.WHITE);
            label.setForeground(cColor.GREEN);
            iconLabel.setIcon(hoverIcon.getIcon());
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setBackground(cColor.GREEN);
            label.setForeground(cColor.WHITE);
            iconLabel.setIcon(defaultIcon.getIcon());
        }
    };

    public cSidebarMenu(cImage defaultIcon, cImage hoverIcon, String text, int y) {
        super();
        this.defaultIcon = defaultIcon;
        this.hoverIcon = hoverIcon;

        setLayout(null);
        setBounds(0, y, 240, 50);
        setBackground(cColor.GREEN);

        iconLabel = new cImage(defaultIcon.getIcon(), 50, 5, 40, 40);
        iconLabel.setBounds(50, 5, 40, 40);
        add(iconLabel);

        label = new JLabel(text);
        label.setFont(cFonts.SIDEBAR_FONT);
        label.setForeground(cColor.WHITE);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(110, 0, 240, 50);
        add(label);
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });
        setSidebarInAktif();
        revalidate();
        repaint();
    }

    public void setSidebarAktif() {
        try {
            removeMouseListener(sidebarInAktif);
        } catch (Exception e) {
            // TODO: handle exception
        }
        addMouseListener(sidebarAktif);
    }

    public void setSidebarInAktif() {
        try {
            removeMouseListener(sidebarAktif);
        } catch (Exception e) {
            // TODO: handle exception
        }
        addMouseListener(sidebarInAktif);
    }

}
