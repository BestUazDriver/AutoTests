package com.sabitov.helpers;

import com.sabitov.ApplicationManager;
import com.sabitov.base.HelperBase;
import com.sabitov.data.CreateRepositoryData;
import com.sabitov.data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GroupHelper extends HelperBase {
    public GroupHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createRepository(){
        driver.findElement(By.xpath("//form[@id='new_repository']/button")).click();
        driver.findElement(By.id("repository_name")).click();
        driver.findElement(By.id("repository_name")).clear();
        driver.findElement(By.id("repository_name")).sendKeys(CreateRepositoryData.name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='new_repository']/div[7]/button")));
        element.click();
    }

    public void deleteRepository(){
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New project'])[1]/following::summary[1]")).click();
        driver.findElement(By.linkText("Your repositories")).click();
        driver.findElement(By.linkText(CreateRepositoryData.name)).click();
        driver.findElement(By.id("settings-tab")).click();
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[9]/ul/li[4]/details/summary")).click();
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[9]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).clear();
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[9]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).sendKeys(UserData.name + "/" + CreateRepositoryData.name);
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[9]/ul/li[4]/details/details-dialog/div[3]/form/button/span")).click();
    }
}
