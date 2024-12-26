package com.view.StaffView;

import com.main.resources.templates.cPanelSidebarApp;
import com.model.cContentStaffView;
import com.partials.*;

public class cSidebarStaffView extends cPanelSidebarApp {

        public cContentStaffView contentView;

        private cIconImage iconImage = new cIconImage();

        // component sidebar
        private cSidebarMenu menuHome = new cSidebarMenu(iconImage.iconHomeDefault, iconImage.iconHomeHover, "Home",
                        150);
        private cSidebarMenu menuProduct = new cSidebarMenu(iconImage.iconMenuDefault, iconImage.iconMenuHover,
                        "Product",
                        150 + 50);
        private cSidebarMenu menuSeats = new cSidebarMenu(iconImage.iconSeatsDefault, iconImage.iconSeatsHover, "Seats",
                        150 + 50 + 50);
        private cSidebarMenu menuTransaksi = new cSidebarMenu(iconImage.iconTransaksiDefault,
                        iconImage.iconTransaksiHover,
                        "Transactions", 150 + 50 + 50 + 50);
        private cSidebarMenu menuHistory = new cSidebarMenu(iconImage.iconHistoryDefault, iconImage.iconHistoryHover,
                        "History",
                        150 + 50 + 50 + 50 + 50);

        private void resetSidebar() {
                setVisible(false);

                menuHome.setForeground(cColor.WHITE);
                menuHome.setBackground(cColor.GREEN);
                menuHome.setSidebarInAktif();

                menuProduct.setForeground(cColor.WHITE);
                menuProduct.setBackground(cColor.GREEN);
                menuProduct.setSidebarInAktif();

                menuSeats.setForeground(cColor.WHITE);
                menuSeats.setBackground(cColor.GREEN);
                menuSeats.setSidebarInAktif();

                menuTransaksi.setForeground(cColor.WHITE);
                menuTransaksi.setBackground(cColor.GREEN);
                menuTransaksi.setSidebarInAktif();

                menuHistory.setForeground(cColor.WHITE);
                menuHistory.setBackground(cColor.GREEN);
                menuHistory.setSidebarInAktif();
        }

        public cSidebarStaffView(cContentStaffView contentView) {
                super();
                this.contentView = contentView;

                menuHome.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent me) {
                                initsHomeView();
                        }
                });

                menuProduct.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent me) {
                                initsProductView();

                        }
                });

                menuSeats.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent me) {
                                initsSeatsView();
                        }
                });

                menuTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent me) {
                                initsTransaksiView();
                        }
                });

                menuHistory.addMouseListener(new java.awt.event.MouseAdapter() {
                        @Override
                        public void mouseClicked(java.awt.event.MouseEvent me) {
                                initsHistoryView();
                        }
                });

                bgPanel.add(menuHome);
                bgPanel.add(menuProduct);
                bgPanel.add(menuSeats);
                bgPanel.add(menuTransaksi);
                bgPanel.add(menuHistory);
                initsHomeView();
        }

        private void initsHomeView() {
                resetSidebar();
                menuHome.setForeground(cColor.GREEN);
                menuHome.setBackground(cColor.WHITE);
                menuHome.setSidebarAktif();

                contentView.showHomeView();

                setVisible(true);

        }

        private void initsProductView() {
                resetSidebar();

                menuProduct.setForeground(cColor.GREEN);
                menuProduct.setBackground(cColor.WHITE);
                menuProduct.setSidebarAktif();

                contentView.showDataProductView();

                setVisible(true);

        }

        private void initsSeatsView() {
                resetSidebar();

                menuSeats.setForeground(cColor.GREEN);
                menuSeats.setBackground(cColor.WHITE);
                menuSeats.setSidebarAktif();

                contentView.showSeatsView();

                setVisible(true);

        }

        private void initsTransaksiView() {
                resetSidebar();

                menuTransaksi.setForeground(cColor.GREEN);
                menuTransaksi.setBackground(cColor.WHITE);
                menuTransaksi.setSidebarAktif();

                contentView.showDataTransaksiView();

                setVisible(true);

        }

        private void initsHistoryView() {
                resetSidebar();

                menuHistory.setForeground(cColor.GREEN);
                menuHistory.setBackground(cColor.WHITE);
                menuHistory.setSidebarAktif();

                contentView.showHistoryTransaksiView();

                setVisible(true);

        }

}
