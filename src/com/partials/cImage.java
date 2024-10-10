package com.partials;

import javax.swing.*;

public class cImage extends JLabel {
    public cImage(String imagePath, int x, int y, int width, int height) {
        super();
        ImageIcon icon = new ImageIcon(imagePath);

        setIcon(icon);
        setBounds(x, y, width, height);

    }
}
