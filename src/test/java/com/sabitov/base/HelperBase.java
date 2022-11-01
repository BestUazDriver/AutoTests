package com.sabitov.base;

import com.sabitov.ApplicationManager;
import org.openqa.selenium.*;

public class HelperBase {

    protected WebDriver driver;
    private boolean acceptNextAlert = true;
    protected ApplicationManager manager;




    public HelperBase(ApplicationManager applicationManager) {
        this.manager=applicationManager;
        this.driver= manager.getDriver();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
