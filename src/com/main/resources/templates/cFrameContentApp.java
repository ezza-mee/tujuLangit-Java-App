package com.main.resources.templates;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.partials.*;

public class cFrameContentApp extends JFrame {
    private int mouseX, mouseY;

    public JPanel bgFrame = new JPanel();
    public JPanel contentFrame = new JPanel();

    public cFrameContentApp() {
        super();
        setSize(800, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);

        bgFrame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        bgFrame.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int newX = e.getXOnScreen() - mouseX;
                int newY = e.getYOnScreen() - mouseY;
                setLocation(newX, newY);
            }
        });

    }

}
