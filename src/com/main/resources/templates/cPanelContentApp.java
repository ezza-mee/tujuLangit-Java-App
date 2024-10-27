package com.main.resources.templates;

import javax.swing.*;

import com.partials.*;

public abstract class cPanelContentApp extends JPanel {

    public JPanel bgPanel = new JPanel();
    public JPanel contentPanel = new JPanel();

    public cPanelContentApp() {
        super();
        setSize(1126, 698);
        setLayout(null);

        bgPanel.setBounds(0, 0, 1126, 698);
        bgPanel.setBackground(cColor.GREY);
        bgPanel.setLayout(null);

        add(bgPanel);
    }

}
