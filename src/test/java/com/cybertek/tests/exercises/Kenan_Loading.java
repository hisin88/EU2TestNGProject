package com.cybertek.tests.exercises;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

public class Kenan_Loading {

    WebDriver driver;

    @DataProvider(name="credentials") // truck driver credentials
    public static Object[][] credentials() {

        return new Object[][]{
                {"user18", "UserUser123"},
               {"storemanager62", "UserUser123"},
               {"salesmanager117", "UserUser123"}
                };
    }

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }


    @Test(dataProvider = "credentials")
    public void loginAsTruckDriver(String username, String password) {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        driver.findElement(By.id("prependedInput")).sendKeys(username);
        driver.findElement(By.id("prependedInput2")).sendKeys(password);
        //System.out.println("Before clicking submit Title : " + driver.getTitle());
        driver.findElement(By.id("_submit")).click();

        //WebElement element = driver.findElement(By.xpath("//*[.='Loading...']"));
        //WebElement element = driver.findElement(By.cssSelector(".loader-mask .loader-frame"));


        WebElement element = driver.findElement(By.id("progressbar"));
        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector( "div[class='loader-mask shown']"))));
        Assert.assertTrue(element.isDisplayed(),"loading is displayed");
        System.out.println("element = " + element.getText());



    }
}
