package com.cydeo.tests.day02_locators_getText_getAttribut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HWP1_Etsy_Search_Title {

    public static void main(String[] args) {



        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser

        WebDriverManager.chromedriver();
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

       // 3. Search for “wooden spoon”

        WebElement searchForWoodenSpoon = driver.findElement(By.name("search_query"));
        searchForWoodenSpoon.sendKeys("Wooden spoon"+ Keys.ENTER);

       // 4. Verify title:
       // Expected: “Wooden spoon - Etsy”

        String expectedTitle ="Wooden spoon - Etsy";

        String actualTitle = driver.getTitle();

        // creat a simple condition to compare actual and expected titles
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Etsy title verification Pass!");
        }else {
            System.out.println("Etsy title verification Failed!!");
        }

        //close the browser
        driver.close();

    }
}
