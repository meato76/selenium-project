package com.cydeo.tests.day04_findElement_checkbox_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T4StaleElementReferenceException {

    public static void main(String[] args) {


        //TC #4: StaleElementReferenceException Task
       // 1- Open a chrome browser
       // 2- Go to: https://practice.cydeo.com/abtest

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://practice.cydeo.com/abtest");


        // 3- Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());


        //4- Refresh the page.
        driver.navigate().refresh();
        System.out.println("Refresh the page....");


        //5- Verify it is displayed, again.
        cydeoLink = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());


    }
}
