package com.cydeo.tests.day06_alert_iframes_window;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_window_handle_test {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/windows");


    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


    @Test
    public void multipleWindowsTest_test() {


        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        String mainHandel = driver.getWindowHandle();
        System.out.println("mainHandel = " + mainHandel);

        // 5. Click to: “Click Here” link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        System.out.println("Title after click: " + driver.getTitle());

        // 6. Switch to new Window.
        // driver.getWindowHandles();
        //1- windowHandle" : mainHandle
        //2- windowHandle : 2end window

        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());
        }


        //7. Assert: Title is “New Window”

        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitleAfterClick);

        //if we have to go back to main page to continue our test case, we can use main handle to switch .

        driver.switchTo().window(mainHandel);
        //code
    }

}
