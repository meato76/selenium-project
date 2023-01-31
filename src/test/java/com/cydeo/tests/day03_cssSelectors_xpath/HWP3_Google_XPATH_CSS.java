package com.cydeo.tests.day03_cssSelectors_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP3_Google_XPATH_CSS {

    public static void main(String[] args) {


        //TC #3: Back and forth navigation
        // 1- Open a Chrome browser


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://google.com
        driver.get("https://google.com");


        // 3- Click to Gmail from top right.
        // Locating the Gmail link using "xpath" locator
        //tagName[@attribute='value']
        // WebElement gmailLink = driver.findElement(By.xpath(//a[@href='https://mail.google.com/mail/&ogbl']));


        //Using the text of the web element with XPATHLocator
        //tagName[text()='textValue']--> //tagName[.='textValue']
        //WebElement gmailLink = driver.findElement(By.xpath("//a[text='Gmail']"));
        //WebElement gmailLink = driver.findElement(By.xpath("//a[.='Gmail']"));


        //Locating the Gmail link using "ccSelector" locator
        // -->tagName[attribute='value']
        WebElement gmailLink = driver.findElement(By.cssSelector("a[href='https://mail.google.com/mail/&ogbl']"));


        //click to the gmail link
        gmailLink.click();

        // 4- Verify title contains:
        // Expected: Gmail

        String expectedGmailTitle = "Gmail";
        String actualGmailTitle = driver.getTitle();

        if (actualGmailTitle.contains(expectedGmailTitle)) {
            System.out.println("Gmail Title verification Passed!");
        } else {
            System.out.println("Gmail Title verification Failed !!!");
        }

        // 5- Go back to Google by using the .back();
        driver.navigate().back();

        //6- Verify title equals:
        // Expected: Google

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Google title verification passed!");
        } else {
            System.out.println("Google title verification Failed!!!!");
        }


    }
}
