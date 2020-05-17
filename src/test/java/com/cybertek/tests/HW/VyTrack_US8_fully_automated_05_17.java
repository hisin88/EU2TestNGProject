package com.cybertek.tests.HW;

import com.cybertek.pages.BasePage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VyTrack_US8_fully_automated_05_17 extends TestBase {

    BasePage basePage = new BasePage();

    /***
     * AC1: Verify that authorized user should be able to access Vehicle Contract
     * and able to see all vehicle contracts on the grid
     */

    @Test (description = "AC1")
    public void AC1() {
        //navigate to "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"(done in BeforeMethod)
        //Use credentials to login (done in BeforeMethod)



        //hover over to Fleet module
        //Hover over to Vehicle Contracts module and click
        basePage.navigateToModule("Fleet", "Vehicle Contracts");

        //wait until loading completes
        //wait.until(ExpectedConditions.invisibilityOfAllElements(loader));
        BrowserUtils.waitForPageToLoad(10);

        //get title and print
        String pageSubTitle = basePage.getPageSubTitle();

        //verify to see all vehicle contracts as a list
        Assert.assertEquals(pageSubTitle, "All Vehicle Contract", "verify to access Vehicle Contract and see list");


    }
    /***
     * AC2: Verify that authorized user should be able to create Vehicle contract
     */
    @Test (description = "AC2")
    public void AC2(){

        //navigate to "https://qa1.vytrack.com/entity/Extend_Entity_VehicleContract"
        //Use credentials to login (done in BeforeMethod)

        //hover over to Fleet module
        //Hover over to Vehicle Contracts module and click
        basePage.navigateToModule("Fleet", "Vehicle Contracts");

        //wait until loading completes
        BrowserUtils.waitForPageToLoad(10);

        //Click on Create Vehicle Contract button

    }
}