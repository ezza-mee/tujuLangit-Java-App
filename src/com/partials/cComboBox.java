package com.partials;

import javax.swing.*;
import java.awt.*;

public class cComboBox extends JComboBox<String> {
    public cComboBox(String[] items, int x, int y, int width, int height) {
        super(items);
        setBounds(x, y, width, height);
        setFont(cFonts.FONT_SIZE_14);
        setForeground(cColor.BLACK);
        setBackground(cColor.WHITE);
        setBorder(new javax.swing.border.LineBorder(cColor.GREEN, 1));
        setMaximumRowCount(3);

        setRenderer(new CustomComboBoxRenderer());
    }

    private class CustomComboBoxRenderer extends JLabel implements ListCellRenderer<Object> {
        public CustomComboBoxRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            setText(value.toString());

            if (isSelected) {
                setBackground(cColor.GREEN);
                setForeground(cColor.BLACK);
            } else {
                setBackground(cColor.WHITE);
                setForeground(cColor.BLACK);
            }
            return this;
        }
    }

    public void setModel(Object aModel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setModel'");
    }
}