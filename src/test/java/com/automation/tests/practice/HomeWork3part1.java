package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomeWork3part1 {
   private static WebDriver driver;

        @Test
        public void testCase1 () {

        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        String expected = "The date of birth is not valid";
        String actual = driver.findElement(By.xpath("//small[text()='The date of birth is not valid']")).getText();
        Assert.assertEquals(actual,expected);

    }
        @Test
        public void testCase2 () {

       WebElement cPlusPlusCheckbox = driver.findElement(By.id("inlineCheckbox1"));
       WebElement javaCheckbox = driver.findElement(By.id("inlineCheckbox2"));
       WebElement javascriptCheckbox = driver.findElement(By.id("inlineCheckbox3"));

       Assert.assertTrue(cPlusPlusCheckbox.isDisplayed());
       Assert.assertTrue(javaCheckbox.isDisplayed());
       Assert.assertTrue(javascriptCheckbox.isDisplayed());
}
        @Test
        public void testCase3 () {
            driver.findElement(By.name("firstname")).sendKeys("a");
            BrowserUtils.wait(3);
            String actual = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']")).getText();
            String expected = "first name must be more than 2 and less than 64 characters long";
            Assert.assertEquals(actual,expected);
        }

        @Test
        public void testCase4 () {
            driver.findElement(By.name("lastname")).sendKeys("a");
            BrowserUtils.wait(3);
            String actual = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']")).getText();
            String expected = "The last name must be more than 2 and less than 64 characters long";
            Assert.assertEquals(actual,expected);

        }

        @Test
        public void testCase5 () {
            driver.findElement(By.name("firstname")).sendKeys("Denis");
            driver.findElement(By.name("lastname")).sendKeys("Pupkov");
            driver.findElement(By.name("username")).sendKeys("denispupkov");
            driver.findElement(By.name("email")).sendKeys("asd@mjbkj.com");
            driver.findElement(By.name("password")).sendKeys("1234asdf");
            driver.findElement(By.name("phone")).sendKeys("123-111-2222");
            driver.findElement(By.xpath("//input[@value='male']")).click();
            driver.findElement(By.name("birthday")).sendKeys("10/14/1979");
            Select select = new Select(driver.findElement(By.name("department")));
            select.selectByVisibleText("Department of Agriculture");
            Select select2 = new Select (driver.findElement(By.name("job_title")));
            select2.selectByVisibleText("QA");
            BrowserUtils.wait(1);
            driver.findElement(By.id("inlineCheckbox2")).click();
            BrowserUtils.wait(1);
            driver.findElement(By.id("wooden_spoon")).click();
            BrowserUtils.wait(3);
            String actual = driver.findElement(By.xpath("//h4//following-sibling ::p")).getText();
            String expected = "You've successfully completed registration!";
            Assert.assertEquals(actual,expected);


        }


   @BeforeMethod
    public void setup () {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
       driver.get("https://practice-cybertekschool.herokuapp.com");
       BrowserUtils.wait(3);
       driver.findElement(By.linkText("Registration Form")).click();
       BrowserUtils.wait(3);


    }

    @AfterMethod
    public void teardown () {
        driver.close();
    }

}
