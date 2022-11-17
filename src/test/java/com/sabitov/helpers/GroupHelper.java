package com.sabitov.helpers;

import com.sabitov.ApplicationManager;
import com.sabitov.base.HelperBase;
import com.sabitov.data.CreateRepositoryData;
import com.sabitov.data.GroupData;
import com.sabitov.data.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GroupHelper extends HelperBase {
    public GroupHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createRepository(String name){
        driver.findElement(By.xpath("//form[@id='new_repository']/button")).click();
        driver.findElement(By.id("repository_name")).click();
        driver.findElement(By.id("repository_name")).clear();
        driver.findElement(By.id("repository_name")).sendKeys(name);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='new_repository']/div[7]/button")));
        element.click();
    }

    public void deleteRepository(String name){
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='New project'])[1]/following::summary[1]")).click();
        driver.findElement(By.linkText("Your repositories")).click();
        driver.findElement(By.linkText(name)).click();
        driver.findElement(By.id("settings-tab")).click();
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[9]/ul/li[4]/details/summary")).click();
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[9]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).clear();
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[9]/ul/li[4]/details/details-dialog/div[3]/form/p/input")).sendKeys(UserData.name + "/" + CreateRepositoryData.name);
        driver.findElement(By.xpath("//div[@id='options_bucket']/div[9]/ul/li[4]/details/details-dialog/div[3]/form/button/span")).click();
    }

    public GroupData GetCreatedGroupData(String names){
        getRepositories();
// String groupName = driver.findElement(By.name("group_name")).getAttribute("value");
        WebElement element = driver.findElement(By.linkText(names));
        String name = element.getText();
        String description = driver.findElement(By.xpath("//*[@id=\"user-repositories-list\"]/ul/li[1]/div[1]/div[1]/h3/a")).getText();
        return new GroupData(name, description);
    }

    private void getRepositories(){
        driver.findElement(By.xpath("//summary/img")).click();
        driver.findElement(By.linkText("Your repositories")).click();
        driver.get("https://github.com/BestUazDriver?tab=repositories");
    }
}
