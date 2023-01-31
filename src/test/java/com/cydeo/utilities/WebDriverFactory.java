package com.cydeo.utilities;


//TASK : NEW METHOD
//Method name :getDriver
//Static method
//Accept  String arg:browserType
//  -This arg will determine what type of browser is open
//  -if "chrome" passed --> it open Chrome browser
//  -if "firefox" passed --> it will open firefox browser

// RETURN TYPE: "WebDriverFactory"

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {


    public static WebDriver getDriver(String browserType){

        if (browserType.equalsIgnoreCase("chrome")){

            WebDriverManager.chromedriver().setup();
            return  new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else {
            System.out.println("Given string doesn't represent any browser");
            System.out.println("Either that browser does not exist or not currently supported.");
            System.out.println("driver = null");
            return null;
        }
    }

}
