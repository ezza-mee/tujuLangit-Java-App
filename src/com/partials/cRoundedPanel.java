package com.partials;

import javax.swing.*;
import java.awt.*;

public class cRoundedPanel extends JPanel {

    private int cornerRadius;

    public cRoundedPanel(int radius) {
        super();
        this.cornerRadius = radius;
        setBounds(0, 0, 0, 0);
        setBackground(cColor.GREEN);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
    }
}
