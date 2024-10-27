package com.main.resources.templates;

import javax.swing.*;

import com.partials.*;

public abstract class cPanelSidebarApp extends JPanel {

    public JPanel bgPanel = new JPanel();
    public JPanel sidebarPanel = new JPanel();

    public cPanelSidebarApp() {
        super();
        setSize(240, 768);
        setLayout(null);

        bgPanel.setBackground(cColor.GREEN);
        bgPanel.setBounds(0, 0, 240, 768);
        bgPanel.setLayout(null);

        add(bgPanel);
    }
}
