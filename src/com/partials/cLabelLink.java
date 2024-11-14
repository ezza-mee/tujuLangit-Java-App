package com.partials;

import javax.swing.*;

public class cLabelLink extends JLabel {
    public cLabelLink(String text, int y) {
        super();
        setText(text);
        setBounds(0, y, 500, 30);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.FONT_SIZE_14);
        setForeground(cColor.BLACK);

        addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            public void mouseExited(java.awt.event.MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });
    }
}
