package com.cydeo.tests.review.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();

        // WebDriverManager.edgedriver().setup();

        WebDriver driver = new ChromeDriver();
        //WebDriver driver1 = new EdgeDriver();

        driver.manage().window().maximize();


        driver.get("https://www.tesla.com");
        //driver1.get("https://www.tesla.com");

        Thread.sleep(3000);

        driver.navigate().to("https://www.etsy.com");

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.navigate().refresh();

        Thread.sleep(3000);

        //driver.close();

        driver.quit();


    }

}
