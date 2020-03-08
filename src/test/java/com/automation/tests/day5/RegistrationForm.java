package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");

        BrowserUtils.wait(5);

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Denis");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Pupkov");

        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("denispupkov");

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("denis.pupkov@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("12345678");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("646-777-4433");

        List<WebElement> genders = driver.findElements(By.name("gender"));
        genders.get(0).click();

        driver.findElement(By.name("birthday")).sendKeys("01/01/1999");

        driver.findElement(By.id("inclineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(4);

        WebElement language = driver.findElement(By.id("inlineCheckbox2"));
        language.click();

        //add validation part






    }
}
