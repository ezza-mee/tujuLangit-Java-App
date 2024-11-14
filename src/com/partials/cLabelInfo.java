package com.partials;

import javax.swing.*;

public class cLabelInfo extends JLabel {

    public cLabelInfo(String text, int x, int y, int width, int height) {
        super();
        setText(text);
        setBounds(x, y, width, height);
        setVerticalAlignment(JLabel.CENTER);
        setFont(cFonts.FONT_SIZE_15);
        setForeground(cColor.GREEN);
    }
}
