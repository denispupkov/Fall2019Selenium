package com.automation.tests.practice;

import com.automation.tests.day13.SystemProperties;
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class HomeWork3part3 {
    private static WebDriver driver;

    @Test
    public void testCase7 () {
        String routeToFile = System.getProperty("user.home")+"/Downloads/class note.txt";
        driver.findElement(By.linkText("File Upload")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.id("file-upload")).sendKeys(routeToFile);
        BrowserUtils.wait(2);
        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(1);
        String actual = driver.findElement(By.xpath("//h3")).getText();
        String expected = "File Uploaded!";

        Assert.assertEquals(actual,expected);

        WebElement fileUploaded = driver.findElement(By.id("uploaded-files"));
        Assert.assertTrue(fileUploaded.isDisplayed());

    }

    @Test
    public void testCase8 () {

        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//input[@type='button']")).click();

        BrowserUtils.wait(3);
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed());

    }


    @Test
    public void testCase9 () {

        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("200")).click();
        String expected = "This page returned a 200 status code.";
        String result = driver.findElement(By.xpath("//p[contains(text(),'status code')]")).getText();
        String actual= result.substring(0,result.indexOf(".")+1);

        Assert.assertEquals(actual,expected);
    }


    @Test
    public void testCase10 () {

        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("301")).click();
        String expected = "This page returned a 301 status code.";
        String result = driver.findElement(By.xpath("//p[contains(text(),'status code')]")).getText();
        String actual = result.substring(0, result.indexOf(".") + 1);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCase11 () {

        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("404")).click();
        String expected = "This page returned a 404 status code.";
        String result = driver.findElement(By.xpath("//p[contains(text(),'status code')]")).getText();
        String actual = result.substring(0, result.indexOf(".") + 1);

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testCase12 () {

        driver.findElement(By.linkText("Status Codes")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("500")).click();
        String expected = "This page returned a 500 status code.";
        String result = driver.findElement(By.xpath("//p[contains(text(),'status code')]")).getText();
        String actual = result.substring(0, result.indexOf(".") + 1);

        Assert.assertEquals(actual, expected);

    }



    @BeforeMethod
    public void setup () {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        BrowserUtils.wait(3);

    }

    @AfterMethod
    public void teardown () {
        //driver.close();
    }

}




