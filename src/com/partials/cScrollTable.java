package com.partials;

import javax.swing.*;
    
    public class cScrollTable extends JScrollPane{
        public cScrollTable(java.awt.Component view, int x, int y, int widht, int height) {
            super(view);
            setBounds(x, y, widht, height);
            getViewport().setBackground(cColor.WHITE);
            setBorder(new javax.swing.border.LineBorder(cColor.WHITE, 1));
        }
    }
