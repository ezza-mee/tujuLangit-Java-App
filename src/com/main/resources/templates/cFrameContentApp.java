package com.main.resources.templates;

import javax.swing.*;

import com.partials.*;

public abstract class cFrameContentApp extends JPanel {

    public JPanel bgFrame = new JPanel();
    public JPanel contentFrame = new JPanel();

    public cFrameContentApp() {
        super();
        setSize(1126, 698);
        setLayout(null);

        bgFrame.setBounds(0, 0, 1126, 698);
        bgFrame.setBackground(cColor.GREY);
        bgFrame.setLayout(null);

        add(bgFrame);
    }

}
