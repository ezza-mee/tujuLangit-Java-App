package com.main.resources.templates;

import javax.swing.*;

import com.partials.*;

public abstract class cFrameSidebarApp extends JPanel {

    public JPanel bgFrame = new JPanel();
    public JPanel sidebarFrame = new JPanel();

    public cFrameSidebarApp() {
        super();
        setSize(240, 768);
        setLayout(null);

        bgFrame.setBackground(cColor.GREEN);
        bgFrame.setBounds(0, 0, 240, 768);
        bgFrame.setLayout(null);

        add(bgFrame);
    }
}
