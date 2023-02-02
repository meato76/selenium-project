package com.cydeo.utilities;


/*
This class will be storing only the utility methods that can be used across the project.

 */


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    public static void sleep(int second) {

    /*
    This method will accept in (in seconds) and execute Thread.sleep method for given duration Arg : int second
     */

        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {


        }
    }

    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedTitle){

        // Return and store all window handles in a set
        Set<String> allWindowHandles = driver.getWindowHandles();

        for ( String each : allWindowHandles ) {

            driver.switchTo().window(each);
            System.out.println("Current URL = " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }

        //5. Assert: Title contains “Etsy”
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }


    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public static void verifyTitleContains(WebDriver driver, String expectedTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

}
