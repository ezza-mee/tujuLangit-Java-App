package com.main.resources.templates;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.partials.*;

public abstract class cFrameLoginApp extends JFrame {

    private int mouseX, mouseY;

    public JPanel bgFrame = new JPanel();
    public JPanel cardLogin = new cPanelRounded(500, 0, 600, 700, 30, 0);
    public JPanel lineTitle = new JPanel();
    public JLabel titleLogin = new JLabel("Title Login");
    public JLabel titleFrom = new JLabel("Title Login");
    public JLabel titleLogout = new cLogout(990);
    private cImage imageBijiCoffe = new cImage(
            "src/com/main/resources/images/bg.jpg",
            0, 0, 700, 700);

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

        titleLogin.setFont(cFonts.TITLE_START_FONT);
        titleLogin.setForeground(cColor.GREEN);
        titleLogin.setBounds(30, 140, 550, 40);
        titleLogin.setHorizontalAlignment(JLabel.CENTER);
        titleLogin.setVerticalAlignment(JLabel.CENTER);

        titleFrom.setFont(cFonts.TITLE_START_FONT);
        titleFrom.setForeground(cColor.WHITE);
        titleFrom.setBounds(180, 250, 550, 40);

        lineTitle.setBackground(cColor.GREEN);
        lineTitle.setLayout(null);
        lineTitle.setBounds(250, 180, 120, 5);

        bgFrame.add(titleLogout);

        cardLogin.add(titleLogin);
        cardLogin.add(lineTitle);
        bgFrame.add(cardLogin);
        bgFrame.add(titleFrom);
        bgFrame.add(imageBijiCoffe);
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
