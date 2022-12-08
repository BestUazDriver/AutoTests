package com.sabitov;

import com.sabitov.helpers.ContactHelper;
import com.sabitov.helpers.GroupHelper;
import com.sabitov.helpers.LogInHelper;
import com.sabitov.helpers.NavigationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class ApplicationManager {

    private static ThreadLocal<ApplicationManager> applicationManagerThreadLocal = new ThreadLocal<>();

    private StringBuffer verificationErrors = new StringBuffer();
    private WebDriver driver;
    private String baseUrl;

    private ContactHelper contactHelper;
    private GroupHelper groupHelper;
    private LogInHelper logInHelper;
    private NavigationHelper navigationHelper;

    private ApplicationManager() {
        verificationErrors = new StringBuffer();
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        contactHelper = new ContactHelper(this);
        groupHelper = new GroupHelper(this);
        logInHelper = new LogInHelper(this);
        navigationHelper = new NavigationHelper(this, baseUrl);
    }

    public static ApplicationManager getInstance(){
        if (applicationManagerThreadLocal.get() == null){
            ApplicationManager applicationManager = new ApplicationManager();
            applicationManager.getNavigationHelper().getHomePage();
            applicationManagerThreadLocal.set(applicationManager);
        }
        return applicationManagerThreadLocal.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public LogInHelper getLogInHelper() {
        return logInHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void stop() {
        driver.quit();
    }

}
