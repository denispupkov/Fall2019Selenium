package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {

    public static void main(String[] args) throws InterruptedException {
        //to start selenium script we need setup webdriver and create webdriver object

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //in selenium everything starts from webdriver interface

driver.get("http://google.com");//to open a website

        Thread.sleep(3000);//exception declared

        String title = driver.getTitle();//returns <title> some title </title>
        String expectedTitle = "Google";

        if (expectedTitle.equals(title)) {
            System.out.println("Test passed");
        }
        else {
            System.out.println("Test failed");
        }
        driver.close();//to close browser



    }
}
