package com.cydeo.tests.review.week3;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HarSoftAssertion {

    // TC#1: Registration Form Page Testing
    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/registration_form
    // 3. Verify title is as expected:
    // Expected: "Registration Form"
    // 4. Select "SDET" from Job title dropdown
    // 5. Verify "SDET" is selected

    WebDriver driver;
    @BeforeClass
    public void setUp(){

    }

    @BeforeMethod
    public void setUpMethod(){
        // TC#1: Registration Form Page Testing
        // 1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

    }

    @Test
    public void registration_form_page_hardAssert_test(){

        // 3. Verify title is as expected:
        // Expected: "Registration Form"

        String actualTitle = driver.getTitle();
        String expectedTitle = "Registration Form";
       // Assert.assertTrue(actualTitle.equals(expectedTitle), "Title verification is Failed!!!");
        Assert.assertEquals(actualTitle, expectedTitle, "Title verification is Failed!!!");

        // 4. Select "SDET" from Job title dropdown

        Select selectJobTitle = new Select(driver.findElement(By.name("job_title")));
        selectJobTitle.selectByVisibleText("SDET");

        selectJobTitle.selectByIndex(4);// index number starts from 0 in dropdown

        // 5. Verify "SDET" is selected
        String actualSelectedOption = selectJobTitle.getFirstSelectedOption().getText();
        String expectedSelectedOption = "SDET";
        Assert.assertEquals(actualSelectedOption, expectedSelectedOption);


        //Assert.assertTrue(selectJobTitle.getFirstSelectedOption().isSelected());

    }

    @Test
    public void registration_form_page_softAssert_test(){

        // 3. Verify title is as expected:
        // Expected: "Registration Form"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Registration For";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle);

        System.out.println("After soft assertion failed!");

        // 4. Select "SDET" from Job title dropdown
        Select selectJobtitle = new Select(driver.findElement(By.name("job_title")));
        //selectJobtitle.selectByVisibleText("SDET");
        selectJobtitle.selectByIndex(4); //index number starts from 0 in dropdown options

        // 5. Verify "SDET" is selected
        String actualSelectedOption = selectJobtitle.getFirstSelectedOption().getText();
        String expectedSelectedOption = "SDET";
        softAssert.assertEquals(actualSelectedOption,expectedSelectedOption);

        // If you don't use assertAll(), softAssert will not work and assert checks will not be happening
        softAssert.assertAll();


    }
    @AfterMethod

    public void teardownMethod() {
        driver.quit();
    }
}




