package com.partials;

import javax.swing.*;

public class cPasswordField extends JPasswordField {
    public cPasswordField(int x, int y, int width) {
        super();
        setBounds(x, y, width, 30);
        setFont(cFonts.FONT_SIZE_15);
        setForeground(cColor.BLACK);
        setBorder(new javax.swing.border.LineBorder(cColor.GREEN, 1));
    }
}
