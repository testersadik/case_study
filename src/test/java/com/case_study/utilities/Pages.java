package com.case_study.utilities;

import com.case_study.pages.*;

public class Pages {


    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    public LoginPage loginPage(){
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }


    public DashboardPage dashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }



}
