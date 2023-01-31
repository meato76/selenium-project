package com.cydeo.tests.day06_alert_iframes_window;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dropdown_T6_T7_T8 {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){



        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }

    @Test (priority = 1)
    public void dropdown_task6() throws InterruptedException {

        //  TC #6: Selecting date on dropdown and verifying



        //  3. Select “December 1st, 1933” and verify it is selected.

        // Locate dropdowns and pass them in Select object constructors
        Select yearDropdowns = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdowns = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdowns = new Select(driver.findElement(By.xpath("//select[@id='day']")));


        // Select year using : visible text
        yearDropdowns.selectByVisibleText("1933");


        // Select month using : value attribute
        monthDropdowns.selectByValue("11");
        Thread.sleep(2000);

        //Select day using : index number
        dayDropdowns.selectByVisibleText("1");
        Thread.sleep(2000);

        //created expected values

        String expectedYear = "1933";
        String expectedMonth = "December";
        String expectedDay = "1";

        //Getting actual values from browser
        String actualYear = yearDropdowns.getFirstSelectedOption().getText();
        String actualMonth = monthDropdowns.getFirstSelectedOption().getText();
        String actualDay = dayDropdowns.getFirstSelectedOption().getText();

        Assert.assertTrue(actualYear.equals(expectedYear),"ACTUAL YEAR NOT EQUAL EXPECTED YEAR!!");
        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualDay,expectedDay);


    }

    @Test (priority = 2)
    public void dropdown_task7() throws InterruptedException {

        //TC #7: Selecting state from State dropdown and verifying result

        //Locate the dropdown and create select object
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        // Use all Elect option. (visible test, value, index)
        //3. Select Illinois
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Illinois");


        //4. Select Virginia
        Thread.sleep(2000);
        stateDropdown.selectByValue("VA");

       // 5. Select California

        Thread.sleep(2000);
        stateDropdown.selectByIndex(5);


        //6. Verify final selected option is California.
       String expectedOptionText ="California";
       String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

       //assertion
        Assert.assertEquals(actualOptionText, expectedOptionText, "STATE DROPDOWN VALUE IS NOT AS EXPECTED!!");


        }


    @Test
    public void dropdown_task8() throws InterruptedException {
        //TC #8: Selecting value from non-select dropdown

        // 3. Click to non-select dropdown
        //Locate webSiteDropdown =
        WebElement webSiteDropdown = driver.findElement(By.linkText("Dropdown link"));
        Thread.sleep(1000);
        webSiteDropdown.click();
        Thread.sleep(1000);


        // 4. Select Facebook from dropdown
        WebElement facebookLink = driver.findElement(By.linkText("Facebook"));
        Thread.sleep(1000);
        facebookLink.click();
        Thread.sleep(2000);


        // 5. Verify title is “Facebook - Log In or Sign Up”
            String expectedTitle = "Facebook - log in or sign up";
            String actualTitle = driver.getTitle();

            Assert.assertEquals(actualTitle, expectedTitle, " Titles are not equal!!!");

    }

}
