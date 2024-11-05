package com.main.resources.templates;

import javax.swing.JLabel;
import javax.swing.JPanel;
import com.partials.*;

public class cPanelCardLogin extends JPanel {

    public JPanel bgPanel = new JPanel();

    public JLabel titleLogout = new cLogout(990);

    public cPanelCardLogin() {
        super();
        setSize(1100, 700);
        setLayout(null);

        bgPanel.setBounds(0, 0, 1100, 700);
        bgPanel.setBackground(cColor.GREEN);
        bgPanel.setLayout(null);

        titleLogout.setForeground(cColor.WHITE);

        bgPanel.add(titleLogout);

        add(bgPanel);
    }
}
