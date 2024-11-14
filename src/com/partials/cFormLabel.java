package com.partials;

import javax.swing.*;

public class cFormLabel extends JLabel {
    public cFormLabel(String text, int x, int y, int width) {
        super();
        setText(text);
        setBounds(x, y, width, 30);
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.FONT_SIZE_16);
        setForeground(cColor.BLACK);
    }
}
