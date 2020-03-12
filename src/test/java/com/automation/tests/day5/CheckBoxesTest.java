package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        DriverFactory.createDriver("chrome");

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(3);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        if (!checkBoxes.get(0).isSelected() && (checkBoxes.get(1).isSelected())) {

            System.out.println("Test Passed");
        }
else {
            System.out.println("Test Failed");
        }
BrowserUtils.wait(2);

checkBoxes.get(0).click();
        BrowserUtils.wait(2);

if (checkBoxes.get(0).isSelected()) {
    System.out.println("Test Passed");
    System.out.println("Checkbox 1 is selected");
}
else {
    System.out.println("Test Failed");
    System.out.println("Checkbox 1 is not selected");
    System.out.println("");
}




driver.quit();

    }
}
