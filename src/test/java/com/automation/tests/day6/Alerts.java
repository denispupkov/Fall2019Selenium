package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click();
        BrowserUtils.wait(3);

        String poputText = driver.switchTo().alert().getText();
        System.out.println(poputText);
        driver.switchTo().alert().accept();

        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();
        System.out.println("TEST #1");
        if (expected.equals(actual)) {
            System.out.println("Test Passed");
        }
else {
            System.out.println("Test Failed");
            System.out.println("Expected :"+expected);
            System.out.println("Actual:   "+actual);

        }
        BrowserUtils.wait(3);

        buttons.get(1).click();
        BrowserUtils.wait(3);
        driver.switchTo().alert().dismiss(); //click cancel
        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();
        System.out.println("TEST #2");
                if (expected2.equals(actual2)) {
                    System.out.println("Test PASSED");
                }
else {
                    System.out.println("Test FAILED");
                    System.out.println("Expected :"+expected2);
                    System.out.println("Actual:   "+actual2);
                }

        buttons.get(2).click();
        BrowserUtils.wait(3);
        driver.switchTo().alert().sendKeys("Hello World!");
        driver.switchTo().alert().accept();
        String expected3 = "You entered: Hello World!";
        String actual3 = driver.findElement(By.id("result")).getText();
        System.out.println("TEST #3");

        if (expected3.equals(actual3)) {
            System.out.println("Test PASSED");
        }
        else {
            System.out.println("Test FAILED");
            System.out.println("Expected :"+expected3);
            System.out.println("Actual:   "+actual3);
        }

        BrowserUtils.wait(3);
        driver.quit();

    }
}
