package com.cydeo.tests;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_Order_Verify {


    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        //TC #1: Web table practice

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //1. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");

    }

    @Test
    public void  order_verify_name_taste (){


        //2. Verify Bob’s name is listed as expected.
        // Below locator is locating me the bob Martin's cell as where it is currently stored
        //table[@class='SampleTable']/tbody/tr[7]/td[2]

       // locate Bob's cell using its name as the text.
        WebElement bobsCell = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody//td[.='Bob Martin']"));
        System.out.println("bobsCell = " + bobsCell.getText());



        // Expected: “Bob Martin”

        String expectedName = "Bob Martin";
        String actualName = bobsCell.getText();

        Assert.assertEquals(actualName,expectedName, "Names are NOT matching!!!!");


        //3. Verify Bob Martin’s order date is as expected
       // : 12/31/2021

        WebElement bobOrderDate = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody//td[.='Bob Martin']/following-sibling::td[3]"));

        System.out.println("orderDate = " + bobOrderDate.getText());

        String expectedDate = "12/31/2021";
        String actualOrderDatDate = bobOrderDate.getText();

        Assert.assertEquals(actualOrderDatDate,expectedDate, "Date is not matching the data!!!");
    }

}

/*

 */