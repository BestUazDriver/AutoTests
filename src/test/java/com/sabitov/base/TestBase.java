package com.sabitov.base;

import com.sabitov.ApplicationManager;
import com.sabitov.data.CreateRepositoryData;
import com.sabitov.data.SignInData;
import com.sabitov.data.UserData;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.fail;

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
