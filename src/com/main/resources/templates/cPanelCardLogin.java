package com.main.resources.templates;

import javax.swing.JPanel;
import com.partials.*;

public class cPanelCardLogin extends JPanel {

    public JPanel bgPanel = new JPanel();

    public cPanelCardLogin() {
        super();
        setSize(1100, 700);
        setLayout(null);

        bgPanel.setBounds(0, 0, 1126, 698);
        bgPanel.setBackground(cColor.GREY);
        bgPanel.setLayout(null);

        add(bgPanel);
    }
}


