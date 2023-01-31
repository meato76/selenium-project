package com.cydeo.tests.day02_locators_getText_getAttribut;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerifications {

    public static void main(String[] args) {

        // TC #2: Back and forth navigation
        //1- Open a Chrome browser

        WebDriverManager.chromedriver();

        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com");

       // 2- Go to: https://practice.cydeo.com

        driver.navigate().to("https://practice.cydeo.com");

        //3.Verify URL contains
        //Expected: Cydeo

        String expectedInURL ="cydeo";

        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedInURL)){
            System.out.println("Pass!");
        }else {
            System.out.println("URL verification Failed!!!");
        }

        //4. Verify title:
        //Expected: Practice

        String expectedTitle ="Practice";

        String actualTitle= driver.getTitle();// returns "Practice"

        if (actualTitle.equals(expectedTitle)){

            System.out.println("Title verification is PASSED");

        }else {
            System.out.println("Title verification is FAILS");
        }

        //close the browser

        driver.close();




    }





}

/*

2- Go to: https://practice.cydeo.com
3- Click to A/B Testing from top of the list.
4- Verify title is:
Expected: No A/B Test
5- Go back to home page by using the .back();
6- Verify title equals:
Expected: Practice
 */