package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(5000);

        //every window has some id, this id calls window handle

        String windowHandle = driver.getWindowHandle();

        System.out.println("windowHandle = " + windowHandle);
        Set<String> windowsHandles = driver.getWindowHandles();
        System.out.println(windowsHandles);

        //since we have all windows
        //and we know id of original window
        //we can say switch to something that is not equals to old window id

        for (String windowId: windowsHandles) {
            if (!windowId.equals((windowHandle))) {
                //to jump to new window
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("After switch: "+driver.getCurrentUrl());

driver.close();

    }

    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
}
}
