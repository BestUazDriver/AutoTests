package com.sabitov.helpers;

import com.sabitov.ApplicationManager;
import com.sabitov.base.HelperBase;
import com.sabitov.data.SignInData;
import org.openqa.selenium.By;

public class LogInHelper extends HelperBase {
    public LogInHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void signIn() {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("login_field")).clear();
        driver.findElement(By.id("login_field")).sendKeys(SignInData.username);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(SignInData.password);
        driver.findElement(By.name("commit")).click();
    }

    public boolean isSignedIn() {
        return driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details")) != null;
    }
}
