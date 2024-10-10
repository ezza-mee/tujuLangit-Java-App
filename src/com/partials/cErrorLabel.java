package com.partials;

import javax.swing.*;

public class cErrorLabel extends JLabel {
    public cErrorLabel(String text, int x, int y, int width) {
        super();
        setText(text);
        setBounds(x, y, width, 30);
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.ERROR_LABEL_FONT);
        setForeground(cColor.RED);
    }
}
