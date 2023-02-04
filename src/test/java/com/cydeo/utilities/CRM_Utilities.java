package com.cydeo.utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
This class will store the method related to CRM project.

 */
public class CRM_Utilities {

    /*
    This method will login_crm using below credentials
    @Username = helpdesk1@cydeo.com
    @Password = UserUser
     */


    public static void login_crm(WebDriver driver){

        //3. Enter valid username

        WebElement enterUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        enterUsername.sendKeys("helpdesk1@cydeo.com");

        //4. Enter valid password
        WebElement enterUserPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        enterUserPassword.sendKeys("UserUser");


        //5. Click to `Log In` button

        WebElement LoginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        LoginButton.click();


    }


    public static void login_crm(WebDriver driver, String username, String password){

        //3. Enter valid username

        WebElement enterUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        enterUsername.sendKeys(username);

        //4. Enter valid password
        WebElement enterUserPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        enterUserPassword.sendKeys(password);


        //5. Click to `Log In` button

        WebElement LoginButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        LoginButton.click();



    }

}
