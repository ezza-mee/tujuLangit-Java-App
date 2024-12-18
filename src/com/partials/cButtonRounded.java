package com.partials;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class cButtonRounded extends cButton {
    private int radius;
    private Color originalBackground;
    private Color hoverBackground;
    private Color pressedBackground;
    private cImage icon;

    public cButtonRounded(String text, int x, int y, int width, int height, int radius) {
        super(text, x, y, width, height);
        this.radius = radius;
        setFont(cFonts.FONT_SIZE_16);
        setBackground(cColor.GREEN);
        setForeground(cColor.WHITE);
        setBorder(new EmptyBorder(10, 20, 10, 20));
        setFocusPainted(false);
        setContentAreaFilled(false);

        originalBackground = getBackground();
        hoverBackground = cColor.GREEN.darker();
        pressedBackground = cColor.GREY.darker().darker();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverBackground);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(originalBackground);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pressedBackground);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (contains(e.getPoint())) {
                    setBackground(hoverBackground);
                } else {
                    setBackground(originalBackground);
                }
            }
        });
    }

    public void setIcon(cImage icon) {
        this.icon = icon;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));

        if (icon != null) {
            int iconX = (getWidth() - icon.getWidth()) / 2;
            int iconY = (getHeight() - icon.getHeight()) / 2;
            g2.drawImage(((ImageIcon) icon.getIcon()).getImage(), iconX, iconY, this);
        }

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getForeground());
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));
        g2.dispose();
    }
}
