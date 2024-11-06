package com.main.resources.templates;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.partials.*;

public abstract class cFrameLoginApp extends JFrame {

    private int mouseX, mouseY;

    public JPanel bgFrame = new JPanel();

    public cFrameLoginApp() {
        super();
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bgFrame.setBackground(cColor.GREEN);
        bgFrame.setBounds(0, 0, 1100, 700);
        bgFrame.setLayout(null);

        add(bgFrame);

        // Menambang listener untuk menggeser frame
        bgFrame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        bgFrame.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                // menghitung posisi baru frame
                int newX = e.getXOnScreen() - mouseX;
                int newY = e.getYOnScreen() - mouseY;
                setLocation(newX, newY);
            }
        });
    }

    public cFrameLoginApp(String title) {
        this();
        setTitle(title);
    }
}
