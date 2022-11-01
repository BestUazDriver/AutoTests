package com.sabitov.helpers;

import com.sabitov.ApplicationManager;
import com.sabitov.base.HelperBase;

public class NavigationHelper extends HelperBase {

    private String baseUrl;

    public NavigationHelper(ApplicationManager applicationManager, String baseUrl) {
        super(applicationManager);
        this.baseUrl = baseUrl;
    }
    public void getHomePage() {
        driver.get("https://github.com/");
    }
}
