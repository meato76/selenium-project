package com.cydeo.tests.day06_alert_iframes_window;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_Alert_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Open browser
        //2. Go to website: http://practice.cydeo.com/javascript_alerts

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }


    @Test
    public void information_alert_test1() throws InterruptedException {


        // TC #1: Information alert practice

        //3. Click to “Click for JS Alert” button
        WebElement JSAlert = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        Thread.sleep(1000);
        JSAlert.click();
        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));


        //Failure message will only display if assertion fails:
        Assert.assertTrue(resultText.isDisplayed(), "Result text is NOT displayed!");

        String expectedText = "You successfully clicked an alert";
        String actualText = resultText.getText();

        Assert.assertEquals(actualText, expectedText, "Actual result is NOT as the expected!");
    }

    @Test

    public void confirmation_alert_test2() {

         // 3. Click to “Click for JS Confirm” button
        WebElement confirmationAlert = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        confirmationAlert.click();


        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();


        // 5. Verify “You clicked: Ok” text is displayed

        WebElement verifyText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(verifyText.isDisplayed());

        String expectedText = "You clicked: Ok";
        String actualText = verifyText.getText();

        Assert.assertEquals(actualText, expectedText,"Text displayed is NOT as expected!!");

    }



}
