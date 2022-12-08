package com.sabitov.helpers;

import com.sabitov.ApplicationManager;
import com.sabitov.base.HelperBase;
import com.sabitov.data.SignInData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInHelper extends HelperBase {
    public LogInHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void signInWithValidData() {
        if (IsLoggedIn()) {
            logout();
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
        element.click();
        driver.findElement(By.id("login_field")).clear();
        driver.findElement(By.id("login_field")).sendKeys(SignInData.validUsername);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(SignInData.validPassword);
        driver.findElement(By.name("commit")).click();
    }

    public void signInWithInvalidData() {
        if (IsLoggedIn()) {
            logout();
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
        element.click();
        driver.findElement(By.id("login_field")).clear();
        driver.findElement(By.id("login_field")).sendKeys(SignInData.invalidUsername);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(SignInData.invalidPassword);
        driver.findElement(By.name("commit")).click();
    }

    public boolean isSignedIn() {
        return driver.findElements(By.xpath("/html/body/div[1]/header/div[7]/details")).size() > 0;
    }

    public boolean IsLoggedIn() {
        return driver.findElements(By.xpath("/html/body/div[1]/header/div[7]/details")).size() > 0;
    }

    public boolean IsLoggedIn(String username) {
        return driver.findElements(By.xpath("/html/body/div[1]/header/div[7]/details")).size() > 0;
    }

    public void logout() {
        driver.findElement(By.xpath("//div[7]/details/summary/span")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Settings'])[2]/following::button[1]")).click();
    }
}
