package com.automation.tests.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumOH2 {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://automationpractice.com");
        driver.findElement(By.id("search_query_top")).sendKeys("tshirt"+ Keys.ENTER);
        //driver.findElement(By.name("submit_search")).submit();
        Thread.sleep(3000);

        WebElement element = driver.findElement(By.className("heading-counter"));
        if (element.getText().equalsIgnoreCase("0 results have been found.")) {
            driver.findElement(By.id("search_query_top")).clear();
            Thread.sleep(3000);
            driver.findElement(By.id("search_query_top")).sendKeys("t-shirt",Keys.ENTER);
            //driver.findElement(By.name("submit_search")).submit();
            WebElement element2 = driver.findElement(By.className("heading-counter"));
            if (element2.getText().equalsIgnoreCase("1 result has been found.")) {
               WebElement addToCart =  driver.findElement(By.className("button ajax_add_to_cart_button btn btn-default"));
            Thread.sleep(2000);
               addToCart.click();

                System.out.println("PASSED!!!");

            }
        else {
                System.out.println("FAILED!!!");
            }
        }



    }
}
