package com.automation.tests.day13;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigurationReaderTest {


    @Test
    public void readProperties () {
        String browser = ConfigurationReader.getProperty("browser");
        String url = ConfigurationReader.getProperty("qa1");
        System.out.println(browser);
        System.out.println(url);
        System.out.println(ConfigurationReader.getProperty("color"));

        String storeManager = ConfigurationReader.getProperty("store_manager");
        String password = ConfigurationReader.getProperty("password");
        String driver = ConfigurationReader.getProperty("driver");


        System.out.println(storeManager);

        System.out.println(password);
        System.out.println(driver);
    }
}
