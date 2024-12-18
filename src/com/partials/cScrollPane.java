package com.partials;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class cScrollPane extends JScrollPane {

    public cScrollPane(java.awt.Component view, int x, int y, int width, int height) {
        super(view);

        setBounds(x, y, width, height);

        setBackground(cColor.GREEN);

        getViewport().setBackground(cColor.GREEN);

        setBorder(new EmptyBorder(0, 0, 0, 0));

        setViewportBorder(BorderFactory.createLineBorder(cColor.GREY, 0, true));

        JScrollBar vertical = getVerticalScrollBar();
        JScrollBar horizontal = getHorizontalScrollBar();

        vertical.setPreferredSize(new Dimension(20, 0));
        horizontal.setPreferredSize(new Dimension(0, 0));

        vertical.setBackground(cColor.GREY);
        horizontal.setBackground(cColor.GREY);

        vertical.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = cColor.GREEN;
                this.trackColor = cColor.GREY;
            }
        });

        horizontal.setUI(new javax.swing.plaf.basic.BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = cColor.GREEN;
                this.trackColor = cColor.GREY;
            }
        });
    }
}
