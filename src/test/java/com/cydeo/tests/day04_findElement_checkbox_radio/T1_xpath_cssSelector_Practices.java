package com.cydeo.tests.day04_findElement_checkbox_radio;

// XPATH and CSS Selector PRACTICES
// DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
// TC #1: XPATH and cssSelector Practices
//1. Open Chrome browser
// 2. Go to https://practice.cydeo.com/forgot_password
// 3. Locate all the WebElements on the page using XPATH and/or CSS
// locator only (total of 6)
// a. “Home” link
// b.“Forgot password” header
// c. “E-mail” text
// d. E-mail input box
// e. “Retrieve password” button
// f. “Powered by Cydeo" text
// 4. Verify all web elements are displayed.

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_Practices {
    public static void main(String[] args) throws InterruptedException {


        // XPATH and CSS Selector PRACTICES
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        // 3. Locate all the WebElements on the page using XPATH and/or CSS

        //Locate "Home' link, using

        // locator only (total of 6)
        // a. “Home” link, using cssSelector, syntax #1, class attribute value
        //                                          tagName[attribute='value']
        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));

        // a. “Home” link, using cssSelector, syntax #2, (tagName.classValue), class attribute value
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));


        // a. “Home” link, using cssSelector, syntax #1,href class attribute value
        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));


        // b.“Forgot password” header
        //Locate header, using xpath, using text of h2

        WebElement header_ex1 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        // Locate header, using cssSelector, syntax #1 locate parent element and move down to h2
        WebElement header_ex2 = driver.findElement(By.cssSelector("div[class='example'] >h2"));

        // Locate header, using cssSelector, syntax #2 locate parent element and move down to h2
        WebElement header_ex3 = driver.findElement(By.cssSelector("div.example >h2"));


        // c. “E-mail” text
        // Locate the 'email' label using xpath
        WebElement emailLabel_ex1 = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement emailLabel_ex2 = driver.findElement(By.xpath("//label[.='E-mail']"));


        // d. E-mail input box
        // Locate the 'email' input using xpath
        WebElement emailInput_ex1 = driver.findElement(By.xpath("//input[@name='email']"));

        // Locate the 'email' input using xpath contains method
        //tagName[contains(@attribute, 'value' )
        WebElement emailInput_ex2 = driver.findElement(By.xpath("//input[contains(@pattern, 'a-z')]"));




        // e. “Retrieve password” button
        // locate it using xpath
        WebElement retrievePasswordButton = driver.findElement(By.xpath("//button[@id='form_submit']"));


        // f. “Powered by Cydeo" text
        WebElement poweredByCydeoText= driver.findElement(By.xpath("//div[@style='text-align: center;']"));


        // 4. Verify all web elements are displayed.
        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());
        System.out.println("emailLabel_ex1.isDisplayed() = " + emailLabel_ex1.isDisplayed());
        System.out.println("emailInput_ex1.isDisplayed() = " + emailInput_ex1.isDisplayed());
        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());


        //wait 2 seconds before closing browser



        Thread.sleep(2000);
        driver.close();
    }
}
