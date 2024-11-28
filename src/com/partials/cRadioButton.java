package com.partials;

import javax.swing.JRadioButton;

public class cRadioButton extends JRadioButton {

    public cRadioButton(String text, String value, int x, int y, int width) {
        super();
        setBounds(x, y, width, 30);
        setFont(cFonts.FONT_SIZE_14);
        setForeground(cColor.GREEN);
        setBackground(cColor.WHITE);
        setVerticalAlignment(JRadioButton.CENTER);
        setActionCommand(value);
        setText(text);
    }

}
