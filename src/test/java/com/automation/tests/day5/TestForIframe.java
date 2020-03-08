package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForIframe {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(4);

        driver.switchTo().frame("mce_0_ifr");  //IMPORTANT!!!!!! STEP 1 to see the iFrame content

        WebElement textInput = driver.findElement(By.id("tinymce"));
        System.out.println(textInput.getText());

        BrowserUtils.wait(4);
        textInput.clear();
        textInput.sendKeys("Hello World!");

        BrowserUtils.wait(4);

        driver.switchTo().defaultContent();// IMPORTANT!!!!!! STEP 2 To switch back to normal view

        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println("heading = " + heading.getText());

        driver.quit();
    }
}
