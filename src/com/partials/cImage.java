package com.partials;

import javax.swing.*;
import java.awt.*;

public class cImage extends JLabel {
    public cImage(String imagePath, int x, int y, int width, int height) {
        super();

        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        setIcon(scaledIcon);
        setBounds(x, y, width, height);

    }
}
