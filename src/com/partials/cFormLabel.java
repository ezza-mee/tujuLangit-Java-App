package com.partials;

import javax.swing.*;

public class cFormLabel extends JLabel {
    public cFormLabel(String text, int x, int y, int width) {
        super();
        setText(text);
        setBounds(x, y, width, 30);
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.FROM_LABEL_FONT);
        setForeground(cColor.BLACK);
    }
}
