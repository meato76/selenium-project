package com.cydeo.tests.day03_cssSelectors_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HWP4_Link_XPATH_CSS {
    public static void main(String[] args) throws InterruptedException {

        //TC #4: Practice Cydeo – Class locator practice
        //1- Open a Chrome browser

       WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");
        //3- Click to “Home” link
        // Locating web element "Home"

        //WebElement homeLink = driver.findElement(By.linkText("Home"));
        //WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));

        //WebElement homeLink = driver.findElement(By.xpath("//a[text()='Home']"));



        //WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homeLink = driver.findElement(By.cssSelector("a.nav-link"));

        Thread.sleep(1000);
        homeLink.click();

        // 4- Verify title is as expected:
        // Expected: Practice

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification Passed!");
        }else{
            System.out.println("Title verification Failed!!!");
        }

        // PS: Locate “Home” link using “className” locator

        //a[href='https://tesla.com']
        //div[for='randomV12']]
        //div[name='kgl33']
        //div[id='55k']



    }
}
