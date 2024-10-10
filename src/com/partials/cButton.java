package com.partials;

import javax.swing.*;

public class cButton extends JButton {
    public cButton(String text, int x, int y, int width, int height) {
        super();
        setText(text);
        setBounds(x, y, width, height);
        setFont(cFonts.BUTTON_FONT);
        setBackground(cColor.GREEN);
        setForeground(cColor.WHITE);
        setBorder(null);
    }
}
