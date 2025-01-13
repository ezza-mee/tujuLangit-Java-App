package com.view.staffView;

import com.main.controller.Controller;
import com.main.database.staff.cDetailAkunStaff;
import com.main.resources.templates.cFrameDashboardApp;
import com.model.cContentStaffView;
import com.partials.cFonts;
import com.partials.cLabelInfo;

public class cDashboardStaffView extends cFrameDashboardApp {

    private Integer idStaff = null; // Inisialisasi sebagai null
    private Object[] staffDetails = null; // Data detail staff

    private cContentStaffView componentContentView = new cContentStaffView();
    private cSidebarStaffView componentSidebarView = new cSidebarStaffView(componentContentView);

    private cLabelInfo labelRoleStaff = new cLabelInfo("", 40, 20, 500, 30); // Label untuk nama staff

    public cDashboardStaffView() {
        super();
        this.idStaff = Controller.getCurrentStaffId();
        staffDetails = cDetailAkunStaff.getDetailAkunStaff(idStaff);

        initsViewDashboardStaff();
    }

    public void initsViewDashboardStaff() {
        if (staffDetails != null && staffDetails[1] != null) {
            labelRoleStaff.setText("Welcome, " + staffDetails[1]);
        }

        labelRoleStaff.setFont(cFonts.FONT_SIZE_18);

        headerPanel.add(labelRoleStaff);

        componentContentView.setBounds(240, 70, 1126, 698);

        sidebarPanel.add(componentSidebarView);

        bgFrame.add(componentContentView);

        setVisible(true);
    }

    public String getStaffName() {
        return staffDetails != null && staffDetails[1] != null ? staffDetails[1].toString() : "Unknown";
    }
    
    public Integer getIdStaff() {
        return idStaff;
    }
}
