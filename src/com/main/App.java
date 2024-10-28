package com.main;

import com.main.controller.*;
import com.main.resources.templates.*;

public class App {
    public static void main(String[] args) {

        // Controller.showLoginAdmin();
        Controller.showDashboardKaryawan();
        // Controller.showDashboardAdmin();
    

        // contoh sebelum menjadikan class abstrack, class tersebut masih bisa dipanggil
        // sebagai object
        // ini adalah instance dari objeck kelas cFrameDahsboardApp
        // cFrameDashboardApp testFrame = new cFrameDashboardApp();
        // testFrame.setVisible(true);
    }
}
