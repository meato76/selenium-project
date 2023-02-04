package com.cydeo.tests.review;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class AlertPractice extends TestBase {

    //    1. Open browser
//    2. Go to website: https://practice.cydeo.com/javascript_alerts
//    3. Click to “Click for JS Prompt” button
//    4. Send “hello” text to alert
//    5. Click to OK button from the alert
//    6. Verify “You entered: hello” text is displayed.

        @Test
        public void prompt_alert_test() {

            // 2. Go to https://practice.cydeo.com/javascript_alerts
            driver.get("https://practice.cydeo.com/javascript_alerts");


            WebElement jsPromptAlertBTN = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
            jsPromptAlertBTN.click();


            Alert alert = driver.switchTo().alert();
            System.out.println("alert.getText() = " + alert.getText());

            //3. Click to “Click for JS Prompt” button
            alert.sendKeys("hello");

            // 5. Click to OK button from the alert
        alert.accept();


            // 6. Verify “You entered: hello” text is displayed.
         WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

         String actualText = resultText.getText();
         String expectedText = "You entered: hello";

            Assert.assertEquals(actualText,expectedText);

        }
        @AfterMethod
    public void threadDown(){
        driver.quit();
        }
    }
