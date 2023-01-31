package com.cydeo.tests.day05_testNG_into_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T2_radio_button {

    public static void main(String[] args) throws InterruptedException {


        //TC #2: Radiobutton handling
        //1. Open Chrome browser
       // 2. Go to https://practice.cydeo.com/radio_buttons

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/radio_buttons");

        // 3. Click to “Hockey” radio button
        WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        Thread.sleep(2000);
        hockeyButton.click();

       // 4. Verify “Hockey” radio button is selected after clicking.

        if (hockeyButton.isSelected()){
            System.out.println("Button is selected. Verification PASSED!");
        }else {
            System.out.println("Button is NOT selected. Verification FAILED!!!!");
        }


        //USE XPATH LOCATOR FOR ALL WebElement LOCATORS





    }
}
