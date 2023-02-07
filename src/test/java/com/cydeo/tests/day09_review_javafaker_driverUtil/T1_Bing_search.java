package com.cydeo.tests.day09_review_javafaker_driverUtil;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_Bing_search extends TestBase {

    //TC #1: Bing search
    //1- Open a Chrome browser
    //2- Go to: https://bing.com

    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        //TC #1: Bing search
        //1- Open a Chrome browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //2- Go to: https://bing.com
        driver.get(ConfigurationReader.getProperty("bing.url"));

    }

    @Test
    public void bing_search_test(){
        //  3- Write “apple” in search box
        //locate search box

        WebElement searchBox = driver.findElement(By.xpath("//input[@name]"));
        searchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Search

        String actualTitle= driver.getTitle();

        //We are just making the expectedTitle dynamic based on the text we are searching
        String expectedTitle = ConfigurationReader.getProperty("searchValue")+" - Search";
        Assert.assertEquals(actualTitle,expectedTitle);

    }


}
