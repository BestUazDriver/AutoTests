package com.sabitov.base;

import com.sabitov.ApplicationManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;

public class TestBase {
    protected ApplicationManager applicationManager;

    JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        applicationManager = new ApplicationManager();
    }

    @After
    public void tearDown() throws Exception {
        applicationManager.stop();
    }

}
