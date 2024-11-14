package com.partials;

import javax.swing.*;

public class cTextField extends JTextField {
    public cTextField(int x, int y, int width) {
        super();
        setBounds(x, y, width, 30);
        setFont(cFonts.FONT_SIZE_14);
        setForeground(cColor.BLACK);
        setBorder(new javax.swing.border.LineBorder(cColor.GREEN, 1));
    }
}
