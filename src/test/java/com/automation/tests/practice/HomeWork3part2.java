package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork3part2 {
WebDriver driver;

    @Test
    public void tempMailAddress () {
        String email= driver.findElement(By.xpath("//span[@id='email']")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("Denis P");
        driver.findElement(By.name("email")).sendKeys(email);
        BrowserUtils.wait(3);
        driver.findElement(By.name("wooden_spoon")).click();
        BrowserUtils.wait(3);
        String actual = driver.findElement(By.xpath("//h3")).getText();
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        Assert.assertEquals(actual,expected);
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        BrowserUtils.wait(3);
        driver.findElement(By.cssSelector("tbody[id='schranka'] > *:first-child")).click();
        BrowserUtils.wait(3);
        String actualEmail2 = driver.findElement(By.id("odesilatel")).getText();
        String actualSubject2=driver.findElement(By.id("predmet")).getText();
        String expectedEmail2 = "do-not-reply@practice.cybertekschool.com";
        String expectedSubject2 = "Thanks for subscribing to practice.cybertekschool.com!";

        Assert.assertEquals(actualEmail2,expectedEmail2);
        Assert.assertEquals(actualSubject2,expectedSubject2);

    }





    @BeforeMethod
        public void setup () {
            WebDriverManager.chromedriver().version("79").setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://tempmailaddress.com/");



        }

//        @AfterMethod
//        public void teardown () {
//            driver.close();
//        }

    }

