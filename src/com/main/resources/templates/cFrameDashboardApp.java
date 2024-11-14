package com.main.resources.templates;

import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.partials.*;

public abstract class cFrameDashboardApp extends JFrame {

    private int mouseX, mouseY;

    public JPanel bgFrame = new JPanel();
    public JPanel sidebarPanel = new JPanel();
    public JPanel headerPanel = new JPanel();
    public JLabel logoutLabel = new cLogout(1000);

    private cImage imageBrand = new cImage("src/com/main/resources/images/brandIcon.png", 35, 20, 45, 45);
    private JLabel brandText = new JLabel("TujuLangit");
    private JLabel logoBrandText = new JLabel("ForestPark");
    public JLabel menuTitle = new JLabel("Menu Title");
    public JLabel copyrighTitle = new JLabel("Copyright. TujuLangit ForestPark");

    public cFrameDashboardApp() {
        super();
        setSize(1366, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);

        bgFrame.setBackground(cColor.GREY);
        bgFrame.setBounds(0, 0, 1366, 768);
        bgFrame.setLayout(null);

        sidebarPanel.setBackground(cColor.GREEN);
        sidebarPanel.setBounds(0, 0, 240, 768);
        sidebarPanel.setLayout(null);

        headerPanel.setBounds(240, 0, 1126, 70);
        headerPanel.setBackground(cColor.WHITE);
        headerPanel.setLayout(null);

        brandText.setFont(cFonts.FONT_SIZE_20);
        brandText.setBounds(85, 0, 240, 70);
        brandText.setVerticalAlignment(JLabel.CENTER);
        brandText.setForeground(cColor.WHITE);

        logoBrandText.setFont(cFonts.FONT_SIZE_14);
        logoBrandText.setBounds(88, 20, 240, 70);
        logoBrandText.setVerticalAlignment(JLabel.CENTER);
        logoBrandText.setForeground(cColor.WHITE);

        headerPanel.add(logoutLabel);
        sidebarPanel.add(imageBrand);
        sidebarPanel.add(brandText);
        sidebarPanel.add(logoBrandText);
        bgFrame.add(headerPanel);
        bgFrame.add(sidebarPanel);
        add(bgFrame);

        // Menambahkan listener untuk menggeser frame
        bgFrame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        bgFrame.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                // Menghitung posisi baru frame
                int newX = e.getXOnScreen() - mouseX;
                int newY = e.getYOnScreen() - mouseY;
                setLocation(newX, newY);
            }
        });
    }

    public cFrameDashboardApp(String title) {
        this();
        setTitle(title);
    }
}
