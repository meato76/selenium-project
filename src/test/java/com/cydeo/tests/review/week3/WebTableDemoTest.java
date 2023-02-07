package com.cydeo.tests.review.week3;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableDemoTest extends TestBase {


    @Test
    public void read_from_table_test() {

        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/tables
        driver.get(ConfigurationReader.getProperty("webtable.url"));


        // 3. Print table data as a single String, not so common, but useful sometimes
        WebElement table1 = driver.findElement(By.id("table1"));
        System.out.println("table1.getText() = " + table1.getText());


        // 4. verify tconway@earthlink.net is anywhere in the table
        Assert.assertTrue(table1.getText().contains("tconway@earthlink.net"));


        // 5. print all column names in single line
        WebElement allCollNames = driver.findElement(By.xpath("//table[@id='table1']/thead/tr"));


        // 6. print each column name in separate lines using a loop and findElements method
        List<WebElement> colNamesList = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));
        System.out.println("colNamesList.size() = " + colNamesList.size());

        for (WebElement eachCol : colNamesList) {
            System.out.println("eachCol.getText() = " + eachCol.getText());

        }
    }
}