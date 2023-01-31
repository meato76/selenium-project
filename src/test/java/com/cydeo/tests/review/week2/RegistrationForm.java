package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationForm {


    // TC#1: Registration Form Page Testing
    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/registration_form
    // 3. Verify title is as expected:
    // Expected: "Registration Form"


    // TC#2: Registration Form Page Filling Form Test
    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/registration_form
    // 3. Enter First name: "John"
    // 4. Enter Last name: "Smith"
    // 5. Enter Username: "johnsmith123"
    // 6. Enter Email address: "john.smith@email.com"
    // 7. Enter password: "John1234"
    // 8. Enter Phone number: "123-456-7890"
    // 9. Click to "Male" from Gender
    // 10. Enter Date of birth "01/28/1990"
    // 11. Select "Department of Engineering" from Department/Office dropdown
    // 12. Select "SDET" from Job title dropdown
    // 13. Click to "Java" from languages
    // 14. Click to "Sign up" button
    // 15. Verify text displayed on page
    //     Expected: "Well done!"


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


    @Test (priority = 1)
    public void registration_form_page_test(){

        // 3. Verify title is as expected:
        // Expected: "Registration Form"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Registration Form";

        Assert.assertEquals(actualTitle,expectedTitle,"Title verification is failed!");

    }

    @Test (priority = 2)
    public void registration_form_page_filling_test(){
        // 3. Enter First name: "John"
        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("John");

        // 4. Enter Last name: "Smith"
        WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys("Smith");

        // 5. Enter Username: "johnsmith123"
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("johnsmith123");

        // 6. Enter Email address: "john.smith@email.com"
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("john.smith@email.com");

        // 7. Enter password: "John1234"
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("John1234");

        // 8. Enter Phone number: "123-456-7890"
        WebElement phonenum = driver.findElement(By.name("phone"));
        phonenum.sendKeys("123-456-7890");

        // 9. Click to "Male" from Gender
        WebElement maleBtn = driver.findElement(By.cssSelector("input[value='male']"));
        maleBtn.click();

        // 10. Enter Date of birth "01/28/1990"
        WebElement dateOfBirth = driver.findElement(By.name("birthday"));
        dateOfBirth.sendKeys("01/28/1990");
        // 11. Select "Department of Engineering" from Department/Office dropdown
        Select selectDepartment = new Select(driver.findElement(By.name("department")));
        //SelectDepartment.selectByVisibleText("Department of Engineering");
        //selectDepartment.selectByValue("DE");
         selectDepartment.selectByIndex(1); //index number start from 0

        // 12. Select "SDET" from Job title dropdown
        Select selectJobTitle = new Select(driver.findElement(By.name("job_title")));
        selectJobTitle.selectByVisibleText("SDET");



        // 13. Click to "Java" from languages
        driver.findElement(By.id("inlineCheckbox2")).click();


        // 14. Click to "Sign up" button

        driver.findElement(By.xpath("//button[.='Sign up']")).click();

        // 15. Verify text displayed on page
        //     Expected: "Well done!"
        WebElement resultText = driver.findElement(By.cssSelector(".alert-heading"));
        String actualText = resultText.getText();
        String expectedText = "Well done!";
        Assert.assertEquals(actualText,expectedText);




    }

    @AfterMethod

    public void teardownMethod() {
        driver.quit();
    }
}
