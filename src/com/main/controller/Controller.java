package com.main.controller;

import com.view.*;

public class Controller {

    private static cLoginView frameLogin = new cLoginView();

    public static void showLoginAdmin() {
        frameLogin.setVisible(false);
        frameLogin.initsLoginAdmin();
        frameLogin.setVisible(true);
    }
}
