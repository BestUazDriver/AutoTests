package com.sabitov.base;

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

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private final StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\WebDriver\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
    }

    @After
    public void tearDown() throws Exception {
//        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
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

    public void getHomePage(){
        driver.get("https://github.com/");
    }

    public void signIn(){
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("login_field")).clear();
        driver.findElement(By.id("login_field")).sendKeys(SignInData.username);
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(SignInData.password);
        driver.findElement(By.name("commit")).click();
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
