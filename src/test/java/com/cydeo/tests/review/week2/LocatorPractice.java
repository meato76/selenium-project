package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LocatorPractice {
    public static void main(String[] args) {




        // TC#1: Practice page Login test
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 2. Go to http://practice.cydeo.com/login
        driver.get("http://practice.cydeo.com/login");

        // 3. Enter username: "tomsmith"

        //WebElement username1 = driver.findElement(By.name("username"));
        WebElement username2 = driver.findElement(By.xpath("//input[@name='username']"));
                username2.sendKeys("tomsmith");


        // 4. Enter password: "SuperSecretPassword"

       // WebElement password1 = driver.findElement(By.name("password"));
        WebElement password2 = driver.findElement(By.cssSelector("input[type='password']"));
                password2.sendKeys("SuperSecretPassword");


        // 5. Click to Log in button
        //WebElement loginButton1 = driver.findElement(By.className("btn btn-primary"));--> do not USE class value if it has a space

        WebElement loginButton2 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        WebElement loginButton3= driver.findElement(By.id("wooden_spoon"));
        WebElement loginButton4= driver.findElement(By.cssSelector(".btn.btn-primary"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       loginButton2.click();



        // 6. Verify text displayed on page
        //    Expected: "You logged into a secure area!"

        WebElement resultText1 = driver.findElement(By.id("flash"));

        WebElement resultText2 = driver.findElement(By.xpath("//div[normalize-space(text())='You logged into a secure area!']"));

        String actualText = resultText2.getText();

        String expectedText ="You logged into a secure area!";

        if (actualText.contains(expectedText)){
            System.out.println("Result text verification test passed!");
        }else {
            System.out.println("Result text verification test Failed!!!");
        }


        driver.quit();



    }
}
